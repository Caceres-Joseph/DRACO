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
LST_DECLARAR_VAR    ::= LST_DECLARAR_VAR DECLARAR_VARIABLE sPuntoComa
                    |   DECLARAR_VARIABLE sPuntoComa
                    ;
 */
public class _LST_DECLARAR_VAR extends nodoModelo{
    
    public _LST_DECLARAR_VAR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
