package com.ehmsoft.SistemaInventario.response;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Emilio Mayer
 */
//Estructura del metadata de la respuesta
public class ResponseRest {
    
    private final ArrayList<HashMap<String, String>> metadata = new ArrayList<>();
    
    
    //Metodos Get Set
    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }
    //Modificamos el set
    public void setMetadata(String type, String code, String date) {
        HashMap <String, String> map = new HashMap<>();
        
        map.put(type, type);
        map.put(code, code);
        map.put(date, date);
        metadata.add(map);
    }
    
    
}
