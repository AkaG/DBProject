package app;

import dao.DaoContext;
import helloWorld.HelloWorldContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by jakub on 06.12.16.
 */

@SpringBootApplication
@Import({HelloWorldContext.class, DaoContext.class})
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }

}
