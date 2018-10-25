/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.AsignarValor;

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

ASIG_VALOR          ::= ID_VAR_FUNC  VAL
                    |   ID_VAR_FUNC  sMas  sMas
                    |   ID_VAR_FUNC  sMenos  sMenos
                    ;
 */
public class _ASIG_VALOR extends nodoModelo{
    
    public _ASIG_VALOR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
