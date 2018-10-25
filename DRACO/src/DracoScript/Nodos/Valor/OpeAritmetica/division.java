/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor.OpeAritmetica;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;

/**
 *
 * @author joseph
 */
public class division {
        
    itemAtributo val1;
    itemAtributo val2;
    elementoGlobal simbolo;
    itemAtributo atrib;
    String signo;
    public division(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
     * Metodo que retorna el valor al operar la multiplicacion
     *
     * @param val1 Valor del lado izquierdo
     * @param val2 Valor del lado derecho
     * @param entorno Es la tabla que contiene las variables
     * @return
     */

    public itemValor getValor(itemValor val1, itemValor val2, elementoEntorno entorno) { 
        
       itemValor retorno=new itemValor(simbolo);
       
        if(val1.isTypeNulo()||val2.isTypeNulo()){
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir con un valor de tipo nulo");
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | Booleano
        |--------------------------------------------------------------------------
        */
        
        /*
         *Booleano ÷ Booleano = Booleano
         */
    

        /*
         *Booleano ÷ Numero = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeNumero()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }
            
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }

            double resul = (double) ob1 / (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }


        /*
         *Booleano ÷ Cadena = Cadena
         */
      


        /*
         *Booleano ÷ Char = Cadena
         */
    
        else if (val1.isTypeBooleano()&& val2.isTypeChar()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }
            
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }

            double resul = (double) ob1 / (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }
         
        /*
        |--------------------------------------------------------------------------
        | NUMERO
        |--------------------------------------------------------------------------
        */
        
        /*
         *Numero ÷ Booleano = Numero
         */
        else if (val1.isTypeNumero() && val2.isTypeBooleano()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }
            

            double resul = (double) ob1 /(double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Numero ÷ Numero = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeNumero()) {

            
            Double dVal2= val2.getNumero();
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }
            
            double resul = val1.getNumero() / val2.getNumero();
            retorno.setValor(resul);
            return retorno;
        }


        /*
         *Numero ÷ Cadena = Cadena
         */
 
 
        /*
         *Numero ÷ Char = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeChar()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }
            
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }

            double resul = (double) ob1 / (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | CADENA
        |--------------------------------------------------------------------------
        */
         
        
        /*
        |--------------------------------------------------------------------------
        | CHAR
        |--------------------------------------------------------------------------
        */
        
        /*
         *Char ÷ Booleano = Numero
         */
        else if (val1.isTypeChar()&& val2.isTypeBooleano()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }
            
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }

            double resul = (double) ob1 / (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Char ÷ Numero = Numero
         */

        else if (val1.isTypeChar() && val2.isTypeNumero()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }
            
            
            Double dVal2= (double) ob2;
            if(dVal2==0.0|| dVal2==0){
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede dividir entre cero");
                return retorno; 
            }

            double resul = (double) ob1 / (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Char ÷ Cadena = Cadena
         */
 
 
        /*
         *Char ÷ Char = Numero
         */
        
        else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
            return retorno;
        }
          
    }
}
