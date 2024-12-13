package Util;

import Entity.Student;
import Entity.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String serializationStudent(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String serializationListStudent(List<Student> studentList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentList);
    }

    public static String serializationUniversity(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String serializationListUniversity(List<University> universityList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universityList);
    }

    public static Student deserializationStudent(String student) {
        return new Gson().fromJson(student, Student.class);
    }

    public static List<Student> deserializationListStudent(String studentList) {
        return new Gson().fromJson(studentList, new TypeToken<List<Student>>(){}.getType());
    }

    public static University deserializationUniversity(String university) {
        return new Gson().fromJson(university, University.class);
    }

    public static List<University> deserializationListUniversity(String universityList) {
        return new Gson().fromJson(universityList, new TypeToken<List<Student>>(){}.getType());
    }

}
