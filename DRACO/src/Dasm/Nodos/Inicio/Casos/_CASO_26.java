/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.Inicio._E;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_26 extends nodoModelo{
    
    public _CASO_26(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | E
     * <br> +----------------
     * <br> |Hay que igresar el valor a la pilita
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;  
        validandoDebug();
        _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return ;
        }
        
        
         
         //guradandolo en pilita 
        entorno.Pilita.push(valE.getNumero());  
        
    }
}
