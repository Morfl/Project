package Enums;

import lombok.Getter;

@Getter
public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

}
