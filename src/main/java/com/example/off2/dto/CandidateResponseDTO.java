package com.example.off2.dto;

import com.example.off2.model.Education;
import com.example.off2.model.FamilyMember;
import com.example.off2.model.LanguageKnown;
import com.example.off2.model.Reference;

import java.time.LocalDate;
import java.util.List;

public class CandidateResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private String state;
    private LocalDate dob;
    private String alternateMobile;
    private String placeOfBirth;
    private String religion;
    private String nationality;
    private String fatherName;
    private String motherName;
    private String maritalStatus;
    private LocalDate marriageDate;
    private Integer childrenCount;
    private String permanentAddress;

    private String height;
    private String weight;
    private String identificationMarks;
    private String eyesight;
    private String bloodGroup;
    private String disability;
    private String illness;
    private String illnessName;
    private String illnessDuration;

    private String pan;
    private String bankName;
    private String ifsc;
    private String branch;

    private Integer expYears;
    private Integer expMonths;
    private LocalDate expFrom;
    private LocalDate expTo;

    private String strengths;
    private String weaknesses;
    private String valuesContent;

    private String memberOfProfessionalBody;
    private String professionalBodyDetails;
    private String specialHonors;
    private String specialHonorsDetails;

    private String loanAvailed;
    private String loanPurpose;
    private Double loanAmount;
    private Double loanBalance;
    private Double loanSalary;

    private Integer joiningDays;
    private Double monthlyTotal;
    private Double annualTotal;

    private String signatureBase64;
    private String declaration;
    private LocalDate declDate;
    private String declPlace;
    private String mediclaimConsent;

    private String hrEmail;
    private Double offeredCtc;
    private Double ctcBasic;
    private Double ctcHra;
    private Double ctcOther;
    private String ctcRemarks;
    private Boolean ctcReviewDone;

    // Additional Form Fields
    private String academicAchieved;
    private String publicationsDetails;
    private String activityLiterary;
    private String activitySports;
    private String activityHobbies;
    private String motherTongue;

    private String uan;
    private String companyName;
    private String designation;
    private String reportingTo;
    private String jobResponsibilities;
    private Double grossSalaryLeaving;
    private String reasonForLeaving;

    private String assignmentCompany;
    private String assignmentProducts;
    private String assignmentTerritory;
    private String assignmentContribution;

    // Salary Breakdown
    private Double salary_basic;
    private Double salary_da;
    private Double salary_conveyance;
    private Double salary_education;
    private Double salary_hra;
    private Double salary_lta;
    private Double salary_medical;
    private Double salary_bonus;
    private Double salary_pf;
    private Double salary_gratuity;
    private Double salary_superannuation;
    private Double totalA;
    private Double totalB;
    private Double totalC;
    private String otherPerquisites;

    private String objectionToRefer;

    // Interview
    private String interviewedBefore;
    private LocalDate interviewDate;
    private String interviewPlace;
    private String interviewerName;
    private String interviewPost;

    // 🔐 Masked fields
    private String aadhaar;
    private String bankAccount;

    private List<FamilyMember> familyMembers;
    private List<Education> educations;
    private List<LanguageKnown> languages;
    private List<Reference> ref;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIdentificationMarks() {
        return identificationMarks;
    }

    public void setIdentificationMarks(String identificationMarks) {
        this.identificationMarks = identificationMarks;
    }

    public String getEyesight() {
        return eyesight;
    }

    public void setEyesight(String eyesight) {
        this.eyesight = eyesight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public String getIllnessDuration() {
        return illnessDuration;
    }

    public void setIllnessDuration(String illnessDuration) {
        this.illnessDuration = illnessDuration;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getExpYears() {
        return expYears;
    }

    public void setExpYears(Integer expYears) {
        this.expYears = expYears;
    }

    public Integer getExpMonths() {
        return expMonths;
    }

    public void setExpMonths(Integer expMonths) {
        this.expMonths = expMonths;
    }

    public LocalDate getExpFrom() {
        return expFrom;
    }

    public void setExpFrom(LocalDate expFrom) {
        this.expFrom = expFrom;
    }

    public LocalDate getExpTo() {
        return expTo;
    }

    public void setExpTo(LocalDate expTo) {
        this.expTo = expTo;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getValuesContent() {
        return valuesContent;
    }

    public void setValuesContent(String valuesContent) {
        this.valuesContent = valuesContent;
    }

    public String getMemberOfProfessionalBody() {
        return memberOfProfessionalBody;
    }

    public void setMemberOfProfessionalBody(String memberOfProfessionalBody) {
        this.memberOfProfessionalBody = memberOfProfessionalBody;
    }

    public String getProfessionalBodyDetails() {
        return professionalBodyDetails;
    }

    public void setProfessionalBodyDetails(String professionalBodyDetails) {
        this.professionalBodyDetails = professionalBodyDetails;
    }

    public String getSpecialHonors() {
        return specialHonors;
    }

    public void setSpecialHonors(String specialHonors) {
        this.specialHonors = specialHonors;
    }

    public String getSpecialHonorsDetails() {
        return specialHonorsDetails;
    }

    public void setSpecialHonorsDetails(String specialHonorsDetails) {
        this.specialHonorsDetails = specialHonorsDetails;
    }

    public String getLoanAvailed() {
        return loanAvailed;
    }

    public void setLoanAvailed(String loanAvailed) {
        this.loanAvailed = loanAvailed;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Double getLoanSalary() {
        return loanSalary;
    }

    public void setLoanSalary(Double loanSalary) {
        this.loanSalary = loanSalary;
    }

    public Integer getJoiningDays() {
        return joiningDays;
    }

    public void setJoiningDays(Integer joiningDays) {
        this.joiningDays = joiningDays;
    }

    public Double getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(Double monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }

    public Double getAnnualTotal() {
        return annualTotal;
    }

    public void setAnnualTotal(Double annualTotal) {
        this.annualTotal = annualTotal;
    }

    public String getSignatureBase64() {
        return signatureBase64;
    }

    public void setSignatureBase64(String signatureBase64) {
        this.signatureBase64 = signatureBase64;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public LocalDate getDeclDate() {
        return declDate;
    }

    public void setDeclDate(LocalDate declDate) {
        this.declDate = declDate;
    }

    public String getDeclPlace() {
        return declPlace;
    }

    public void setDeclPlace(String declPlace) {
        this.declPlace = declPlace;
    }

    public String getMediclaimConsent() {
        return mediclaimConsent;
    }

    public void setMediclaimConsent(String mediclaimConsent) {
        this.mediclaimConsent = mediclaimConsent;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    public Double getOfferedCtc() {
        return offeredCtc;
    }

    public void setOfferedCtc(Double offeredCtc) {
        this.offeredCtc = offeredCtc;
    }

    public Double getCtcBasic() {
        return ctcBasic;
    }

    public void setCtcBasic(Double ctcBasic) {
        this.ctcBasic = ctcBasic;
    }

    public Double getCtcHra() {
        return ctcHra;
    }

    public void setCtcHra(Double ctcHra) {
        this.ctcHra = ctcHra;
    }

    public Double getCtcOther() {
        return ctcOther;
    }

    public void setCtcOther(Double ctcOther) {
        this.ctcOther = ctcOther;
    }

    public String getCtcRemarks() {
        return ctcRemarks;
    }

    public void setCtcRemarks(String ctcRemarks) {
        this.ctcRemarks = ctcRemarks;
    }

    public Boolean getCtcReviewDone() {
        return ctcReviewDone;
    }

    public void setCtcReviewDone(Boolean ctcReviewDone) {
        this.ctcReviewDone = ctcReviewDone;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<LanguageKnown> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageKnown> languages) {
        this.languages = languages;
    }

    public List<Reference> getRef() {
        return ref;
    }

    public void setRef(List<Reference> ref) {
        this.ref = ref;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getAcademicAchieved() {
        return academicAchieved;
    }

    public void setAcademicAchieved(String academicAchieved) {
        this.academicAchieved = academicAchieved;
    }

    public String getPublicationsDetails() {
        return publicationsDetails;
    }

    public void setPublicationsDetails(String publicationsDetails) {
        this.publicationsDetails = publicationsDetails;
    }

    public String getActivityLiterary() {
        return activityLiterary;
    }

    public void setActivityLiterary(String activityLiterary) {
        this.activityLiterary = activityLiterary;
    }

    public String getActivitySports() {
        return activitySports;
    }

    public void setActivitySports(String activitySports) {
        this.activitySports = activitySports;
    }

    public String getActivityHobbies() {
        return activityHobbies;
    }

    public void setActivityHobbies(String activityHobbies) {
        this.activityHobbies = activityHobbies;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getUan() {
        return uan;
    }

    public void setUan(String uan) {
        this.uan = uan;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(String reportingTo) {
        this.reportingTo = reportingTo;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public Double getGrossSalaryLeaving() {
        return grossSalaryLeaving;
    }

    public void setGrossSalaryLeaving(Double grossSalaryLeaving) {
        this.grossSalaryLeaving = grossSalaryLeaving;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

    public String getAssignmentCompany() {
        return assignmentCompany;
    }

    public void setAssignmentCompany(String assignmentCompany) {
        this.assignmentCompany = assignmentCompany;
    }

    public String getAssignmentProducts() {
        return assignmentProducts;
    }

    public void setAssignmentProducts(String assignmentProducts) {
        this.assignmentProducts = assignmentProducts;
    }

    public String getAssignmentTerritory() {
        return assignmentTerritory;
    }

    public void setAssignmentTerritory(String assignmentTerritory) {
        this.assignmentTerritory = assignmentTerritory;
    }

    public String getAssignmentContribution() {
        return assignmentContribution;
    }

    public void setAssignmentContribution(String assignmentContribution) {
        this.assignmentContribution = assignmentContribution;
    }

    public Double getSalary_basic() {
        return salary_basic;
    }

    public void setSalary_basic(Double salary_basic) {
        this.salary_basic = salary_basic;
    }

    public Double getSalary_da() {
        return salary_da;
    }

    public void setSalary_da(Double salary_da) {
        this.salary_da = salary_da;
    }

    public Double getSalary_conveyance() {
        return salary_conveyance;
    }

    public void setSalary_conveyance(Double salary_conveyance) {
        this.salary_conveyance = salary_conveyance;
    }

    public Double getSalary_education() {
        return salary_education;
    }

    public void setSalary_education(Double salary_education) {
        this.salary_education = salary_education;
    }

    public Double getSalary_hra() {
        return salary_hra;
    }

    public void setSalary_hra(Double salary_hra) {
        this.salary_hra = salary_hra;
    }

    public Double getSalary_lta() {
        return salary_lta;
    }

    public void setSalary_lta(Double salary_lta) {
        this.salary_lta = salary_lta;
    }

    public Double getSalary_medical() {
        return salary_medical;
    }

    public void setSalary_medical(Double salary_medical) {
        this.salary_medical = salary_medical;
    }

    public Double getSalary_bonus() {
        return salary_bonus;
    }

    public void setSalary_bonus(Double salary_bonus) {
        this.salary_bonus = salary_bonus;
    }

    public Double getSalary_pf() {
        return salary_pf;
    }

    public void setSalary_pf(Double salary_pf) {
        this.salary_pf = salary_pf;
    }

    public Double getSalary_gratuity() {
        return salary_gratuity;
    }

    public void setSalary_gratuity(Double salary_gratuity) {
        this.salary_gratuity = salary_gratuity;
    }

    public Double getSalary_superannuation() {
        return salary_superannuation;
    }

    public void setSalary_superannuation(Double salary_superannuation) {
        this.salary_superannuation = salary_superannuation;
    }

    public Double getTotalA() {
        return totalA;
    }

    public void setTotalA(Double totalA) {
        this.totalA = totalA;
    }

    public Double getTotalB() {
        return totalB;
    }

    public void setTotalB(Double totalB) {
        this.totalB = totalB;
    }

    public Double getTotalC() {
        return totalC;
    }

    public void setTotalC(Double totalC) {
        this.totalC = totalC;
    }

    public String getOtherPerquisites() {
        return otherPerquisites;
    }

    public void setOtherPerquisites(String otherPerquisites) {
        this.otherPerquisites = otherPerquisites;
    }

    public String getObjectionToRefer() {
        return objectionToRefer;
    }

    public void setObjectionToRefer(String objectionToRefer) {
        this.objectionToRefer = objectionToRefer;
    }

    public String getInterviewedBefore() {
        return interviewedBefore;
    }

    public void setInterviewedBefore(String interviewedBefore) {
        this.interviewedBefore = interviewedBefore;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewPlace() {
        return interviewPlace;
    }

    public void setInterviewPlace(String interviewPlace) {
        this.interviewPlace = interviewPlace;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getInterviewPost() {
        return interviewPost;
    }

    public void setInterviewPost(String interviewPost) {
        this.interviewPost = interviewPost;
    }
}
