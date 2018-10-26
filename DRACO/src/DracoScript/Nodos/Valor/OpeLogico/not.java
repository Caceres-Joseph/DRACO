/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor.OpeLogico;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;

/**
 *
 * @author joseph
 */
public class not {
    
    itemAtributo val1; 
    elementoGlobal simbolo;
    itemAtributo atrib;
    String signo;

    /**
     * constructor 
     * @param simbolo Es el ambito
     * @param atrib  Para marcar donde puede ocurrir un posibl error
     * @param signo El signo de operación
     */
    public not(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
     * Metodo que retorna el valor la operación NOT 
     *
     * @param val1 Valor del lado izquierdo 
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    public itemValor getValor(itemValor val1, elementoEntorno entorno) {

        itemValor retorno = new itemValor(simbolo);

        Object ob1 = val1.getParseadoBooleano(atrib); 

        if (ob1 == null ) {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] ");
            return retorno;
        } else {
            boolean bool1 = (boolean) ob1; 

            if (bool1) {
                retorno.setValor(false);
            } else {
                retorno.setValor(true);
            } 
            return retorno;
        }
    }
}
