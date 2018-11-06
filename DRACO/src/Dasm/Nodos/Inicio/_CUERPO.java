/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio; 
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
    S               ::= LST_CUERPO;
 */
public class _CUERPO extends nodoModelo{
    
    public _CUERPO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables
     * @return El retorno es cuando viene un break
     */
//    @Override
//    public itemRetorno ejecutar(elementoEntorno entorno){
//        validandoDebug();
//       
//        itemRetorno retorno=new itemRetorno();
//        if(hayErrores()){
//            return retorno;
//        } 
//        return listaHijos.ejecutar(entorno);
//    }
    
}
