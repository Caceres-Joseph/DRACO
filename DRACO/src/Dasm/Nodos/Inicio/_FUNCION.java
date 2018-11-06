/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio; 
import Dasm.Estructuras.Elementos.elementoEntorno; 
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
 FUNCION            ::= tFuncion valId LST_INSTRUCCIONES tEnd;
 */
public class _FUNCION extends nodoModelo{
    
    public _FUNCION(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
     
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * <br>Detengo el ejecutar para guardar los nodos
     * <br>Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){ 
        
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
//    @Override
//    public void primerPasada(elementoClase clase){
////         validandoDebug();
//         
//        if(hayErrores()){
//            return ;
//        }
//        
//        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
//        itemFuncion nuevaFuncion=new itemFuncion(nombreFuncion, listaHijos.lstHijos.get(0));
//        clase.listaMetodoFuncion.insertar(nuevaFuncion);
//         
//        
//        //listaHijos.primerPasada(clase);
//    }
    
    
}
