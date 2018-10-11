/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor.OpeAritmetica;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.Valor._E;

/**
 *
 * @author joseph
 */
public class suma {
    
    itemAtributo val1;
    itemAtributo val2;
    elementoGlobal simbolo;
    itemAtributo atrib;
    String signo;
    public suma(elementoGlobal simbolo, itemAtributo atrib, String signo){
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
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede sumar con un valor de tipo nulo");
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
        if (val1.isTypeBooleano() && val2.isTypeBooleano()) {

            boolean reto = val1.getBooleano() || val2.getBooleano();

            retorno.setValor(reto);
            return retorno;
        }

        /*
         *Booleano + Numero = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeNumero()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }


        /*
         *Booleano + Cadena = Cadena
         */
        else if (val1.isTypeBooleano() && val2.isTypeCadena()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;

        }


        /*
         *Booleano + Char = Cadena
         */
        else if (val1.isTypeBooleano() && val2.isTypeChar()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;

        }
        
        
        /*
        |--------------------------------------------------------------------------
        | NUMERO
        |--------------------------------------------------------------------------
        */
        
        /*
         *Numero + Booleano = Numero
         */
        if (val1.isTypeNumero() && val2.isTypeBooleano()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Numero + Numero = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeNumero()) {

            double resul = val1.getNumero() + val2.getNumero();
            retorno.setValor(resul);
            return retorno;
        }


        /*
         *Numero + Cadena = Cadena
         */
        else if (val1.isTypeNumero() && val2.isTypeCadena()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;

        }
 
        /*
         *Numero + Char = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeChar()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | CADENA
        |--------------------------------------------------------------------------
        */
        
        /*
         *Cadena + Booleano = Numero
         */
        if (val1.isTypeCadena() && val2.isTypeBooleano()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Cadena + Numero = Numero
         */
        else if (val1.isTypeCadena() && val2.isTypeNumero()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Cadena + Cadena = Cadena
         */
        
        else if (val1.isTypeCadena() && val2.isTypeCadena()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;

        }
 
        /*
         *Cadena + Char = Numero
         */
        else if (val1.isTypeCadena() && val2.isTypeChar()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | CHAR
        |--------------------------------------------------------------------------
        */
        
        /*
         *Char + Booleano = Numero
         */
        if (val1.isTypeChar()&& val2.isTypeBooleano()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Char + Numero = Numero
         */

        else if (val1.isTypeChar() && val2.isTypeNumero()) {

            Object ob1 = val1.getParseadoNumero(atrib);
            Object ob2 = val2.getParseadoNumero(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            double resul = (double) ob1 + (double) ob2;
            retorno.setValor(resul);
            return retorno;
        }

        /*
         *Char + Cadena = Cadena
         */
        
        else if (val1.isTypeChar() && val2.isTypeCadena()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);

                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;

        }
 
        /*
         *Char + Char = Numero
         */
        else if (val1.isTypeChar() && val2.isTypeChar()) {

            Object ob1 = val1.getParseadoCadena(atrib);
            Object ob2 = val2.getParseadoCadena(atrib);

            if (ob1 == null || ob2 == null) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
                return retorno;
            }

            String resul = (String) ob1 + (String) ob2;
            retorno.setValor(resul);
            return retorno;
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
            return retorno;
        }
        
        
        

    }
   
    
}
