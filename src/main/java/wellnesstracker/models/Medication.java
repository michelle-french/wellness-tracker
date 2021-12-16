package wellnesstracker.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
}
