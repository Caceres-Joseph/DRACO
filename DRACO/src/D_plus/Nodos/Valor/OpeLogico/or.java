/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor.OpeLogico;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class or {
    
    itemAtributo val1;
    itemAtributo val2;
    elementoGlobal simbolo;
    itemAtributo atrib;
    String signo;

    /**
     * constructor 
     * @param simbolo Es el ambito
     * @param atrib  Para marcar donde puede ocurrir un posibl error
     * @param signo El signo de operación
     */
    public or(elementoGlobal simbolo, itemAtributo atrib, String signo){
        this.simbolo=simbolo;
        this.atrib=atrib;
        this.signo=signo;
    }
    
 
  
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor la operación OR 
     *
     * @param val1 Valor del lado izquierdo
     * @param val2 Valor del lado derecho
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    public itemValor getValor(itemValor val1, itemValor val2, elementoEntorno entorno) {

        
       itemValor retorno=new itemValor(simbolo);
       
        if(val1.isTypeNulo()||val2.isTypeNulo()){
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede ["+signo+"] con un valor de tipo nulo");
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | Booleano
        |--------------------------------------------------------------------------
        */
        
        /*
         *Booleano + Booleano = Booleano
         */
        else if (val1.isTypeBooleano() && val2.isTypeBooleano()) {
 
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getOr());
            
            //mantengo el valor como booleano
            retorno.setValor(true);
            return retorno;
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar   " + val1.tipo + " [" + signo + "] " + val2.tipo);
            return retorno;
        }
    }
}
