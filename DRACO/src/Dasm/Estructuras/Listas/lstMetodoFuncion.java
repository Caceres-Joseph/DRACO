/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemFuncion;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
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

    /**
     * Inserta una nueva funcion a la lista de funciones
     * @param nuevaFuncion 
     */
    public void insertar(itemFuncion nuevaFuncion) {
        String clave=nuevaFuncion.nombre.valLower;
        
        
        if(listaFunciones.containsKey(clave)){
            simbolo.tablaErrores.insertErrorSemantic(nuevaFuncion.nombre, "La función :"+nuevaFuncion.nombre.valor+" ya se encuentra declarada");
        }else{
            listaFunciones.put(clave, nuevaFuncion);
        }
    
    }
    
    /**
     * Ejecuta una funcion 
     * @param nombreFuncion El nombre de la funcion
     * @param entorno El entorno que se pasa por todos los ambitos
     */
    public void ejecutarFuncion(itemAtributo nombreFuncion, elementoEntorno entorno){
           //hay que buscar la funcion
        
           if(listaFunciones.containsKey(nombreFuncion.valLower)){
               nodoModelo valor= listaFunciones.get(nombreFuncion.valLower).cuerpo;
               valor.ejecutar(entorno, 0);
           }else{
               simbolo.tablaErrores.insertErrorSemantic(nombreFuncion, "La función :"+nombreFuncion.valor+" no se ha encontrado");
        
           }
    }
    
    
    
}
