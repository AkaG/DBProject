package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.MovieRental;
import app.repository.AppRepository;
import app.repository.MovieRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movierental")
public class MovieRentalController extends AppRestController<MovieRental, Long>{
    @Autowired
    MovieRentalRepository repository;

    @Autowired
    public MovieRentalController(AppRepository<MovieRental, Long> repository) {
        super(repository);
    }

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.GET)
    public Long getMovieRentalMovies(@PathVariable Long id){
        return repository.getMovieRentalMoves(id);
    }
}
