/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno; 
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class aritmeticas extends nodoModelo{
    
    
    /**
     * Aquí se encuentran todas las operaciones aritmeticas posibles en DASM
     * @param atrib
     * @param simbolo 
     */
    public aritmeticas(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
    /**
     * <br> +----------------
     * <br> | tAdd
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y los suma
     * @param entorno Es el ambito que recibe 
     */
    public void case_1(elementoEntorno entorno) {  
        if(hayErrores())
             return ;
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        entorno.Pilita.push(num1 + num2);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tDiff
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y los resta
     * @param entorno Es el ambito que recibe 
     */
    public void case_2(elementoEntorno entorno) { 
        
        if(hayErrores())
             return ;
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        entorno.Pilita.push(num1 - num2);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tMult
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y los multiplica
     * @param entorno Es el ambito que recibe 
     */
    public void case_3(elementoEntorno entorno) {   
        if(hayErrores())
             return ;
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        entorno.Pilita.push(num1 * num2);
 
    }
    
    
    /**
     * <br> +----------------
     * <br> | tDiv
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y hace la division
     * @param entorno Es el ambito que  
     */
    public void case_4(elementoEntorno entorno) {  
        
        if(hayErrores())
             return ;
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
    
    
    /**
     * <br> +----------------
     * <br> | tMod
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y saca el modulo
     * @param entorno Es el ambito que recibe 
     */
    public void case_5(elementoEntorno entorno) {  
        if(hayErrores())
             return ;
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

        entorno.Pilita.push(num1 % num2);
 
    }
     
    /**
     * <br> +----------------
     * <br> | tPot
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y hace la potencia
     * @param entorno Es el ambito que recibe 
     */
    public void case_6(elementoEntorno entorno) { 
        if (hayErrores()) {
            return ;
        }
        //extraer los dos numeros de pilita
        Double num2 = entorno.Pilita.pop(atributo);
        Double num1 = entorno.Pilita.pop(atributo);

        if (num1 == null || num2 == null) {
            return ;
        }

        if ((num2 == 0 || num2 == 0.0) && (num1 == 0 || num1 == 0.0)) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede Operar la potencia donde la base y el exponente son ceros");
            return ;
        }

        Double potencia=1.0;
        try {
            potencia=Math.pow(num1, num2);
        } catch (Exception e) {
            println("[case6][ERROR]Potencia falló|"+e.getMessage());
        }
        entorno.Pilita.push(potencia);
 
    }
    
    
}
