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
public class _CASO_06 extends nodoModelo{
    
    public _CASO_06(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tPot
     * <br> +---------------- 
     * <br> | Extrae los dos numeros de la pilita y hace la potencia
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
