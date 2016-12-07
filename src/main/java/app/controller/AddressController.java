package app.controller;

import app.model.Address;
import app.repository.AddressRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 06.12.16.
 */


@RestController
@RequestMapping(value = "/address")
public class AddressController {

    static Log logger = LogFactory.getLog(HelloWorldController.class.getName());

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Address getAddress(@RequestParam(value = "id") Long id) {
       logger.info("getAddress " + id);
       return addressRepository.getOne(id);
    }
}
