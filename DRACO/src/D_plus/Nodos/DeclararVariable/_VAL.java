/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.DeclararVariable;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor; 
import D_plus.Nodos.Arreglo._LLAVES_VAL_P;
import D_plus.Nodos.Parametros._LST_VAL;
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
VAL                 ::=sIgual VALOR
                    |  sIgual _LLAVES_VAL_P 
                    ;
 */
public class _VAL extends nodoModelo{
    
    public _VAL(itemAtributo atrib, elementoGlobal simbolo) {
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

    public itemValor getValor(elementoEntorno entorno) { 
        if (hayErrores()) {
            return new itemValor(simbolo);
        } 
        _VALOR nod = (_VALOR) listaHijos.lstHijos.get(0);
        return nod.getValor(entorno); 
    }
    
    
    public ArrayList<itemValor> getLstValores(elementoEntorno entorno){
        
        ArrayList<itemValor> retorno=new ArrayList<>();
        if(atributo.nivelProduccion==1){
            _LLAVES_VAL_P nodoLlaves= (_LLAVES_VAL_P)listaHijos.lstHijos.get(0);
            
            //recorriendo sus hijos que tiene que ser 
            
            for (nodoModelo lstHijo : nodoLlaves.listaHijos.lstHijos) {
                _LST_VAL nodoVals=(_LST_VAL)lstHijo;
                ArrayList<itemValor> lsta=nodoVals.getLstValores(entorno);
                retorno.addAll(lsta); 
            }
            
        }
        
        return retorno;
    }
    
}
