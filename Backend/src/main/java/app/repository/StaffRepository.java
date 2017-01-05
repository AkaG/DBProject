package app.repository;

import app.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends AppRepository<Staff, Long> {

}