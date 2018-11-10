/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Estructura;

import D_plus.Estructuras.Elementos.elementoClase;
import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemEstructura;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Nodos.DeclararVariable._DECLARAR_VARIABLE;
import D_plus.Nodos.DeclararVariable._LST_DECLARAR_VAR;
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
ESTRUCTURA          ::= tEstructura valId sAbreLlave LST_DECLARAR_VAR sCierraLlave;
 */
public class _ESTRUCTURA extends nodoModelo{
    
    public _ESTRUCTURA(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        itemRetorno retorno=new itemRetorno();
        //para que no ejecute el metodo/funcion
        
        return retorno;
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
     
    public void casos(elementoClase clase) {
        _LST_DECLARAR_VAR nodoLstDeclarar = (_LST_DECLARAR_VAR) listaHijos.lstHijos.get(0);
        itemAtributo nombre= listaAtributos.getAtributo(0);
        //creando la estructura
        itemEstructura nuevaEstructura=new itemEstructura(simbolo, nombre);
        
        //llenando de variables la estructura
        for (nodoModelo lstHijo : nodoLstDeclarar.listaHijos.lstHijos) {
            _DECLARAR_VARIABLE nodoDeclararVar = (_DECLARAR_VARIABLE) lstHijo;
            nodoDeclararVar.llenarEstructura( nuevaEstructura);  
        }
        
        
        //insertando la nueva estructura
        clase.listaEstructuras.insertar(nombre, nuevaEstructura);
//        
//        
//        println("----------Imprimiendo las variables dentro de la estructura");
//        nuevaEstructura.lstVariables.imprimir();
//        
       

    }
    
    
    
}
