package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Customer;
import app.repository.AppRepository;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController extends AppRestController<Customer, Long> {
    @Autowired
    public CustomerController(CustomerRepository repository) {
        super(repository);
    }
}
