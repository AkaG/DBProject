package app.repository;

import app.model.Rental;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends AppRepository<Rental, Long> {

}