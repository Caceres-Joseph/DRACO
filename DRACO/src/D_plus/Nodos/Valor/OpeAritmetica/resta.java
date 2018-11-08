/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor.OpeAritmetica;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class resta {
    
    itemAtributo val1;
    itemAtributo val2;
    elementoGlobal simbolo;
    itemAtributo atrib;
    String signo;
    public resta(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
     * Metodo que retorna el valor al operar la suma
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
         *Booleano - Booleano = Booleano
         */ 
         
        /*
         *Booleano - Numero = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeNumero()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }


        /*
         *Booleano - Cadena = Cadena
         */ 

        /*
         *Booleano - Char = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeChar()) {

            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;

        }
        
        
        /*
        |--------------------------------------------------------------------------
        | NUMERO
        |--------------------------------------------------------------------------
        */
        
        /*
         *Numero - Booleano = Numero
         */
        else if (val1.isTypeNumero() && val2.isTypeBooleano()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Numero - Numero = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeNumero()) {
            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }


        /*
         *Numero - Cadena = Cadena
         */ 
 
        /*
         *Numero - Char = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeChar()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | CADENA
        |--------------------------------------------------------------------------
        */
        
        /*
         *Cadena - Booleano =  
         */ 
        /*
         *Cadena - Numero =  
         */ 
        /*
         *Cadena - Cadena =  
         */
         
        /*
         *Cadena - Char =  
         */ 
        
        /*
        |--------------------------------------------------------------------------
        | CHAR
        |--------------------------------------------------------------------------
        */
        
        /*
         *Char - Booleano = Numero
         */
        else if (val1.isTypeChar()&& val2.isTypeBooleano()) {

            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Char - Numero = Numero
         */

        else if (val1.isTypeChar() && val2.isTypeNumero()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Char - Cadena =  
         */
         
 
        /*
         *Char - Char = Numero
         */
        else if (val1.isTypeChar() && val2.isTypeChar()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
           
            retorno.setValor(1.0);
            return retorno;
            
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
            return retorno;
        }
          
    }
   
    
    
}
