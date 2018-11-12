/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Arreglo;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
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
        
        switch(atributo.nivelProduccion){
            case 0:
                return 0;
            case 1:
                _LST_CORCHETES_VAL nodoLst=(_LST_CORCHETES_VAL)listaHijos.lstHijos.get(0);
                int val= nodoLst.getNumDimensiones();
                return val;
            default:
                println("[getDimension]No coincidió ningun caso");
                return 0;
        }
    }
    
    public ArrayList<itemValor> indicesDimension(elementoEntorno entorno){
        ArrayList<itemValor> retorno=new ArrayList<>();
        switch(atributo.nivelProduccion){
            case 0:
                return retorno;
            case 1:
                _LST_CORCHETES_VAL nodoLst=(_LST_CORCHETES_VAL)listaHijos.lstHijos.get(0);
                retorno = nodoLst.indicesDimension(entorno);
                return retorno;
            default:
                println("[getDimension]No coincidió ningun caso");
                return retorno;
        }
        
        
    }
    
}
