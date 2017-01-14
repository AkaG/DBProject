package app.service;

import app.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class StoredQueryServiceImpl implements StoredQueryService{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Movie> getMovieRentalMovies(Long id) {
        final StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("getMovieRentalMovies");
        storedProcedureQuery.setParameter("id", id);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}
