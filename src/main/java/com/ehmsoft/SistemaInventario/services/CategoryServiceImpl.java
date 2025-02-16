package com.ehmsoft.SistemaInventario.services;

import com.ehmsoft.SistemaInventario.dao.ICategoryDao;
import com.ehmsoft.SistemaInventario.model.Category;
import com.ehmsoft.SistemaInventario.response.CategoryResponseRest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    
    
    /**
     * get all categories
     * @return 
     */
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

    /**
     * get all categories by id
     * @return 
     */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> listCategory = new ArrayList();
        
        try {
            
            Optional<Category> category = categoryDao.findById(id);
            
            if (category.isPresent()) {
                
                response.setMetadata("Respuesta ok", "00", "Categoria encontrada");
                listCategory.add(category.get());
                response.getCategoryResponse().setCategory(listCategory);
                
            }else{
                
                response.setMetadata("Respuesta no ok", "-1", "Categoria no encontrada");         
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception e) {
            response.setMetadata("Respuesta no ok", "-1", "Error al consultar por id");
            e.getStackTrace();
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}
