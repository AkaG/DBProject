package app.service;

import app.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoredQueryService {
    List<Movie> getMovieRentalMovies(Long id);
}
