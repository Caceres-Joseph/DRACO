/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------

    FUNCIONES_NATIVAS   ::= PRINT
                    |   RUNMULTDASM

                    |   POINT
                    |   QUADRATE
                    |   OVAL

                    |   STRING
                    |   LINE;
 */
 
public class _FUNCIONES_NATIVAS extends nodoModelo{
    
    /**
     * constructor de _FUNCIONES_NATIVAS
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _FUNCIONES_NATIVAS(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
