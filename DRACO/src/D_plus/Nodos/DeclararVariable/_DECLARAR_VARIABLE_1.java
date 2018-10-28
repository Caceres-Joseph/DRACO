/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.DeclararVariable;

import D_plus.Estructuras.Elementos.elementoClase;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import D_plus.Estructuras.Listas.lstParametro;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 * Sirve para la primer pasada
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
                    |   DECLARAR_VARIABLE sComa VAR_ARREGLO
                    |   TIPO VAR_ARREGLO VAL
                    |   TIPO VAR_ARREGLO
                    ;
 */
public class _DECLARAR_VARIABLE_1 extends nodoModelo{
    
    public _DECLARAR_VARIABLE_1(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PRIMER PASADA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Metodo para la primer pasada
     * @param clase Es la tabla que contiene las variables  
     */
    @Override
    public void primerPasada(elementoClase clase){
        
        
        if(hayErrores()){
            return ;
        }  
        casos(clase); 
        
        //listaHijos.primerPasada(clase);
    }
     
    public void casos(elementoClase clase){
         
    }
    
}
