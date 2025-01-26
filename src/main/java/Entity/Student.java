package Entity;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "studentEntry")
@XmlType(propOrder = { "fullName", "universityId" , "avgExamScore" })
public class Student {

    @SerializedName("Имя")
    private String fullName;

    @SerializedName("Номер университета")
    private String universityId;

    @SerializedName("Номер курса")
    private int currentCourseNumber;

    @SerializedName("Средний балл")
    private float avgExamScore;

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    @XmlElement(name = "studentName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "universityId")
    public String getUniversityId() {
        return universityId;
    }

    @XmlTransient
    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    @XmlElement(name = "avgScore")
    public float getAvgExamScore() {
        return avgExamScore;
    }
}
