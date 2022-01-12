package wellnesstracker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellnesstracker.models.Pain;

@Repository
public interface PainRepository extends CrudRepository<Pain, Integer> {
}
