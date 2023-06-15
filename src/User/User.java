package User;

public class User {
    private String fullName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String degree;
    private String institution;
    private String major;
    private String graduationYear;
    private String jobTitle;
    private String companyName;
    private String duration;
    private String jobResponsibilities;
    private String achievements;
    private String references;
    private String programmingLanguages;
    private String developmentTools;
    private String databases;
    private String webDevelopment;
    private String operatingSystems;

    public User(String text, String contactNoFieldText, String addressFieldText, String dateOfBirthFieldText, String degreeFieldText, String institutionFieldText, String majorFieldText, String graduationYearFieldText, String jobTitleFieldText, String companyNameFieldText, String durationFieldText, String responsibilitiesFieldText, String achievementsFieldText, String referencesFieldText, String programmingLanguagesFieldText, String developmentToolsFieldText, String databasesFieldText, String webDevelopmentFieldText, String operatingSystemsFieldText) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getDevelopmentTools() {
        return developmentTools;
    }

    public void setDevelopmentTools(String developmentTools) {
        this.developmentTools = developmentTools;
    }

    public String getDatabases() {
        return databases;
    }

    public void setDatabases(String databases) {
        this.databases = databases;
    }

    public String getWebDevelopment() {
        return webDevelopment;
    }

    public void setWebDevelopment(String webDevelopment) {
        this.webDevelopment = webDevelopment;
    }

    public String getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}