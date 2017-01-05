package app.repository;

import app.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends AppRepository<Address, Long> {

}