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
public class Pain {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please define pain location")
    private String painLocation;

    private Time time;

    private Day day;

    @Min(1)
    @Max(10)
    private int severity;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;

    public Pain(String painLocation, Time time, Day day, int severity, Profile profile) {
        this.painLocation = painLocation;
        this.time = time;
        this.day = day;
        this.severity = severity;
        this.profile = profile;
    }

    public Pain(){}

    public String getPainLocation() {return painLocation;}

    public void setPainLocation(String painLocation) {this.painLocation = painLocation;}

    public Time getTime() {return time;}

    public void setTime(Time time) {this.time = time;}

    public Day getDay() {return day;}

    public void setDay(Day day) {this.day = day;}

    public int getSeverity() {return severity;}

    public void setSeverity(int severity) {this.severity = severity;}

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}

    public int getId() {return id;}

    @Override
    public String toString() {
        return "Pain{" +
                "painLocation='" + painLocation + '\'' +
                ", time=" + time +
                ", day=" + day +
                ", severity=" + severity +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pain pain = (Pain) o;
        return id == pain.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);}
}
