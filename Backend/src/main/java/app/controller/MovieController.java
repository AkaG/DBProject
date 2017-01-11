package app.controller;

import app.model.Movie;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movie")
public class MovieController extends AppRestController<Movie, Long>{
    @Autowired
    public MovieController(AppRepository<Movie, Long> repository) {
        super(repository);
    }
}
