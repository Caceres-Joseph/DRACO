/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_25 extends nodoModelo {
    
    public _CASO_25(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tEqz
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;  
        validandoDebug();
        
        //extraer  de pilita 
        Double num1 = entorno.Pilita.pop(atributo);

        Double resultado = 0.0;
        if (num1 == 0.0 ) {
            resultado = 1.0;
        }
        //Operando or bit a bit

        entorno.Pilita.push(resultado);
        
    }
}
