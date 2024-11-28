package Comparators;

import enums.StudentEnum;
import enums.UniversityEnum;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentEnum studentEnum) {
        if (studentEnum == StudentEnum.UNIVERSITY_ID) {
            return new StudentUniversityIdCompare();
        } else if (studentEnum == StudentEnum.AVG_EXAM_SCORE) {
            return new StudentAvgExamScoreCompare();
        } else if (studentEnum == StudentEnum.COURSE) {
            return new StudentCurrentCourseNumberCompare();
        } else {
            return new StudentFullNameCompare();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityEnum universityEnum) {
        if (universityEnum == UniversityEnum.ID) {
            return new UniversityIdCompare();
        } else if (universityEnum == UniversityEnum.FULL_NAME) {
            return new UniversityFullNameCompare();
        } else if (universityEnum == UniversityEnum.YEAR) {
            return new UniversityYearOfFoundationCompare();
        } else if (universityEnum == UniversityEnum.SHORT_NAME){
            return new UniversityShortNameCompare();
        } else {
            return new UniversityMainProfileCompare();
        }
    }
}
