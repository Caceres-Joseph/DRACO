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
public class _CASO_04 extends nodoModelo{
    
    public _CASO_04(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tDiv
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y hace la division
     * @param entorno Es el ambito que  
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
        
        if(num2==0||num2==0.0){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede dividir entre cero");
            return ;
        }

        entorno.Pilita.push(num1 / num2);
        
    }
}
