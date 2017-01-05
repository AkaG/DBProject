package app.repository;

import app.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends AppRepository<Movie, Long> {

}