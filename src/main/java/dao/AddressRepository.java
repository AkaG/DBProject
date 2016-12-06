package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jakub on 06.12.16.
 */
public interface AddressRepository extends JpaRepository<Address, Long>{

    @Query(value = "SELECT * FROM Address")
    List<Address> findById(@Param("searchTerm") String searchTerm);
}
