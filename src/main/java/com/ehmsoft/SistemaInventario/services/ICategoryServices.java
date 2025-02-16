package com.ehmsoft.SistemaInventario.services;

import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author emaye
 */
public interface ICategoryServices {
    
    public ResponseEntity<CategoryResponseRest> search();
    
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
}
