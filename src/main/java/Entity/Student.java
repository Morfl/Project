package Entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
}
