/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Sentencia.For;

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
FOR     ::= tPara  sAbreParent  DECLARAR_VARIABLE  sPuntoComa  E  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tPara  sAbreParent  ASIG_VALOR  sPuntoComa  E  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        ;
 */
public class _FOR extends nodoModelo{
    
    public _FOR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
