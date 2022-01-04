package wellnesstracker.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @NotBlank(message = "Please provide frequency ")
    private String frequency;

    @DateTimeFormat(pattern = "MM-dd-yy")
    @NotBlank(message = "Please provide a date")
    private String date;

    @NotBlank
    private String timeTaken;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;

    public Medication(String medName, String medDose, String frequency, String date, String timeTaken, Profile profile) {
        this.medName = medName;
        this.medDose = medDose;
        this.frequency = frequency;
        this.date = date;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
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
                ", date='" + date + '\'' +
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
