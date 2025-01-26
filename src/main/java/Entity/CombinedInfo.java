package Entity;

import Entity.Statistics;
import Entity.Student;
import Entity.University;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "root")
@XmlType(propOrder = {"studentEntry", "universityEntry", "statisticsEntry", "date"})
public class CombinedInfo {

    private List<Student> studentEntry;
    private List<University> universityEntry;
    private List<Statistics> statisticsEntry;
    private Date date = new Date();

    public CombinedInfo(List<Student> studentEntry, List<University> universityEntry, List<Statistics> statisticsEntry) {
        this.studentEntry = studentEntry;
        this.universityEntry = universityEntry;
        this.statisticsEntry = statisticsEntry;
    }

    @XmlElementWrapper(name = "studentsInfo")
    public List<Student> getStudentEntry() {
        return studentEntry;
    }

    @XmlElementWrapper(name = "universitiesInfo")
    public List<University> getUniversityEntry() {
        return universityEntry;
    }

    @XmlElementWrapper(name = "statisticsInfo")
    public List<Statistics> getStatisticsEntry() {
        return statisticsEntry;
    }

    @XmlElement(name = "processedAt")
    public Date getDate() {
        return date;
    }
}