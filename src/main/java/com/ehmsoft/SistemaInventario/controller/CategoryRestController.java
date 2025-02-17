package com.ehmsoft.SistemaInventario.controller;

import com.ehmsoft.SistemaInventario.model.Category;
import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import com.ehmsoft.SistemaInventario.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Emilio Mayer
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
    
    @Autowired
    private ICategoryServices service;
    
    /**
     * Return all categories
     * @return 
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        
        return service.search();
    }
    
    /**
     * Return category by id
     * @param id
     * @return 
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        
        return service.searchById(id);
    }
    
    /**
     * Save a category
     * @param category
     * @return 
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> saveCategory(@RequestBody Category category){
        return service.saveCategoriy(category);
    }
    
    /**
     * Update Category by id
     * @param category
     * @param id
     * @return 
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> updateCategory(@RequestBody Category category, @PathVariable Long id){
        return service.updateCategoriy(category, id);
    }
    
    /**
     * Delete category by id
     * @param id
     * @return 
     */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> deleteCategoriesById(@PathVariable Long id){
        
        return service.deleteById(id);
    }
}
