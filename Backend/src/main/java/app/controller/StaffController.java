package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Staff;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/staff")
public class StaffController extends AppRestController<Staff, Long> {
    @Autowired
    public StaffController(AppRepository<Staff, Long> repository) {
        super(repository);
    }
}
