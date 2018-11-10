/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;
 
import D_plus.Estructuras.Items.itemEstructura;
import Gui.Elementos.elementoGlobal; 
import Gui.Items.itemAtributo;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstEstructura {
    public Map<String, itemEstructura> listaEstructuras ;
    
    elementoGlobal simbolo;

    
    public lstEstructura(elementoGlobal simbolo){
        this.simbolo=simbolo; 
        listaEstructuras=new LinkedHashMap<>(); 
    }
    
    
    /**
     * Insertando una nueva estructura
     * @param nombre
     * @param nuevaEstructura 
     */
    public void insertar(itemAtributo nombre, itemEstructura nuevaEstructura){
        
        if(listaEstructuras.containsKey(nombre.valor)){
            simbolo.tablaErrores.insertErrorSemantic(nombre, "Ya existe una estructura con el mismo nombre:"+nombre.valor);
            return;
        }
        
        listaEstructuras.put(nombre.valor, nuevaEstructura);
    }

    public itemEstructura get(itemAtributo nombre) {
        if(!listaEstructuras.containsKey(nombre.valor)){
            simbolo.tablaErrores.insertErrorSemantic(nombre, "No existe la estructura :"+nombre.valor);
            return null;
        }
        return listaEstructuras.get(nombre.valor);
    }
    
    
}
