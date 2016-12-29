package app.repository;

import app.model.Country;
import org.springframework.stereotype.Repository;

/**
 * Created by jakub on 29.12.16.
 */
@Repository
public interface CountryRepository extends AppRepository<Country, Long>{
}
