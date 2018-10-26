/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Inicio;

import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    CUERPO          ::= DECLARAR_VAR sPuntoComa
                |   ASIGNAR_VAL sPuntoComa
                |   SENTENCIAS
                |   ROMPER
                |   FUNCIONES_NATIVAS  sPuntoComa
                ;
 */
 
public class _CUERPO extends nodoModelo{
    
    /**
     * constructor de _CUERPO
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _CUERPO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
