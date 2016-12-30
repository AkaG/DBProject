package app.controller;

import app.model.Country;
import app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 29.12.16.
 */
@RestController
@RequestMapping(value = "/country")
public class CountryController extends AppRestController<Country, Long> {

    @Autowired
    public CountryController(CountryRepository repository) {
        super(repository);
    }
}
