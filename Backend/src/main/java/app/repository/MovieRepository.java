package app.repository;

import app.model.Movie;
import org.springframework.stereotype.Repository;

/**
 * Created by jakub on 29.12.16.
 */
@Repository
public interface MovieRepository extends AppRepository<Movie, Long>{

}
