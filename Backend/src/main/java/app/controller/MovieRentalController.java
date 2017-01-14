package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Movie;
import app.model.MovieRental;
import app.repository.AppRepository;
import app.repository.MovieRentalRepository;
import app.service.StoredQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@RestController
@RequestMapping(value = "/movierental")
public class MovieRentalController extends AppRestController<MovieRental, Long>{

    @Autowired
    private StoredQueryService storedQueryService;

    @Autowired
    public MovieRentalController(MovieRentalRepository repository) {
        super(repository);
    }

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.GET)
    public List<Movie> getMovieRentalMovies(@PathVariable Long id){
        return storedQueryService.getMovieRentalMovies(id);
    }
}
