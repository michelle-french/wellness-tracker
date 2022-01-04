package wellnesstracker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wellnesstracker.models.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Integer> {
}
