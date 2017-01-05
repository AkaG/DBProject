package app.controller;

import app.repository.AppRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

public abstract class AppRestController<T, ID extends Serializable> {

    protected static Logger logger = LoggerFactory.getLogger(AppRestController.class);

    private AppRepository<T, ID> repository;

    public AppRestController(AppRepository<T, ID> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<T> getAll() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T getOne(@PathVariable ID id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id: {} with body: {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        T entity = repository.findOne(id);
        try {
            BeanUtils.copyProperties(json, entity);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
        return repository.saveAndFlush(entity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@RequestBody T json){
        logger.debug("create() with body {} of type {}", json, json.getClass());
        T created = this.repository.saveAndFlush(json);
        return created;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ID id){
        logger.debug("delete() of id: {}", id);
        repository.delete(id);
    }
}