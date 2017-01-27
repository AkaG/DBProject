package app.repository;

import app.model.Staff;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends AppRepository<Staff, Long> {
    @Procedure(name = "staffRecentSales", procedureName = "find_staff_sales")
    Long staffRecentSales(Long id);
}