package dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * Created by jakub on 06.12.16.
 */

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DaoContext {
    @Bean
    CommandLineRunner init(AddressRepository addressRepository) {
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                            Address address = addressRepository.save(new Address(a,
                                    1));
                        });
    }
}
