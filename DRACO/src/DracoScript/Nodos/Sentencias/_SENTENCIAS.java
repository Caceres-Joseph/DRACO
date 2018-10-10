/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias;

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
    SENTENCIAS      ::=  IF 
                |   WHILE
                |   FOR
                ;
 */
 
public class _SENTENCIAS extends nodoModelo{
    
    /**
     * constructor de _SENTENCIAS
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _SENTENCIAS(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
