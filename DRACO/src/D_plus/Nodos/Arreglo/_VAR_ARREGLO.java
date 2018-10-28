/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Arreglo;

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
VAR_ARREGLO         ::= valId
                    |   valId  LST_CORCHETES_VAL
                    ;
 */
public class _VAR_ARREGLO extends nodoModelo{
    
    public _VAR_ARREGLO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    public itemAtributo getId(){ 
       itemAtributo retorno= listaAtributos.getAtributo(0);
       return retorno;
    }
    
    public int getDimension(){
        return 0;
    }
    
}
