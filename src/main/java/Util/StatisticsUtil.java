package Util;

import Entity.Statistics;
import Entity.Student;
import Entity.University;
import Enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    public static List<Statistics> collectingStatistics(List<Student> students, List<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();

        Logger statisticsUtilLogger = Logger.getLogger(StatisticsUtil.class.getName());

        Set<StudyProfile> studyProfiles = universities.stream().map(University::getMainProfile).collect(Collectors.toSet());

        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(studyProfile);

            List<String> countUniversity = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .toList();

            statistics.setCountUniversity(countUniversity.size());

            List<Student> countStudents = students.stream()
                    .filter(student -> countUniversity.contains(student.getUniversityId()))
                    .toList();
            statistics.setCountStudents(countStudents.size());

            List<String> nameUniversity = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getFullName)
                    .toList();
            String nameUniversityString = "";
            for (String s : nameUniversity) {
                nameUniversityString += s + ";";
            }
            statistics.setNameUniversity(nameUniversityString);

            OptionalDouble avg = students.stream()
                    .filter(student -> countUniversity.contains(student.getUniversityId()))
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            avg.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        statisticsUtilLogger.log(Level.INFO, "Статистика собрана");
        return statisticsList;


    }

}
