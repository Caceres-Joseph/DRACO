/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.CuerpoRelativo;

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
CUERPO              ::= DECLARAR_VARIABLE sPuntoComa
                    |   ID_VAR_FUNC  sPuntoComa
                    |   ASIG_VALOR  sPuntoComa
                    |   FUNCIONES_NATIVAS  sPuntoComa
                    |   SENTENCIAS
                     
                    |   CONTROL
                    ;
 */
public class _CUERPO extends nodoModelo{
    
    public _CUERPO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
