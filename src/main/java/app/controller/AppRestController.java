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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 28.12.16.
 */

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

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Map<String, Object> update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id: {} with body: {}", id, json);
        logger.debug("T json is of type {}", json.getClass());
        Map<String, Object> result = new HashMap<>();

        T entity = repository.findOne(id);
        try {
            BeanUtils.copyProperties(json, entity);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            result.put("success", false);
        }

        result.put("success", true);
        return result;
    }
}
