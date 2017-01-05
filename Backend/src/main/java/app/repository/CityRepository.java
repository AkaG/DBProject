package app.repository;

import app.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends AppRepository<City, Long> {

}