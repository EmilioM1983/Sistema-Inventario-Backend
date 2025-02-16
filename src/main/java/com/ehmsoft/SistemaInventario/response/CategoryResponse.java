package com.ehmsoft.SistemaInventario.response;

import com.ehmsoft.SistemaInventario.model.Category;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Emilio Mayer
 */

@Data
public class CategoryResponse {
    
    private List<Category> category = new ArrayList<>();
}
