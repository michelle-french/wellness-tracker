package wellnesstracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Medication {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please provide medication name")
    private String medName;

    @NotBlank(message = "Please provide dosage")
    private String medDose;

    @Min(1)
    @Max(24)
    private Integer frequency;

    private MedDay day;

    private Time timeTaken;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;

    public Medication(String medName, String medDose, Integer frequency, MedDay day, Time timeTaken, Profile profile) {
        this.medName = medName;
        this.medDose = medDose;
        this.frequency = frequency;
        this.day = day;
        this.timeTaken = timeTaken;
        this.profile = profile;
    }

    public Medication(){}

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedDose() {
        return medDose;
    }

    public void setMedDose(String medDose) {
        this.medDose = medDose;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public MedDay getDay() {
        return day;
    }

    public void setDay(MedDay day) {
        this.day = day;
    }

    public Time getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Time timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medName='" + medName + '\'' +
                ", medDose='" + medDose + '\'' +
                ", frequency='" + frequency + '\'' +
                ", date='" + day + '\'' +
                ", timeTaken='" + timeTaken + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication medication = (Medication) o;
        return id == medication.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
