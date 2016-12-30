package app.repository;

import app.model.Inventory;
import org.springframework.stereotype.Repository;

/**
 * Created by jakub on 29.12.16.
 */
@Repository
public interface InventoryRepository extends AppRepository<Inventory, Long>{

}
