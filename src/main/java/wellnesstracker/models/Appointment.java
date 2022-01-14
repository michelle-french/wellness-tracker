package wellnesstracker.models;

import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Appointment extends AbstractEntity {



    @NotBlank
    private String name;

    @NotBlank(message = "Please enter date")
    private String date;

    private Time time;

    @NotBlank
    private String location;

    @ManyToOne
    @NotNull(message = "Please Select Profile")
    private Profile profile;


    public Appointment(String name, String date, Time time, String location, Profile profile) {
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
