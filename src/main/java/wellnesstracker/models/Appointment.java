package wellnesstracker.models;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

//    @NotNull(message = "please format correctly")
//    @Future
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
//    private Date date;
    @NotBlank(message = "Please enter date")
    private String date;

    @NotBlank
    private String time;

    @NotBlank
    private String location;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;


    public Appointment(String name, String date, String time, String location, Profile profile) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.profile = profile;
    }

    public Appointment(){}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}

    public int getId() {return id;}

    @Override
    public String toString() {
        return "Appointment{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return id == appointment.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);}
}
