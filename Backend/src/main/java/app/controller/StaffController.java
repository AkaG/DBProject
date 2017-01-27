package app.controller;

import app.model.Staff;
import app.repository.AppRepository;
import app.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/staff")
public class StaffController extends AppRestController<Staff, Long> {
    @Autowired
    StaffRepository repository;

    @Autowired
    public StaffController(StaffRepository repository) {
        super(repository);
    }

    @RequestMapping(value = "/{id}/sales", method = RequestMethod.GET)
    public Long countStaffRecentSales(@PathVariable Long id){
        return repository.staffRecentSales(id);
    }
}
