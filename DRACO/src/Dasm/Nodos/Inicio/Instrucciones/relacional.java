/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
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
     * @return Retorna para revisión de break
     */
    public itemRetorno case_7(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return retorno;
        }

        Double resultado = 0.0;
        if (num1 < num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);

        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | tGt
     * <br> +---------------- 
     * <br> | num1 > num2 ? 0 :1
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_8(elementoEntorno entorno) { 
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return retorno;
        }

        Double resultado = 0.0;
        if (num1 > num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);

        return retorno; 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tLte
     * <br> +---------------- 
     * <br> | num1 <= num2 ? 0 :1
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_9(elementoEntorno entorno) { 
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return retorno;
        }

        Double resultado = 0.0;
        if (num1 <= num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);

        return retorno;  
    }
    
    
    /**
     * <br> +----------------
     * <br> | tGte
     * <br> +---------------- 
     * <br> | num1 >= num2 ? 0 :1
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_10(elementoEntorno entorno) {  
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return retorno;
        }

        Double resultado = 0.0;
        if (num1 >= num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);

        return retorno;  
    }
    
}
