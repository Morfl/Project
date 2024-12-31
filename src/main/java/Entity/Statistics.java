package Entity;


import Enums.StudyProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private int countStudents;
    private int countUniversity;
    private String nameUniversity;

}
