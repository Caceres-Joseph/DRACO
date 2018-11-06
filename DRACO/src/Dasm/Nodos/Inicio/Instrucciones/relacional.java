/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno; 
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class relacional extends num {

    public relacional(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
 
     
    /**
     * <br> +----------------
     * <br> | tLt
     * <br> +---------------- 
     * <br> | num1 < num2 ? 0 :1
     * @param entorno Es el ambito que recibe 
     */
    public void case_7(elementoEntorno entorno) { 
        if (hayErrores()) {
            return ;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        Double resultado = 0.0;
        if (num1 < num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tGt
     * <br> +---------------- 
     * <br> | num1 > num2 ? 0 :1
     * @param entorno Es el ambito que recibe 
     */
    public void case_8(elementoEntorno entorno) {  
        if (hayErrores()) {
            return ;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        Double resultado = 0.0;
        if (num1 > num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tLte
     * <br> +---------------- 
     * <br> | num1 <= num2 ? 0 :1
     * @param entorno Es el ambito que recibe 
     */
    public void case_9(elementoEntorno entorno) {  
        if (hayErrores()) {
            return ;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        Double resultado = 0.0;
        if (num1 <= num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tGte
     * <br> +---------------- 
     * <br> | num1 >= num2 ? 0 :1
     * @param entorno Es el ambito que recibe 
     */
    public void case_10(elementoEntorno entorno) {   
        if (hayErrores()) {
            return ;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        Double resultado = 0.0;
        if (num1 >= num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);
 
    }
    
}
