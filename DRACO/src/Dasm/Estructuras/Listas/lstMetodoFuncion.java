/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;

import Dasm.Estructuras.Items.itemFuncion;
import Gui.Elementos.elementoGlobal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstMetodoFuncion {

    public Map<String, itemFuncion> listaFunciones ;
    elementoGlobal simbolo;
    
    
    public lstMetodoFuncion(elementoGlobal simbolo) {
        listaFunciones=new LinkedHashMap<>();
        this.simbolo=simbolo;
    }

    public void insertar(itemFuncion nuevaFuncion) {
        String clave=nuevaFuncion.nombre.valor;
        
        
        if(listaFunciones.containsKey(clave)){
            simbolo.tablaErrores.insertErrorSemantic(nuevaFuncion.nombre, "La función :"+nuevaFuncion.nombre.valor+" ya se encuentra declarada");
        }else{
            listaFunciones.put(clave, nuevaFuncion);
        }
    
    }
    
    
    
}
