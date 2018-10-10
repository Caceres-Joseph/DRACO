/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias.For;

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

    FOR             ::= tFor sAbreParent DECLARAR_VAR sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
                |   tFor sAbreParent ASIGNAR_VAL  sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves;

 */
 
public class _FOR extends nodoModelo{
    
   
    /**
     * constructor de _FOR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _FOR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
