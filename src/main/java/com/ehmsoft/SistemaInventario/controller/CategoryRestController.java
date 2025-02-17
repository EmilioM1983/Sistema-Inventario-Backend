package com.ehmsoft.SistemaInventario.controller;

import com.ehmsoft.SistemaInventario.model.Category;
import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import com.ehmsoft.SistemaInventario.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        
        return service.search();
    }
    
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
        
        return service.searchById(id);
    }
    
    @PostMapping("/categories/save")
    public ResponseEntity<CategoryResponseRest> saveCategory(@RequestBody Category category){
        return service.saveCategoriy(category);
    }
}
