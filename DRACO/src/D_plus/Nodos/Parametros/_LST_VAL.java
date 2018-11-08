/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Parametros;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Valor._E;
import D_plus.Nodos.Valor._VALOR;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  
import java.util.ArrayList;

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
LST_VAL             ::= VALOR VALOR VALOR
* 
                    ;
 */
public class _LST_VAL extends nodoModelo {
    
    public _LST_VAL(itemAtributo atrib, elementoGlobal simbolo) {
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

    public ArrayList<itemValor> getLstValores(elementoEntorno entorno) { 
        ArrayList<itemValor> retorno=new ArrayList<>();
        if (hayErrores()) {
            return retorno;
        } 
        
        
        //llenando la lista con los retornos
        for (nodoModelo lstHijo : listaHijos.lstHijos) {
             _VALOR nod = (_VALOR) lstHijo;
             retorno.add(nod.getValor(entorno));
            
        }
        
        
        return retorno;

    }
}
