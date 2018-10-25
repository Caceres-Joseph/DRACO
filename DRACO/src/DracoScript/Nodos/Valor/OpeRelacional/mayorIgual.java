/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor.OpeRelacional;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;

/**
 *
 * @author joseph
 */
public class mayorIgual {
    
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
    public mayorIgual(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
     * Metodo que retorna el valor de la Op mayor igual que
     *
     * @param val1 Valor del lado izquierdo
     * @param val2 Valor del lado derecho
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    public itemValor getValor(itemValor val1, itemValor val2, elementoEntorno entorno) {

        itemValor retorno = new itemValor(simbolo);

        Object ob1 = val1.getParseadoNumero(atrib);
        Object ob2 = val2.getParseadoNumero(atrib);

        if (ob1 == null || ob2 == null) {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
            return retorno;
        } else {
            double entero1 = (double) ob1;
            double entero2 = (double) ob2;

            if (entero1 >= entero2) {
                retorno.setValor(true);
            } else {
                retorno.setValor(false);
            }
            return retorno;
        }
    }
}
