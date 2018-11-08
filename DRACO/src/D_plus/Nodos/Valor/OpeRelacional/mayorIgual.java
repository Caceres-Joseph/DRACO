/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor.OpeRelacional;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Valor.OpeLogico.not;
import D_plus.Nodos.Valor.OpeLogico.or;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

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
     * Metodo que retorna el valor de la igualación
     *
     * @param val1 Valor del lado izquierdo
     * @param val2 Valor del lado derecho
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    public itemValor getValor(itemValor val1, itemValor val2, elementoEntorno entorno) {

        
        igualacion igual=new igualacion(simbolo, atrib, signo); 
        mayor may=new mayor(simbolo, atrib, signo);
        or _or=new or(simbolo, atrib, signo);
        
        itemValor valIgual= igual.getValor(val1,val2, entorno);
        itemValor valMayor= may.getValor(val1, val2, entorno);
        
        return _or.getValor(valIgual, valMayor, entorno);
//        return negar.getValor(igual.getValor(val1,val2, entorno), entorno);
         
    }
}
