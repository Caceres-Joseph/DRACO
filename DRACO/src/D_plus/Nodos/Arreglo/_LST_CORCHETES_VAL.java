/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Arreglo;

import D_plus.Estructuras.Items.itemAtributo;
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
LST_CORCHETES_VAL   ::= LST_CORCHETES_VAL PAR_CORCHETES_VAL
                    |   PAR_CORCHETES_VAL
 */
public class _LST_CORCHETES_VAL extends nodoModelo{
    
    public _LST_CORCHETES_VAL(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
