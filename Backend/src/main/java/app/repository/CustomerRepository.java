package app.repository;

import app.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends AppRepository<Customer, Long> {

}