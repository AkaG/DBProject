package app.repository;

import app.model.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends AppRepository<Inventory, Long> {

}