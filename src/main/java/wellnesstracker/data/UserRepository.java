package wellnesstracker.data;

import org.springframework.data.repository.CrudRepository;
import wellnesstracker.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
