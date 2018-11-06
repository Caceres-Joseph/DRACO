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
public class _CASO_07 extends nodoModelo{
    
    public _CASO_07(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tLt
     * <br> +---------------- 
     * <br> | num1 < num2 ? 0 :1
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

        Double resultado = 0.0;
        if (num1 < num2) {
            resultado = 1.0;
        }
        entorno.Pilita.push(resultado);
        
    }
    
    
}
