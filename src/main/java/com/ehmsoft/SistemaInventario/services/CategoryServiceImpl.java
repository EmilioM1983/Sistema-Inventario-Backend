package com.ehmsoft.SistemaInventario.services;

import com.ehmsoft.SistemaInventario.dao.ICategoryDao;
import com.ehmsoft.SistemaInventario.model.Category;
import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emaye
 */

@Service
public class CategoryServiceImpl implements ICategoryServices{

    @Autowired
    private ICategoryDao categoryDao;
    
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest response = new CategoryResponseRest();
        
        try {
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            
        } catch (Exception e) {
            response.setMetadata("Respuesta no ok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}
