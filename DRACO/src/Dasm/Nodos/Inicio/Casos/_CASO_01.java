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
public class _CASO_01 extends nodoModelo{
    
    public _CASO_01(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tAdd
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y los suma
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;  
        validandoDebug();
        
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        entorno.Pilita.push(num1 + num2);
        
    }
}
