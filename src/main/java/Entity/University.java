package Entity;

import Enums.StudyProfile;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class University{
    @SerializedName("Номер университета")
    String id;
    @SerializedName("Название")
    String fullName;
    @SerializedName("Аббревиатура")
    String shortName;
    @SerializedName("Год основания")
    int yearOfFoundation;
    @SerializedName("Направление")
    StudyProfile mainProfile;

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile.getProfileName() +
                '}';
    }
}
