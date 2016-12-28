package app.repository;

import app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by jakub on 28.12.16.
 */
@NoRepositoryBean
public interface AppRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{
}
