package app.controller;

import app.model.Address;
import app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 06.12.16.
 */


@RestController
@RequestMapping(value = "/address")
public class AddressController extends AppRestController<Address, Long> {

    @Autowired
    public AddressController(AddressRepository repository) {
        super(repository);
    }
}
