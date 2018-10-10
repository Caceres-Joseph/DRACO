/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

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

    PRINT           ::= tPrint sAbreParent VALOR sCierraParent
                |   tPrint sAbreParent  sCierraParent;
 */
 
public class _PRINT extends nodoModelo {
    
    /**
     * constructor de _PRINT
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _PRINT(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
