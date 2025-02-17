package com.ehmsoft.SistemaInventario.services;

import com.ehmsoft.SistemaInventario.model.Category;
import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author emaye
 */
public interface ICategoryServices {
    /**
     * Service search all categories
     * @return 
     */
    public ResponseEntity<CategoryResponseRest> search();
    
    /**
     * service search categories by id
     * @param id
     * @return 
     */
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
    
    /**
     * Service save Category
     * @param category
     * @return 
     */
    public ResponseEntity<CategoryResponseRest> saveCategoriy(Category category);
    
    /**
     * Update category by id
     * @param category
     * @param id
     * @return 
     */
    public ResponseEntity<CategoryResponseRest> updateCategoriy(Category category, Long id);
}
