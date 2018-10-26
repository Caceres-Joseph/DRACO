/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor.OpeRelacional;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor; 

/**
 *
 * @author joseph
 */
public class diferenciacion {
    
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
    public diferenciacion(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
     * Metodo que retorna el valor de la diferenciación
     *
     * @param val1 Valor del lado izquierdo
     * @param val2 Valor del lado derecho
     * @param entorno Es la tabla que contiene las variables
     * @return
     */

    public itemValor getValor(itemValor val1, itemValor val2, elementoEntorno entorno) {  
        igualacion sum=new igualacion(simbolo, atrib, signo); 
        itemValor retorno = new itemValor(simbolo);
        
        itemValor ol2= sum.getValor(val1,val2, entorno);
        Object ol1= ol2.getBooleano();
        
        if(ol1!=null){
            boolean bol=(boolean)ol1;
            if(bol){
                retorno.setValor(false);
                return retorno;
            }else{
                retorno.setValor(true);
                return retorno;
            }
        }else{
            return ol2;
        } 
    }
}
