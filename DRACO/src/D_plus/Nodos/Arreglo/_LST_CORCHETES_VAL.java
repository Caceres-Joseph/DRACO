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
import java.util.ArrayList;

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
LST_CORCHETES_VAL   ::= LST_CORCHETES_VAL PAR_CORCHETES_VAL
                    |   PAR_CORCHETES_VAL
 */
public class _LST_CORCHETES_VAL extends nodoModelo{
    
    public _LST_CORCHETES_VAL(itemAtributo atrib, elementoGlobal simbolo) {
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

    public itemValor getDimensionLarga(elementoEntorno entorno) { 
        itemValor retorno=new itemValor(simbolo);
        
        if (hayErrores()) 
            return retorno;
        
        itemValor indice=new itemValor(simbolo);
        int ind=0;
        for (nodoModelo lstHijo : listaHijos.lstHijos) {
            _PAR_CORCHETES_VAL nodoParCorche=(_PAR_CORCHETES_VAL)lstHijo;
            itemValor val=nodoParCorche.getIndex(entorno);
            
            if(ind==0){
                indice.cadenaDasm.addAll(val.cadenaDasm);
            }else{
                indice.cadenaDasm.addAll(val.cadenaDasm);
                //multiplicando para encontrar la dimension correcta
                indice.cadenaDasm.add(simbolo.salidaDasm.getMult()); 
            }
            
            ind++;
        } 
        return indice; 
    }
    
    public ArrayList<itemValor> indicesDimension(elementoEntorno entorno){
        ArrayList<itemValor> retorno=new ArrayList<>();
        
        for (nodoModelo lstHijo : listaHijos.lstHijos) {
            _PAR_CORCHETES_VAL nodoParCorche=(_PAR_CORCHETES_VAL)lstHijo;
            itemValor val=nodoParCorche.getIndex(entorno);
            retorno.add(val);
        } 
        return retorno;
    }
    
    
    public int getNumDimensiones(){ 
        
        if (hayErrores()) 
            return 0;
        
        return listaHijos.lstHijos.size();
    }
    
    
    
    
}
