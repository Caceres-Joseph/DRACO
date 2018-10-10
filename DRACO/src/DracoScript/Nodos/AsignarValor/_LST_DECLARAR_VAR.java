/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    LST_DECLARAR_VAR::= LST_DECLARAR_VAR sComa  valId
                |   LST_DECLARAR_VAR sComa ASGIN_VAR
                |   valId
                |   ASGIN_VAR  ;
 */
 
public class _LST_DECLARAR_VAR extends nodoModelo {
    
    /**
     * constructor de _LST_DECLARAR_VAR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _LST_DECLARAR_VAR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
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
     * @return 
     */
    
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno){
        return listaHijos.ejecutar(entorno);
    }
     
}
