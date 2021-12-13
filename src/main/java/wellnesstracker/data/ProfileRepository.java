package wellnesstracker.data;

import wellnesstracker.models.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{
}
