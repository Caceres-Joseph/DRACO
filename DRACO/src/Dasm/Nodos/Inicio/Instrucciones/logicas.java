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
public class logicas extends get {
    
    public logicas(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    } 
    
    /**
     * <br> +----------------
     * <br> | tNot
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_11(elementoEntorno entorno) {  
        itemRetorno retorno=new itemRetorno();
        if(hayErrores())
             return retorno;
        //extraer  de pilita 
        Double num1 = entorno.Pilita.pop(atributo);

     
        //Operando or bit a bit
        int resultado= ~num1.intValue(); 

        entorno.Pilita.push((double)resultado);

        return retorno; 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tAnd
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_12(elementoEntorno entorno) {
        itemRetorno retorno=new itemRetorno();
        if(hayErrores())
             return retorno;
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

     
        //Operando and bit a bit
        int resultado= num1.intValue() & num2.intValue(); 

        entorno.Pilita.push((double)resultado);

        return retorno;   
    }
    
    
    /**
     * <br> +----------------
     * <br> | tOr
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_13(elementoEntorno entorno) { 
        itemRetorno retorno=new itemRetorno();
        if(hayErrores())
             return retorno;
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

     
        //Operando or bit a bit
        int resultado= num1.intValue() | num2.intValue(); 

        entorno.Pilita.push((double)resultado);

        return retorno;  
    }
    
    
}
