package app.repository;

import app.model.MovieRental;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRentalRepository extends AppRepository<MovieRental, Long> {

}