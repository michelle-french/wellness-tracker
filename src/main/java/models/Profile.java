package models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Profile {

    @NotBlank(message = "Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String profileFirst;

    @NotBlank(message = "Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String profileLast;

    public Profile(String profileFirst, String profileLast) {
        this.profileFirst = profileFirst;
        this.profileLast = profileLast;
    }

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
        return profileFirst.equals(profile.profileFirst) && profileLast.equals(profile.profileLast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileFirst, profileLast);
    }
}
