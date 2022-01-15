package wellnesstracker.models;

import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




@Entity
public class Appointment extends AbstractEntity {

    private static final String START_DATE_FORMAT_PATTERN = "MM/dd/yy";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT
            = new SimpleDateFormat(START_DATE_FORMAT_PATTERN);

    @NotBlank
    private String name;

    @NotNull(message = "Please enter date MM/DD/YY")
    @DateTimeFormat(pattern = START_DATE_FORMAT_PATTERN)
    private Date date;

    private Time time;

    @NotBlank
    private String location;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;


    public Appointment(String name, Date date, Time time, String location, Profile profile) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.profile = profile;
    }

    public Appointment(){}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedStartDate() {
        return Appointment.SIMPLE_DATE_FORMAT.format(date);
    }

    public Time getTime() {return time;}

    public void setTime(Time time) {this.time = time;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}


    @Override
    public String toString() {
        return "Appointment{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }

}
