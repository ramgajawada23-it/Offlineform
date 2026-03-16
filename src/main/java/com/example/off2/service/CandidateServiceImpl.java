package com.example.off2.service;

import com.example.off2.dto.CandidateResponseDTO;
import com.example.off2.model.Candidate;
import com.example.off2.repository.CandidateRepository;
import com.example.off2.util.MaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Objects;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.base-url}")
    private String baseUrl;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {

        // Back-references are handled by setters in Candidate model
        // The Candidate model's setters for familyMembers and educations should handle
        // setting the candidate reference.
        // If not, these explicit loops are necessary. Assuming they are handled by the
        // model's setters or cascade.
        // However, the instruction explicitly includes the educations loop, so I'll
        // keep that.
        if (candidate.getFamilyMembers() != null) {
            candidate.getFamilyMembers()
                    .forEach(f -> f.setCandidate(candidate));
        }

        if (candidate.getEducations() != null) {
            candidate.getEducations()
                    .forEach(e -> e.setCandidate(candidate));
        }

        if (candidate.getLanguages() != null) {
            candidate.getLanguages()
                    .forEach(l -> l.setCandidate(candidate));
        }

        if (candidate.getRef() != null) {
            candidate.getRef()
                    .forEach(r -> r.setCandidate(candidate));
        }

        Candidate saved = repository.save(candidate);

        // 🔔 Notify HR that candidate has submitted the form
        try {
            String hrEmail = candidate.getHrEmail();
            if (hrEmail != null && !hrEmail.isBlank()) {
                sendHrNotification(hrEmail, saved);
            }
        } catch (Exception e) {
            System.err.println("HR notification email failed: " + e.getMessage());
        }

        return saved;
    }

    private void sendHrNotification(String hrEmail, Candidate c) throws Exception {
        jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(Objects.requireNonNull(hrEmail));
        helper.setSubject("✅ Form Submitted – " + c.getFullName());

        String reviewUrl = baseUrl + "/hr-dashboard.html";

        String html = "<html><body style='font-family:Arial,sans-serif;color:#333;'>" +
                "<div style='max-width:600px;margin:0 auto;border:1px solid #eee;padding:24px;border-radius:10px;'>" +
                "<h2 style='color:#1c486e;'>Candidate Form Submitted</h2>" +
                "<p>The following candidate has completed and submitted their onboarding form:</p>" +
                "<table style='border-collapse:collapse;width:100%;margin:16px 0;'>" +
                "<tr><td style='padding:8px;background:#f8fafc;font-weight:600;'>Name</td><td style='padding:8px;'>"
                + c.getFullName() + "</td></tr>" +
                "<tr><td style='padding:8px;background:#f8fafc;font-weight:600;'>Mobile</td><td style='padding:8px;'>"
                + c.getPhone() + "</td></tr>" +
                "<tr><td style='padding:8px;background:#f8fafc;font-weight:600;'>Email</td><td style='padding:8px;'>"
                + c.getEmail() + "</td></tr>" +
                "</table>" +
                "<div style='text-align:center;margin:24px 0;'>" +
                "<a href='" + reviewUrl
                + "' style='background:#1c486e;color:white;padding:12px 28px;text-decoration:none;border-radius:8px;font-weight:bold;display:inline-block;'>Open HR Dashboard for CTC Review</a>"
                +
                "</div>" +
                "<p style='font-size:12px;color:#999;'>This is an automated notification from the Natco Onboarding System.</p>"
                +
                "</div></body></html>";

        helper.setText(html, true);
        mailSender.send(mimeMessage);
    }

    @Override
    public List<CandidateResponseDTO> getAllCandidates() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CandidateResponseDTO getCandidateById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id cannot be null");
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        return mapToDTO(candidate);
    }

    @Override
    public Candidate updateCandidateCtc(Long id, Candidate ctcData) {
        Candidate candidate = repository.findById(Objects.requireNonNull(id))
                .orElseThrow(() -> new RuntimeException("Candidate not found: " + id));

        // Only update CTC fields — never overwrite candidate's own data
        if (ctcData.getOfferedCtc() != null)
            candidate.setOfferedCtc(ctcData.getOfferedCtc());
        if (ctcData.getCtcBasic() != null)
            candidate.setCtcBasic(ctcData.getCtcBasic());
        if (ctcData.getCtcHra() != null)
            candidate.setCtcHra(ctcData.getCtcHra());
        if (ctcData.getCtcOther() != null)
            candidate.setCtcOther(ctcData.getCtcOther());
        if (ctcData.getCtcRemarks() != null)
            candidate.setCtcRemarks(ctcData.getCtcRemarks());
        if (ctcData.getCtcReviewDone() != null)
            candidate.setCtcReviewDone(ctcData.getCtcReviewDone());

        return repository.save(Objects.requireNonNull(candidate));
    }

    @Override
    public Optional<Candidate> findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    private CandidateResponseDTO mapToDTO(Candidate c) {
        CandidateResponseDTO dto = new CandidateResponseDTO();
        dto.setId(c.getId());
        dto.setFullName(c.getFullName());
        dto.setEmail(c.getEmail());
        dto.setPhone(c.getPhone());
        dto.setGender(c.getGender());
        dto.setState(c.getState());
        dto.setDob(c.getDob());

        // Basic Info
        dto.setAlternateMobile(c.getAlternateMobile());
        dto.setPlaceOfBirth(c.getPlaceOfBirth());
        dto.setReligion(c.getReligion());
        dto.setNationality(c.getNationality());
        dto.setFatherName(c.getFatherName());
        dto.setMotherName(c.getMotherName());
        dto.setHusbandName(c.getHusbandName());
        dto.setMaritalStatus(c.getMaritalStatus());
        dto.setMarriageDate(c.getMarriageDate());
        dto.setChildrenCount(c.getChildrenCount());
        dto.setPermanentAddress(c.getPermanentAddress());

        // Health
        dto.setHeight(c.getHeight());
        dto.setWeight(c.getWeight());
        dto.setIdentificationMarks(c.getIdentificationMarks());
        dto.setEyesight(c.getEyesight());
        dto.setBloodGroup(c.getBloodGroup());
        dto.setDisability(c.getDisability());
        dto.setIllness(c.getIllness());
        dto.setIllnessName(c.getIllnessName());
        dto.setIllnessDuration(c.getIllnessDuration());

        // 🔐 MASK sensitive fields for public listing,
        // Note: Full form review normally uses the model directly or an unmasked DTO.
        // But for this DTO, we mask Aadhaar and Bank as per utility.
        dto.setAadhaar(MaskUtil.maskAadhaar(c.getAadhaar()));
        dto.setBankAccount(MaskUtil.maskBankAccount(c.getBankAccount()));

        dto.setPan(c.getPan()); // Masking can be added if needed
        dto.setBankName(c.getBankName());
        dto.setIfsc(c.getIfsc());
        dto.setBranch(c.getBranch());

        // Experience
        dto.setExpYears(c.getExpYears());
        dto.setExpMonths(c.getExpMonths());
        dto.setExpFrom(c.getExpFrom());
        dto.setExpTo(c.getExpTo());

        // Skills & Assessment
        dto.setStrengths(c.getStrengths());
        dto.setWeaknesses(c.getWeaknesses());
        dto.setValuesContent(c.getValuesContent());
        dto.setMemberOfProfessionalBody(c.getMemberOfProfessionalBody());
        dto.setProfessionalBodyDetails(c.getProfessionalBodyDetails());
        dto.setSpecialHonors(c.getSpecialHonors());
        dto.setSpecialHonorsDetails(c.getSpecialHonorsDetails());

        // Loan & Misc
        dto.setLoanAvailed(c.getLoanAvailed());
        dto.setLoanPurpose(c.getLoanPurpose());
        dto.setLoanAmount(c.getLoanAmount());
        dto.setLoanBalance(c.getLoanBalance());
        dto.setLoanSalary(c.getLoanSalary());
        dto.setJoiningDays(c.getJoiningDays());
        dto.setMonthlyTotal(c.getMonthlyTotal());
        dto.setAnnualTotal(c.getAnnualTotal());

        // Signs & Declaration
        dto.setSignatureBase64(c.getSignatureBase64());
        dto.setDeclaration(c.getDeclaration());
        dto.setDeclDate(c.getDeclDate());
        dto.setDeclPlace(c.getDeclPlace());
        dto.setMediclaimConsent(c.getMediclaimConsent());

        // HR Review Info
        dto.setHrEmail(c.getHrEmail());
        dto.setOfferedCtc(c.getOfferedCtc());
        dto.setCtcBasic(c.getCtcBasic());
        dto.setCtcHra(c.getCtcHra());
        dto.setCtcOther(c.getCtcOther());
        dto.setCtcRemarks(c.getCtcRemarks());
        dto.setCtcReviewDone(c.getCtcReviewDone());

        // Additional Fields
        dto.setAcademicAchieved(c.getAcademicAchieved());
        dto.setPublicationsDetails(c.getPublicationsDetails());
        dto.setActivityLiterary(c.getActivityLiterary());
        dto.setActivitySports(c.getActivitySports());
        dto.setActivityHobbies(c.getActivityHobbies());
        dto.setMotherTongue(c.getMotherTongue());

        dto.setUan(c.getUan());
        dto.setCompanyName(c.getCompanyName());
        dto.setDesignation(c.getDesignation());
        dto.setReportingTo(c.getReportingTo());
        dto.setJobResponsibilities(c.getJobResponsibilities());
        dto.setGrossSalaryLeaving(c.getGrossSalaryLeaving());
        dto.setReasonForLeaving(c.getReasonForLeaving());

        dto.setAssignmentCompany(c.getAssignmentCompany());
        dto.setAssignmentProducts(c.getAssignmentProducts());
        dto.setAssignmentTerritory(c.getAssignmentTerritory());
        dto.setAssignmentContribution(c.getAssignmentContribution());

        // Salary Breakdown
        dto.setSalary_basic(c.getSalary_basic());
        dto.setSalary_da(c.getSalary_da());
        dto.setSalary_conveyance(c.getSalary_conveyance());
        dto.setSalary_education(c.getSalary_education());
        dto.setSalary_hra(c.getSalary_hra());
        dto.setSalary_lta(c.getSalary_lta());
        dto.setSalary_medical(c.getSalary_medical());
        dto.setSalary_bonus(c.getSalary_bonus());
        dto.setSalary_pf(c.getSalary_pf());
        dto.setSalary_gratuity(c.getSalary_gratuity());
        dto.setSalary_superannuation(c.getSalary_superannuation());
        dto.setTotalA(c.getTotalA());
        dto.setTotalB(c.getTotalB());
        dto.setTotalC(c.getTotalC());
        dto.setOtherPerquisites(c.getOtherPerquisites());
        
        dto.setOwnVehicle(c.getOwnVehicle());
        dto.setVehicleType(c.getVehicleType());
        dto.setVehicleRegNo(c.getVehicleRegNo());

        dto.setObjectionToRefer(c.getObjectionToRefer());

        // Interview
        dto.setInterviewedBefore(c.getInterviewedBefore());
        dto.setInterviewDate(c.getInterviewDate());
        dto.setInterviewPlace(c.getInterviewPlace());
        dto.setInterviewerName(c.getInterviewerName());
        dto.setInterviewPost(c.getInterviewPost());

        dto.setFamilyMembers(c.getFamilyMembers());
        dto.setEducations(c.getEducations());
        dto.setLanguages(c.getLanguages());
        dto.setRef(c.getRef());

        return dto;
    }
}
