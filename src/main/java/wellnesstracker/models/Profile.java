package wellnesstracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String profileFirst;

    @NotBlank(message = "Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String profileLast;

    @OneToMany(mappedBy = "profile")
    private final List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "profile")
    private final List<Medication> medications = new ArrayList<>();

    @OneToMany(mappedBy = "profile")
    private final List<Pain> pains = new ArrayList<>();

    public Profile(String profileFirst, String profileLast) {
        this.profileFirst = profileFirst;
        this.profileLast = profileLast;
    }

    public Profile(){}

    public String getProfileFirst() {
        return profileFirst;
    }

    public void setProfileFirst(String profileFirst) {
        this.profileFirst = profileFirst;
    }

    public String getProfileLast() {
        return profileLast;
    }

    public void setProfileLast(String profileLast) {
        this.profileLast = profileLast;
    }

    public int getId() {
        return id;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Medication> getMedications() {return medications;}

    public List<Pain> getPains() {return pains;}

    @Override
    public String toString() {
        return "Profile{" +
                "profileFirst='" + profileFirst + '\'' +
                ", profileLast='" + profileLast + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
