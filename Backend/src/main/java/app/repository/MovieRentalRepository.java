package app.repository;

import app.model.Movie;
import app.model.MovieRental;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRentalRepository extends AppRepository<MovieRental, Long> {
    @Procedure
    List<Movie> getMovieRentalMovies(Long id);
}