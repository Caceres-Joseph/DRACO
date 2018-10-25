/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.DeclararVariable;

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

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
                    |   DECLARAR_VARIABLE sComa VAR_ARREGLO
                    |   TIPO VAR_ARREGLO VAL
                    |   TIPO VAR_ARREGLO
                    ;
 */
public class _DECLARAR_VARIABLE extends nodoModelo{
    
    public _DECLARAR_VARIABLE(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
