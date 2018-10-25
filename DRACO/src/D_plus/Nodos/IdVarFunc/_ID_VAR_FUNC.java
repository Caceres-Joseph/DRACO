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
ID_VAR_FUNC         ::= ID_VAR_FUNC LST_PUNTOSP
                    |   valId
                    |   valId sAbreParent  LST_VAL  sCierraParent
                    |   valId sAbreParent           sCierraParent
                    //para hacer uso de corchetes
                    |   valId  LST_CORCHETES_VAL
                    |   valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
 */
public class _ID_VAR_FUNC extends nodoModelo {
    
    public _ID_VAR_FUNC(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
