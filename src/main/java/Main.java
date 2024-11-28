import Comparators.ComparatorUtil;
import Comparators.StudentComparator;
import Comparators.UniversityComparator;
import enums.StudentEnum;
import enums.UniversityEnum;
import functions.FileReader;
import models.Student;
import models.University;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentComparator idStd = ComparatorUtil.getStudentComparator(StudentEnum.UNIVERSITY_ID);
        StudentComparator fullNameStd = ComparatorUtil.getStudentComparator(StudentEnum.FULL_NAME);
        StudentComparator avgExamScoreStd = ComparatorUtil.getStudentComparator(StudentEnum.AVG_EXAM_SCORE);
        StudentComparator courseStd = ComparatorUtil.getStudentComparator(StudentEnum.COURSE);

        UniversityComparator idUniv = ComparatorUtil.getUniversityComparator(UniversityEnum.ID);
        UniversityComparator yearUniv = ComparatorUtil.getUniversityComparator(UniversityEnum.YEAR);
        UniversityComparator fullNameUniv = ComparatorUtil.getUniversityComparator(UniversityEnum.FULL_NAME);
        UniversityComparator profileUniv = ComparatorUtil.getUniversityComparator(UniversityEnum.PROFILE);
        UniversityComparator shortNameUniv = ComparatorUtil.getUniversityComparator(UniversityEnum.SHORT_NAME);


        FileReader.readStudent().stream().sorted(idStd).forEach(System.out::println);
        System.out.println();
        FileReader.readStudent().stream().sorted(fullNameStd).forEach(System.out::println);
        System.out.println();
        FileReader.readStudent().stream().sorted(avgExamScoreStd).forEach(System.out::println);
        System.out.println();
        FileReader.readStudent().stream().sorted(courseStd).forEach(System.out::println);
        System.out.println();


        FileReader.readUniversity().stream().sorted(idUniv).forEach(System.out::println);
        System.out.println();
        FileReader.readUniversity().stream().sorted(yearUniv).forEach(System.out::println);
        System.out.println();
        FileReader.readUniversity().stream().sorted(fullNameUniv).forEach(System.out::println);
        System.out.println();
        FileReader.readUniversity().stream().sorted(profileUniv).forEach(System.out::println);
        System.out.println();
        FileReader.readUniversity().stream().sorted(shortNameUniv).forEach(System.out::println);


    }
}
