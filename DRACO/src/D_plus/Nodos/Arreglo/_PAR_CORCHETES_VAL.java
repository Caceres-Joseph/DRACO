/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Arreglo;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Valor._VALOR;
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
PAR_CORCHETES_VAL   ::= sAbreCorchete VALOR sCierraCorchete
                    ;
 */
public class _PAR_CORCHETES_VAL extends nodoModelo{
    
    public _PAR_CORCHETES_VAL(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */

    public itemValor getIndex(elementoEntorno entorno) { 
        if (hayErrores()) {
            return new itemValor(simbolo);
        } 
      
        _VALOR nod = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val=nod.getValor(entorno);
        
        return val; 
    }
}
