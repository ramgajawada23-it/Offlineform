// Login.js
function showToast(message, type = "online") {
  const container = document.getElementById("toastContainer");
  if (!container) return;
  const toast = document.createElement("div");
  toast.className = `toast ${type}`;
  const icon = type === "online" ? "●" : "○";
  toast.innerHTML = `<span class="toast-icon">${icon}</span> <span>${message}</span>`;
  container.appendChild(toast);

  // Wait 10ms for DOM registration before showing
  setTimeout(() => toast.classList.add("show"), 10);

  setTimeout(() => {
    toast.classList.remove("show");
    setTimeout(() => toast.remove(), 500);
  }, 4000);
}

window.addEventListener("online", () => showToast("Connected", "online"));
window.addEventListener("offline", () => showToast("Working Offline", "offline"));

// Initial check
if (!navigator.onLine) {
  setTimeout(() => showToast("Working Offline", "offline"), 1000);
}

// Auto-fill mobile and check deadline from URL if present
window.addEventListener("DOMContentLoaded", () => {
  const params = new URLSearchParams(window.location.search);
  const mobileParam = params.get("mobile");
  const deadlineParam = params.get("deadline");

  if (deadlineParam) {
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const deadlineDate = new Date(deadlineParam);
    deadlineDate.setHours(23, 59, 59, 999); // Deadline is valid until the end of the day

    if (today > deadlineDate) {
      showToast("This link has expired. The completion deadline was " + deadlineParam, "offline");
      document.getElementById("loginForm").classList.add("disabled-form");
      const inputs = document.getElementById("loginForm").querySelectorAll("input, button");
      inputs.forEach(i => i.disabled = true);
      const title = document.querySelector(".login-title");
      if (title) title.innerText = "LINK EXPIRED";
      const subtitle = document.querySelector(".login-subtitle");
      if (subtitle) subtitle.innerText = "Please contact HR for a new onboarding link.";
      return;
    }
  }

  if (mobileParam && /^\d{10}$/.test(mobileParam)) {
    const mobileInput = document.getElementById("loginMobile");
    if (mobileInput) {
      mobileInput.value = mobileParam;
      mobileInput.style.backgroundColor = "#fff9db";
      showToast("Mobile pre-filled by HR", "online");
    }
  }

  // Capture name and email if present
  const nameParam = params.get("name");
  const emailParam = params.get("email");
  const hrEmailParam = params.get("hrEmail");
  if (nameParam) sessionStorage.setItem("prefilledName", nameParam);
  if (emailParam) sessionStorage.setItem("prefilledEmail", emailParam);
  if (hrEmailParam) sessionStorage.setItem("prefilledHrEmail", hrEmailParam);
});

document.getElementById("loginForm").onsubmit = async (e) => {
  e.preventDefault();

  const mobile = document.getElementById("loginMobile").value.trim();
  const error = document.querySelector(".error-text");

  if (!/^\d{10}$/.test(mobile)) {
    error.innerText = "Enter valid 10-digit mobile number";
    return;
  }

  error.innerText = "";

  const API_BASE = ""; // Use relative paths for IIS reverse proxy

  try {
    const res = await fetch(`${API_BASE}/api/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ mobile })
    });

    if (!res.ok) throw new Error("API error");

    const data = await res.json();

    sessionStorage.setItem("loggedInMobile", mobile);

    if (data.status === "DRAFT") {
      sessionStorage.setItem("serverDraft", JSON.stringify(data.draft));
      sessionStorage.setItem("formStatus", "DRAFT");
    } else if (data.status === "SUBMITTED") {
      sessionStorage.removeItem("serverDraft");
      sessionStorage.setItem("formStatus", "SUBMITTED");
    } else {
      sessionStorage.removeItem("serverDraft");
      sessionStorage.setItem("formStatus", "NEW");
    }

    window.location.href = "./index.html";

  } catch (err) {
    console.warn("Backend not ready, continuing frontend flow");

    // ✅ fallback so frontend still works
    sessionStorage.setItem("loggedInMobile", mobile);
    sessionStorage.setItem("formStatus", "NEW");
    window.location.href = "./index.html";
  }
};