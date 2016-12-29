package app.repository;

import app.model.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by jakub on 29.12.16.
 */
@Repository
public interface CustomerRepository extends AppRepository<Customer, Long>{

}
