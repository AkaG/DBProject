package dao;

import helloWorld.HelloWorldController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jakub on 06.12.16.
 */


@RestController
@RequestMapping(value = "/address")
public class AddressController {
    static Log logger = LogFactory.getLog(HelloWorldController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getAddress(@RequestParam(value = "name") String name) {
       logger.info("get " + name);



       return new String("Hello");
    }
}
