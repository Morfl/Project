package Entity;


import Enums.StudyProfile;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "statisticsEntry")
@XmlType(propOrder = { "studyProfile", "avgExamScore" })
public class Statistics {

    @SerializedName("Номер университета")
    private StudyProfile studyProfile;

    @SerializedName("Средний балл")
    private float avgExamScore;

    @SerializedName("Число студентов")
    private int countStudents;

    @SerializedName("Число университетов")
    private int countUniversity;

    @SerializedName("Имя университета")
    private String nameUniversity;


    @XmlElement(name = "universityProfile")
    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    @XmlElement(name = "avgScore")
    public float getAvgExamScore() {
        return avgExamScore;
    }

    @XmlTransient
    public int getCountStudents() {
        return countStudents;
    }

    @XmlTransient
    public int getCountUniversity() {
        return countUniversity;
    }

    @XmlTransient
    public String getNameUniversity() {
        return nameUniversity;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + studyProfile +
                ", avgExamScore=" + avgExamScore +
                ", countStudents=" + countStudents +
                ", countUniversity=" + countUniversity +
                ", nameUniversity='" + nameUniversity + '\'' +
                '}';
    }
}
