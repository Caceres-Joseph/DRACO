/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    E                  ::=valEntero
                       |  valDecimal
                       ;
 */
public class _E extends nodoModelo {
    
    public _E(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */ 
    public itemValor getValor(elementoEntorno entorno){ 
        return iniciar(entorno); 
    }
    
    /**
     * Inicia el analisis de ejecución
     *
     * @param entorno
     * @return Retorno para revisión de break
     */
     
    public itemValor iniciar(elementoEntorno entorno) {
        itemValor retorno=new itemValor(simbolo);
             
        if(hayErrores())
            return retorno;

        switch (atributo.nivelProduccion) {

            case 0:
                if(hayErrores())
                    return retorno;
                
                return case_0(entorno); 
 
            case 1:
                if(hayErrores())
                    return retorno;
                
                return case_1(entorno); 
            default:
                return retorno;
        }
    }
    
    
    /**
     * <br> +----------------
     * <br> | valEntero
     * <br> +----------------
     * <br> | Producción para reconocer los numeros
     * <br>
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_0(elementoEntorno entorno) { 
        
        itemValor retorno = new itemValor(simbolo);
        retorno.parseToNumero(listaAtributos.getAtributo(0)); 
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> | valDecimal
     * <br> +----------------
     * <br> | Producción para reconocer los numeros
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_1(elementoEntorno entorno) { 
        itemValor retorno = new itemValor(simbolo);
        retorno.parseToNumero(listaAtributos.getAtributo(0)); 
        return retorno;
    }
    
}
