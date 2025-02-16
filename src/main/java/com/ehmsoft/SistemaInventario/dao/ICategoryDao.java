package com.ehmsoft.SistemaInventario.dao;

import com.ehmsoft.SistemaInventario.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author emaye
 */
public interface ICategoryDao extends CrudRepository<Category, Long>{
    
}
