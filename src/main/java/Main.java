import Entity.Statistics;
import Entity.Student;
import Entity.University;
import Functions.FileReader;
import Functions.FileWriter;
import Util.StatisticsUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = FileReader.readStudent();

        List<University> universities = FileReader.readUniversity();

        List<Statistics> statistics = StatisticsUtil.collectingStatistics(students,universities);
        FileWriter.writeStatistics(statistics, "src\\main\\resources\\statistics.xlsx");
    }
}
