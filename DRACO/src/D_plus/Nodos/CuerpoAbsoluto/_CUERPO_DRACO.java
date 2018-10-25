/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.CuerpoAbsoluto;

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
CUERPO_DRACO        ::= DECLARAR_VARIABLE sPuntoComa 
                    |   METODO
                    |   MAIN
                    |   ESTRUCTURA
                    ;
 */
public class _CUERPO_DRACO extends nodoModelo {
    
    public _CUERPO_DRACO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
