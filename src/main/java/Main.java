import Entity.Student;
import Entity.University;
import Util.ComparatorUtil;
import Comparators.StudentComparator;
import Comparators.UniversityComparator;
import Enums.StudentEnum;
import Enums.UniversityEnum;
import Functions.FileReader;
import Util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = FileReader.readStudent();
        String jsonStudents = JsonUtil.serializationListStudent(students);

        List<University> universities = FileReader.readUniversity();
        String jsonUniversities = JsonUtil.serializationListUniversity(universities);
        System.out.println(jsonStudents);
        System.out.println(jsonUniversities);

        List<Student> newStudents = JsonUtil.deserializationListStudent(jsonStudents);
        List<University> newUniversities = JsonUtil.deserializationListUniversity(jsonUniversities);
        System.out.println(students);
        System.out.println(newStudents);

        System.out.println(newStudents.size() == students.size());
        System.out.println(newUniversities.size() == universities.size());

        students.forEach(student -> {
            String jsonStudent = JsonUtil.serializationStudent(student);
            System.out.println(jsonStudent);
            Student newStudent = JsonUtil.deserializationStudent(jsonStudent);
            System.out.println(newStudent);
        });

        universities.forEach(university -> {
            String jsonUniversity = JsonUtil.serializationUniversity(university);
            System.out.println(jsonUniversity);
            University newUniversity = JsonUtil.deserializationUniversity(jsonUniversity);
            System.out.println(newUniversity);
        });


    }
}
