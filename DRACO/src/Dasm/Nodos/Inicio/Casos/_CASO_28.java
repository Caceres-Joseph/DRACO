/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_28  extends nodoModelo{
    
    public _CASO_28(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
   
    /**
     * <br> +----------------
     * <br> | valCadena
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;
        validandoDebug();  
         //parseando a cadena
         itemValor valor=new itemValor(simbolo);
         valor.parseToCadena(listaAtributos.getAtributo(0)); 
        
        if (!valor.isTypeCadena()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo cadena, pero se recibió: "+valor.tipo);
            return ;
        }
        
         //guradandolo en pilita 
        entorno.Pilita.push(valor.getCadena());   
        
    }
}
