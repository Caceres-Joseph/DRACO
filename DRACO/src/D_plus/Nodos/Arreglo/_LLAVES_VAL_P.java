/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Arreglo;

import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
LLAVES_VAL_P        ::=  sAbreLlave LST_LLAVES_VAL sCierraLlave
                    |   sAbreLlave LST_VAL sCierraLlave
                    ;
 */

public class _LLAVES_VAL_P extends nodoModelo{
    
    public _LLAVES_VAL_P(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
