package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jakub on 06.12.16.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"app", "helloWorld"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}
