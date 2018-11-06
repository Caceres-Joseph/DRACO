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
    LST_INSTRUCCIONES   ::= LST_INSTRUCCIONES INSTRUCCION
                        |   INSTRUCCION
 */
public class _LST_INSTRUCCIONES extends nodoModelo{
    
    public _LST_INSTRUCCIONES(itemAtributo atrib, elementoGlobal simbolo) {
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
        //aquí desencadena el inicio de ejecucion de instruccioens
         
        while(listaHijosHash.hashHijos.containsKey(entorno.punteroCodigo)){
            listaHijosHash.hashHijos.get(entorno.punteroCodigo).ejecutar(entorno);
        }
    }
}
