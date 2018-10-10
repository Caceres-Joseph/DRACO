/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    ASIGNAR_VAL     ::= ASGIN_VAR
                    |   valId sDobleMas
                    |   valId sDobleMenos;
 */
 
public class _ASIGNAR_VAL extends nodoModelo{
    
    
    /**
     * constructor de _ASIGNAR_VAL
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ASIGNAR_VAL(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
