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
@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = { "id", "fullName" , "mainProfile" })
public class University{

    @SerializedName("Номер университета")
    String id;

    @SerializedName("Название университета")
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

    @XmlElement(name = "universityId")
    public String getId() {
        return id;
    }

    @XmlElement(name = "universityName")
    public String getFullName() {
        return fullName;
    }

    @XmlTransient
    public String getShortName() {
        return shortName;
    }

    @XmlTransient
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    @XmlElement(name = "universityProfile")
    public StudyProfile getMainProfile() {
        return mainProfile;
    }
}
