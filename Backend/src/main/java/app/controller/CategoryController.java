package app.controller;

/**
 * Created by jakub on 11.01.17.
 */

import app.model.Category;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends AppRestController<Category, Long> {
    @Autowired
    public CategoryController(AppRepository<Category, Long> repository) {
        super(repository);
    }
}
