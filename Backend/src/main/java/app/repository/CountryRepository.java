package app.repository;

import app.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends AppRepository<Country, Long> {

}