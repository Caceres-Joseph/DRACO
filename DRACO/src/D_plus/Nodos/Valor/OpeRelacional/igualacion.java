/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor.OpeRelacional;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

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

        itemValor retorno = new itemValor(simbolo);

        if (val1.isTypeNulo() && val2.isTypeNulo()) {
            retorno.setValor(true);
            return retorno;
        } else if (val1.isTypeNulo()) {
            if (val2.isTypeNulo()) {
                retorno.setValor(true);
                return retorno;
            } else {
                retorno.setValor(false);
                return retorno;
            }
        } else if (val2.isTypeNulo()) {
            if (val1.isTypeNulo()) {
                retorno.setValor(true);
                return retorno;
            } else {
                retorno.setValor(false);
                return retorno;
            }
        } else if (val1.tipo.equals(val2.tipo)) {
            //comparando tipos
            if (val1.esEstructura) {
                simbolo.tablaErrores.insertErrorSemantic(atrib, "Solo se puelden comparar datos primitivos, no se pueden operar datos de diferente tipo " + val1.tipo + " [" + signo + "] " + val2.tipo);
                return retorno;
            } else if (val1.isTypeCadena() && val2.isTypeCadena()) {
                retorno.cadenaDasm.add(("/*"));
                retorno.cadenaDasm.add("+-----------------------");
                retorno.cadenaDasm.add("|DASM_IGUALACION_CADENAS");
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
                retorno.cadenaDasm.add(simbolo.salidaDasm.getCall("$DASM_IGUALACION_CADENAS"));
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
                retorno.setValor(true);
                return retorno;
            } else {

                retorno.cadenaDasm.addAll(val1.cadenaDasm);
                retorno.cadenaDasm.addAll(val2.cadenaDasm);
                retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
                retorno.cadenaDasm.add(simbolo.salidaDasm.getEqz());

                retorno.setValor(true);
                return retorno;
            }
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se pueden operar datos de diferente tipo " + val1.tipo + " [" + signo + "] " + val2.tipo);
            return retorno;
        }
    }
}
