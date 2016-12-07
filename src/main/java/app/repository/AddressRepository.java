package app.repository;

import app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jakub on 06.12.16.
 */
public interface AddressRepository extends JpaRepository<Address, Long>{

}
