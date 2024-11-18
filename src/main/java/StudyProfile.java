public enum StudyProfile {
MEDICINE("Медицина"), PROGRAMMING("Програмирование"), AUTOMATION("Автоматизация");
    public String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
