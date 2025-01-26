package Util;

import Entity.CombinedInfo;
import Entity.Student;
import Entity.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {

    private static final Logger JsonUtilLogger = Logger.getLogger(JsonUtil.class.getName());

    private JsonUtil() {
    }

    public static String serializationStudent(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String serializationList(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }

    public static String serializationUniversity(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student deserializationStudent(String student) {
        return new Gson().fromJson(student, Student.class);
    }

    public static List<Student> deserializationListStudent(String studentList) {
        return new Gson().fromJson(studentList, new TypeToken<List<Student>>() {
        }.getType());
    }

    public static University deserializationUniversity(String university) {
        return new Gson().fromJson(university, University.class);
    }

    public static List<University> deserializationListUniversity(String universityList) {
        return new Gson().fromJson(universityList, new TypeToken<List<Student>>() {
        }.getType());
    }

    public static void createJsonFile(CombinedInfo combinedInfo, String path) {
        String students = serializationList(combinedInfo.getStudentEntry());
        String university = serializationList(combinedInfo.getUniversityEntry());
        String statistics = serializationList(combinedInfo.getStatisticsEntry());

        File file = new File(path);
        file.getParentFile().mkdirs();

        try {
            FileOutputStream fos1 = new FileOutputStream(file + "/student " + combinedInfo.getDate().getTime() + ".json");
            FileOutputStream fos2 = new FileOutputStream(file + "/university" + combinedInfo.getDate().getTime() + ".json");
            FileOutputStream fos3 = new FileOutputStream(file + "/statistics" + combinedInfo.getDate().getTime() + ".json");
            fos1.write(students.getBytes(StandardCharsets.UTF_8));
            fos2.write(university.getBytes(StandardCharsets.UTF_8));
            fos3.write(statistics.getBytes(StandardCharsets.UTF_8));

            fos1.close();
            fos2.close();
            fos3.close();

            JsonUtilLogger.log(Level.INFO, "Json файлы созданы");

        } catch (FileNotFoundException e) {
            JsonUtilLogger.log(Level.SEVERE, "Не удалось создать файл json");
            e.printStackTrace();

        } catch (IOException e) {
            JsonUtilLogger.log(Level.SEVERE, "Не удалось создать файл json");
            e.printStackTrace();
        }

    }

}
