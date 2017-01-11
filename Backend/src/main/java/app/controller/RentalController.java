package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Rental;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rental")
public class RentalController extends AppRestController<Rental, Long> {
    @Autowired
    public RentalController(AppRepository<Rental, Long> repository) {
        super(repository);
    }
}
