/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionMetodo;

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
MAIN                ::= TIPO tPrincipal sAbreParent  sCierraParent sAbreLlave  LST_CUERPO  sCierraLlave
                    |   tPrincipal sAbreParent  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave              
                    ;
 */
public class _MAIN extends nodoModelo{
    
    public _MAIN(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
