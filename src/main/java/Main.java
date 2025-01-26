import Entity.Statistics;
import Entity.Student;
import Entity.University;
import Functions.FileReader;
import Util.JsonUtil;
import Util.StatisticsUtil;
import Util.XmlUtil;
import Entity.CombinedInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Student> students = FileReader.readStudent();
        List<University> universities = FileReader.readUniversity();
        List<Statistics> statistics = StatisticsUtil.collectingStatistics(students, universities);

        XmlUtil.createXmlFile(new CombinedInfo(students, universities, statistics), "src/main/resources/XML");
        JsonUtil.createJsonFile(new CombinedInfo(students, universities, statistics), "src/main/resources/JSON");

    }
}
