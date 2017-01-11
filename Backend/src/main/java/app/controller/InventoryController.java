package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Inventory;
import app.repository.AppRepository;
import app.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController extends AppRestController<Inventory, Long> {
    @Autowired
    public InventoryController(InventoryRepository repository) {
        super(repository);
    }
}
