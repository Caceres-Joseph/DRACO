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
public class igualacion {
    
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
    public igualacion(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
        
       itemValor retorno=new itemValor(simbolo); 
       
        if (val1.isTypeNulo() && val2.isTypeNulo()) {
            retorno.setValor(true);
            return retorno;
        } else if (val1.isTypeNulo()) {
            if(val2.isTypeNulo()){
                retorno.setValor(true);
                return retorno;
            }else{
                retorno.setValor(false);
                return retorno;
            }
        } else if (val2.isTypeNulo()) {
            if(val1.isTypeNulo()){
                retorno.setValor(true);
                return retorno;
            }else{
                retorno.setValor(false);
                return retorno;
            } 
        }else if(val1.tipo.equals(val2.tipo)){
            if(val1.valor.equals(val2.valor)){
                retorno.setValor(true);
                return retorno;
            }else{
                retorno.setValor(false);
                return retorno;
            }
        }else{
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se pueden igualar datos de diferente tipo");
            return retorno;
        }  
    }
}