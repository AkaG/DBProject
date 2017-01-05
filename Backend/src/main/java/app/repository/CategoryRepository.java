package app.repository;

import app.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends AppRepository<Category, Long> {

}