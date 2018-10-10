/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Listas.lstAtributos;
import DracoScript.Estructuras.Listas.lstNodosHijos;

 
public class nodoModelo {
    
    public elementoGlobal simbolo;
    //public String nombreNodo = "";
    public lstAtributos listaAtributos;
    public lstNodosHijos listaHijos;
    public itemAtributo atributo;
    
    /**
     * constructor de _ASGIN_VAR 
     * @param atrib Atributo que contiene el nombre y la linea del nodo
     * @param simbolo Es el simbolo global
     */
    
    public nodoModelo(itemAtributo atrib, elementoGlobal simbolo){
        this.atributo = atrib;
        this.simbolo=simbolo;
        this.listaAtributos =new lstAtributos();
        this.listaHijos =new lstNodosHijos(); 
    }
    
     
    
     
    /**
     * @param mensaje Imprime el mensaje con el nombre de la clase para ubicarlo de forma fácil
     */
    public void printl(String mensaje){
        System.out.println("["+atributo.nombreToken+"]"+mensaje);
    }
    
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables
     * @return El retorno es cuando viene un break
     */
    public itemRetorno ejecutar(elementoEntorno entorno){
        return listaHijos.ejecutar(entorno);
    }
    
}
