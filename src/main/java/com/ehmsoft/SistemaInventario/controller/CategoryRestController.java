package com.ehmsoft.SistemaInventario.controller;

import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import com.ehmsoft.SistemaInventario.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
