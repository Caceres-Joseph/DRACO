/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.SentenciaControl;

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
CONTROL             ::= ROMPER
                    |   CONTINUAR
                    |   RETORNO
                    ;
 */
public class _CONTROL extends nodoModelo{
    
    public _CONTROL(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
