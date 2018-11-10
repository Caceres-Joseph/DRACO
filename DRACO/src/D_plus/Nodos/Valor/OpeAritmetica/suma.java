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
        }
         
        /*
         *Booleano + Numero = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeNumero()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }


        /*
         *Booleano + Cadena = Cadena
         */
        else if (val1.isTypeBooleano() && val2.isTypeCadena()) {

            /*CONVIRTIENDO NUMERO A CADENA*/
            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add(("/*"));
            param2.cadenaDasm.add("+-----------------------");
            param2.cadenaDasm.add("| DASM_DECIMAL_A_CADENA");
            param2.cadenaDasm.add("*/");
            /*PARAM 1*/
            param2.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            param2.cadenaDasm.add("//Operaciones E");
            param2.cadenaDasm.addAll(val1.cadenaDasm);
 
            //comentarios 
            param2.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_DECIMAL_A_CADENA"));
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            param2.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            param2.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + val2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno;

        }


        /*
         *Booleano + Char = Numero
         */
        else if (val1.isTypeBooleano() && val2.isTypeChar()) {

            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
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
        else if (val1.isTypeNumero() && val2.isTypeBooleano()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Numero + Numero = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeNumero()) {
            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }


        /*
         *Numero + Cadena = Cadena
         */
        else if (val1.isTypeNumero() && val2.isTypeCadena()) {

            /*CONVIRTIENDO NUMERO A CADENA*/
            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add(("/*"));
            param2.cadenaDasm.add("+-----------------------");
            param2.cadenaDasm.add("| DASM_DECIMAL_A_CADENA");
            param2.cadenaDasm.add("*/");
            /*PARAM 1*/
            param2.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            param2.cadenaDasm.add("//Operaciones E");
            param2.cadenaDasm.addAll(val1.cadenaDasm);
 
            //comentarios 
            param2.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_DECIMAL_A_CADENA"));
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            param2.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            param2.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + val2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno;
          
             

        }
 
        /*
         *Numero + Char = Numero
         */

        else if (val1.isTypeNumero() && val2.isTypeChar()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }
        
        /*
        |--------------------------------------------------------------------------
        | CADENA
        |--------------------------------------------------------------------------
        */
        
        /*
         *Cadena + Booleano = Cadena
         */
        else if (val1.isTypeCadena() && val2.isTypeBooleano()) {
            /*CONVIRTIENDO NUMERO A CADENA*/
            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add(("/*"));
            param2.cadenaDasm.add("+-----------------------");
            param2.cadenaDasm.add("| DASM_DECIMAL_A_CADENA");
            param2.cadenaDasm.add("*/");
            /*PARAM 1*/
            param2.cadenaDasm.add("//PARAMETRO 1:" + val2.tipo);
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            param2.cadenaDasm.add("//Operaciones E");
            param2.cadenaDasm.addAll(val2.cadenaDasm);
 
            //comentarios 
            param2.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_DECIMAL_A_CADENA"));
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            param2.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            param2.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val1.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno;
        }

        /*
         *Cadena + Numero = Cadena
         */
        else if (val1.isTypeCadena() && val2.isTypeNumero()) {
            /*CONVIRTIENDO NUMERO A CADENA*/
            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add(("/*"));
            param2.cadenaDasm.add("+-----------------------");
            param2.cadenaDasm.add("| DASM_DECIMAL_A_CADENA");
            param2.cadenaDasm.add("*/");
            /*PARAM 1*/
            param2.cadenaDasm.add("//PARAMETRO 1:" + val2.tipo);
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            param2.cadenaDasm.add("//Operaciones E");
            param2.cadenaDasm.addAll(val2.cadenaDasm);
 
            //comentarios 
            param2.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_DECIMAL_A_CADENA"));
            //obtengo el puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            param2.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            param2.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            param2.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val1.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno;
        }

        /*
         *Cadena + Cadena = Cadena
         */
        
        else if (val1.isTypeCadena() && val2.isTypeCadena()) {

            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val1.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + val1.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno; 
        }
 
        /*
         *Cadena + Char = Cadena
         */
        else if (val1.isTypeCadena() && val2.isTypeChar()) {

            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add("//Guardando el caracter en el heap");
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
//            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_global_id("0"), "Guardando el caracter en el heap", entorno.nivel);
            //colocando el caracter
            for (String string : val2.cadenaDasm) {
                param2.cadenaDasm.add(string);
            }
            //guardando el caracter 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
            
            //actualizando el puntero del heap
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //termino de actualizar el puntero 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
            
            
            
            //ahora hay que ir a traer el valor del heap
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("0");
            //guardando el caracter 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //termino de actualizar el puntero 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
            
            
            
            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + val1.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val1.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
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
        else if (val1.isTypeChar()&& val2.isTypeBooleano()) {

            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Char + Numero = Numero
         */

        else if (val1.isTypeChar() && val2.isTypeNumero()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
        }

        /*
         *Char + Cadena = Cadena
         */
        
        else if (val1.isTypeChar() && val2.isTypeCadena()) {

            itemValor param2=new itemValor(simbolo);
            param2.setValor("");
            
            param2.cadenaDasm.add("//Guardando el caracter en el heap");
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
//            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_global_id("0"), "Guardando el caracter en el heap", entorno.nivel);
            //colocando el caracter
            for (String string : val1.cadenaDasm) {
                param2.cadenaDasm.add(string);
            }
            //guardando el caracter 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
            
            //actualizando el puntero del heap
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //termino de actualizar el puntero 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
            
            
            
            //ahora hay que ir a traer el valor del heap
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("0");
            //guardando el caracter 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
            //hay que guardar el caracter en el heap prro
            param2.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
            //incremento en 1
            param2.cadenaDasm.add("1");
            //sumando
            param2.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //termino de actualizar el puntero 
            param2.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
            
            
            
            
            /**
             * AHORA CONCATENANDO LAS CADENAS
             */
            
            retorno.cadenaDasm.add(("/*"));
            retorno.cadenaDasm.add("+-----------------------");
            retorno.cadenaDasm.add("| DASM_CONCATENAR_CADENAS");
            retorno.cadenaDasm.add("*/");
            /*PARAM 1*/
            retorno.cadenaDasm.add("//PARAMETRO 1:" + param2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("1");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(param2.cadenaDasm);

            /*PARAM 2*/
            retorno.cadenaDasm.add("//PARAMETRO 2:" + val2.tipo);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumanodo
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.cadenaDasm.add("2");
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //operaciones E
            retorno.cadenaDasm.add("//Operaciones E");
            retorno.cadenaDasm.addAll(val2.cadenaDasm);

            //comentarios 
            retorno.cadenaDasm.add("//Iniciando llamado");
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamanio del ambito para avanzar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));
            //llamando a la funcion prro
            retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_CONCATENAR_CADENAS"));
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));

            //tamanio del ambito para regresar
            retorno.cadenaDasm.add(String.valueOf(entorno.posRelativa - 1));
            //resto
            retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
            //actualizando puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_local_id("0"));

            retorno.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
            //colocando el retorno en la pila
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());

            retorno.setValor("cadena");
            return retorno;
             
        }
 
        /*
         *Char + Char = Numero
         */
        else if (val1.isTypeChar() && val2.isTypeChar()) {

            
            retorno.cadenaDasm.addAll(val1.cadenaDasm);
            retorno.cadenaDasm.addAll(val2.cadenaDasm);
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
           
            retorno.setValor(1.0);
            return retorno;
            
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede operar el  " + val1.tipo + "[" + signo + "] " + val2.tipo);
            return retorno;
        } 
    }
   
    
}
