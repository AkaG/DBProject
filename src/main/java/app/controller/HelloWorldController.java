package app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 06.12.16.
 */

@RestController
@RequestMapping(method = RequestMethod.GET)
public class HelloWorldController {

    static Log logger = LogFactory.getLog(HelloWorldController.class.getName());

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        logger.info("hello");
        return "Hello " + name;
    }
}
