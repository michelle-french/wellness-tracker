package wellnesstracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

//    @OneToMany(mappedBy = "user")
//    private final List<Profile> profiles = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

//    public List<Profile> getProfiles() {
//        return profiles;
//    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }


}
