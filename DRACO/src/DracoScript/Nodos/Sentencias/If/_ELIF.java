/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias.If;

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
ELIF            ::= tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves ELIF
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves IF_NOT;
 */
 
public class _ELIF extends nodoModelo {
    
   
    /**
     * constructor de _ELIF
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ELIF(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
}
