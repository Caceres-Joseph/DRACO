/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Parametros;

import D_plus.Estructuras.Items.itemParametro;
import D_plus.Nodos.Arreglo._VAR_ARREGLO;
import D_plus.Nodos.Inicio._TIPO;
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
PARAMETRO           ::=TIPO VAR_ARREGLO
 */
public class _PARAMETRO extends nodoModelo{
    
    public _PARAMETRO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    public itemParametro getParametro(){
        _TIPO tip=(_TIPO)listaHijos.lstHijos.get(0);
        _VAR_ARREGLO varArr=(_VAR_ARREGLO)listaHijos.lstHijos.get(1);
         
        itemAtributo id=varArr.getId();
        itemAtributo tipo= tip.getTipo();
        int dimension= varArr.getDimension();
        
        return new itemParametro(id, tipo, dimension); 
    }
    
}
