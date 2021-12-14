package wellnesstracker.data;

import org.springframework.stereotype.Repository;
import wellnesstracker.models.Appointment;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
