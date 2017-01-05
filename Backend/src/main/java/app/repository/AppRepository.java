package app.repository;

import app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface AppRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}