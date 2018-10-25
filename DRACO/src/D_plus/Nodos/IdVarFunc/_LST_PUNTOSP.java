/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.IdVarFunc;

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
LST_PUNTOSP         ::= sPunto  valId
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent
                    |   sPunto  valId  sAbreParent           sCierraParent

                    //Corchetes
                    |   sPunto  valId  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
                    ;
 */
public class _LST_PUNTOSP extends nodoModelo{
    
    public _LST_PUNTOSP(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
