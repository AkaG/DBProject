package app.controller;

import app.model.City;
import app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/city")
public class CityController extends AppRestController<City, Long> {

    @Autowired
    public CityController(CityRepository repository) {
        super(repository);
    }
}