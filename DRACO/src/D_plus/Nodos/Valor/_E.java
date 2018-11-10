/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.IdVarFunc._ID_VAR_FUNC;
import D_plus.Nodos.Valor.OpeAritmetica.division;
import D_plus.Nodos.Valor.OpeAritmetica.modulo;
import D_plus.Nodos.Valor.OpeAritmetica.multiplicacion;
import D_plus.Nodos.Valor.OpeAritmetica.potencia;
import D_plus.Nodos.Valor.OpeAritmetica.resta;
import D_plus.Nodos.Valor.OpeAritmetica.suma;
import D_plus.Nodos.Valor.OpeLogico.and;
import D_plus.Nodos.Valor.OpeLogico.not;
import D_plus.Nodos.Valor.OpeLogico.or;
import D_plus.Nodos.Valor.OpeRelacional.diferenciacion;
import D_plus.Nodos.Valor.OpeRelacional.igualacion;
import D_plus.Nodos.Valor.OpeRelacional.mayor;
import D_plus.Nodos.Valor.OpeRelacional.mayorIgual;
import D_plus.Nodos.Valor.OpeRelacional.menor;
import D_plus.Nodos.Valor.OpeRelacional.menorIgual;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  
import java.util.ArrayList;

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
E                       ::=sMenos  E
                        //Aritemeticas
                        | E  sPot  E
                        | E  sDiv  E
                        | E  sPor  E
                        | E  sMas  E
                        | E  sMenos  E
                        | E  sModulo  E

                        //Relacional

                        | E  sIgualacion  E
                        | E  sDiferenciacion  E
                        | E  sMenor  E
                        | E  sMenorIgual  E
                        | E  sMayor  E
                        | E  sMayorIgual  E

                        //logicos

                        | E  sAnd  E
                        | E  sOr  E
                        | sNot  E

                        | sAbreParent  E  sCierraParent

                        | ID_VAR_FUNC  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                        | valFalse
                        | valTrue
                        | valCadena
                        | valChar
                        | valDecimal
                        | valEntero
                        | tNulo  
                        ;
        
 */
public class _E extends nodoModelo{
    
    public _E(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */ 
    public itemValor getValor(elementoEntorno entorno){ 
        return iniciar(entorno); 
    }
    
    
    /**
     * Inicia el analisis de ejecución
     *
     * @param entorno
     * @return Retorno para revisión de break
     */
     
    public itemValor iniciar(elementoEntorno entorno) {
        itemValor retorno=new itemValor(simbolo);
             
        if(hayErrores())
            return retorno;

        switch (atributo.nivelProduccion) {

            case 0: 
                return case_0(entorno); 
 
            case 1: 
                return case_1(entorno); 
 
            case 2: 
                
                return case_2(entorno); 
            case 3: 
                return case_3(entorno); 
            case 4: 
                return case_4(entorno);  
            case 5: 
                return case_5(entorno);  
            case 6: 
                return case_6(entorno); 
            case 7:
                itemValor ret=case_7(entorno); 
                return ret; 
            case 8:
 
                return case_8(entorno);  
            case 9:
 
                return case_9(entorno);  
            case 10:
 
                return case_10(entorno);  
            case 11:
 
                return case_11(entorno);  
            case 12:
 
                return case_12(entorno);  
            case 13:
 
                return case_13(entorno);  
            case 14:
 
                return case_14(entorno);  
            case 15:
 
                return case_15(entorno);  
            case 16: 
                return case_16(entorno);  
            case 17: 
                
                //aquí retorna valId(LStVALs);
                retorno=case_17(entorno);
                return retorno;
            case 18: 
                return case_19(entorno); 
            case 19: 
                return case_19(entorno); 
            case 20: 
                return case_20(entorno); 
                
            case 21: 
                return case_21(entorno); 
            case 22:
                 
                return case_22(entorno);
            case 23:
 
                return case_23(entorno);

            default:
                println("[getValor]No se encontro el nivel");
                return new itemValor(simbolo);
        }

        //return new itemValor(simbolo);
    }

    /**
     * <br> +----------------
     * <br> | sMenos E
     * <br> +----------------
     * <br> | Producción para reconocer los numeros con signo negativo
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_0(elementoEntorno entorno) {
        
        itemValor retorno = new itemValor(simbolo);
        
        _E nodoE =(_E)listaHijos.lstHijos.get(0); 
        retorno=nodoE.getValor(entorno);
        //agrego un cero
        retorno.cadenaDasm.add("0");
        //agrego el numero
        retorno.cadenaDasm.addAll(nodoE.getValor(entorno).cadenaDasm); 
        //los resto
        retorno.cadenaDasm.add(simbolo.salidaDasm.getDiff());
        return retorno;
    }

    /**
     * <br> +----------------
     * <br> | Operación POTENCIA
     * <br> +---------------- 
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_1(elementoEntorno entorno) {  
        potencia sum=new potencia(simbolo, atributo, "POTENCIA");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno); 
    }
    
    /**
     * <br> +----------------
     * <br> | Operación de la DIVISIÓN
     * <br> +---------------- 
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_2(elementoEntorno entorno) {   
        division sum=new division(simbolo, atributo, "DIVISIÓN");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno);  
    }
    
    /**
     * <br> +----------------
     * <br> | Operación de la MULTIPLICACIÓN
     * <br> +---------------- 
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_3(elementoEntorno entorno) { 
        multiplicacion sum=new multiplicacion(simbolo, atributo, "MULTIPLICACIÓN");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno);      
    }
    
    /**
     * <br> +----------------
     * <br> | Operación de la suma
     * <br> +---------------- 
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_4(elementoEntorno entorno) {  
        suma sum=new suma(simbolo, atributo, "SUMA");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);   
    }
    
    
    /**
     * <br> +----------------
     * <br> | Operación de la Resta
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_5(elementoEntorno entorno) { 
        resta sum=new resta(simbolo, atributo, "RESTA");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno); 
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | Operación MODULO
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_6(elementoEntorno entorno) {  
        modulo sum=new modulo(simbolo, atributo, "MODULO");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno);  
    }
    /**
     * <br> +----------------
     * <br> | Operación IGUALACIÓN
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_7(elementoEntorno entorno) {      
        igualacion sum=new igualacion(simbolo, atributo, "IGUALACIÓN");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);   
    }
    
    
    /**
     * <br> +----------------
     * <br> | Operación DIFERENCIACIÓN
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_8(elementoEntorno entorno) {    
        diferenciacion sum=new diferenciacion(simbolo, atributo, "DIFERENCIACIÓN");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);
    }
    
    /**
     * <br> +----------------
     * <br> | Operación MENOR
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_9(elementoEntorno entorno) { 
        menor sum=new menor(simbolo, atributo, "MENOR");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);     
    }
    
    /**
     * <br> +----------------
     * <br> | Operación MENOR IGUAL QUE
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_10(elementoEntorno entorno) {
        menorIgual sum=new menorIgual(simbolo, atributo, "MENOR IGUAL QUE");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno); 
    }
    
    /**
     * <br> +----------------
     * <br> | Operación MAYOR
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_11(elementoEntorno entorno) {
        mayor sum=new mayor(simbolo, atributo, "MAYOR");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);    
    }
    /**
     * <br> +----------------
     * <br> | Operación MAYOR IGUAL QUE
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_12(elementoEntorno entorno) {  
        mayorIgual sum=new mayorIgual(simbolo, atributo, "MAYOR IGUAL QUE");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        
        return sum.getValor(val1,val2, entorno);  
    } 
    /**
     * <br> +----------------
     * <br> | Operación AND
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_13(elementoEntorno entorno) {     
        and sum=new and(simbolo, atributo, "AND");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno);     
    } 
    /**
     * <br> +----------------
     * <br> | Operación OR
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_14(elementoEntorno entorno) {  
        or sum=new or(simbolo, atributo, "OR");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
        itemValor val1=e1.getValor(entorno);
        ArrayList<String> tempCadenaDasm=val1.cadenaDasm;
        itemValor val2=e2.getValor(entorno);
        
        val1.cadenaDasm=tempCadenaDasm;
        
        return sum.getValor(val1,val2, entorno);      
    } 
    /**
     * <br> +----------------
     * <br> | Operación NOT
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_15(elementoEntorno entorno) {  
        not sum=new not(simbolo, atributo, "NOT");
        
        _E e1 = (_E) listaHijos.lstHijos.get(0); 
        itemValor val1=e1.getValor(entorno); 
        return sum.getValor(val1,entorno); 
    } 
    
    
    /**
     * <br> +----------------
     * <br> | Operación Parentesis
     * <br> +----------------
     * <br> | Producción para reconocer cuando vienene parentesis
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_16(elementoEntorno entorno) {  
          
         
        _E e1 = (_E) listaHijos.lstHijos.get(0); 
        
        return  e1.getValor(entorno);     
    } 
    
    
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC
     * <br> +----------------
     * <br> | Producción para reconocer cuando viene un Id
     * <br> | Hay que buscarlo dentro de la tabla de entornos, jejejejejeje
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_17(elementoEntorno entorno) {
        itemValor retorno=new itemValor(simbolo);
        _ID_VAR_FUNC nodoVarFunc=(_ID_VAR_FUNC)listaHijos.lstHijos.get(0);
        retorno=nodoVarFunc.getValor(entorno);
         
        return retorno;
    }
    
     
    /**
     * <br> +----------------
     * <br> | valFalse y ValTrue
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_19(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo);
        retorno.parseToBooleano(listaAtributos.getAtributo(0));
        if (retorno.getBooleano()) {
            //uno si es verdadero
            retorno.cadenaDasm.add("1");
        } else {
            //cero si es falso
            retorno.cadenaDasm.add("0");
        }
//        println("----impriendo-----");
//        retorno.imprimir();
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> | valCadena
     * <br> +----------------
     * <br> | Producción para reconocer los numeros
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_20(elementoEntorno entorno) { 
        itemValor retorno = new itemValor(simbolo);
        
        
        //obtengo el valor real de la cadena
        retorno.parseToCadena(listaAtributos.getAtributo(0));
        
        char [] charCadena= retorno.getCadena().toCharArray();
        int i=0;
        for (char c : charCadena) {
            double ret = c;
            if (i == 0) {
                //ya tengo el ascci de la cadena
                

                /*CODIGO*/
                //posicion inicial de la cadena
                retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
                //puntero
                retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
                // valor caracter
                retorno.cadenaDasm.add(String.valueOf(ret));
                //guardando el valor
                retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
                
                //actualizando el puntero 
                //puntero
                retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
                //aumentando la posicion
                retorno.cadenaDasm.add("1");
                //sumando
                retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
                //actualizo el heap para que apunte al siguiente
                retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));

            }else{
                 
                //puntero
                retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
                // valor caracter
                retorno.cadenaDasm.add(String.valueOf(ret));
                //guardando el valor
                retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());
                
                //actualizando el puntero 
                //puntero
                retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
                //aumentando la posicion
                retorno.cadenaDasm.add("1");
                //sumando
                retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
                //actualizo el heap para que apunte al siguiente
                retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
            }
            
            i++;
        }
        
        //ahora el caracter nulo para indicar el fin de la cadena
        
        //puntero
        retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
        // valor caracter NULO
        retorno.cadenaDasm.add("0");
        //guardando el valor
        retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_calc());

        //actualizando el puntero 
        //puntero
        retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_global_id("0"));
        //aumentando la posicion
        retorno.cadenaDasm.add("1");
        //sumando
        retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
        //actualizo el heap para que apunte al siguiente
        retorno.cadenaDasm.add(simbolo.salidaDasm.getSet_global_id("0"));
        
        
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> | valDecimal
     * <br> +----------------
     * <br> | Producción para reconocer los numeros
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_21(elementoEntorno entorno) { 
        itemValor retorno = new itemValor(simbolo);
        retorno.cadenaDasm.add(listaAtributos.getAtributo(0).valor);
        retorno.parseToNumero(listaAtributos.getAtributo(0)); 
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> | valEntero
     * <br> +----------------
     * <br> | Producción para reconocer los numeros
     * <br>
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_22(elementoEntorno entorno) { 
        itemValor retorno = new itemValor(simbolo); 
        retorno.cadenaDasm.add(listaAtributos.getAtributo(0).valor);
        retorno.parseToNumero(listaAtributos.getAtributo(0)); 
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valChar
     * <br> +----------------
     * <br> | Producción para reconocer chars
     *
     * Se inserta un valor
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_23(elementoEntorno entorno) { 
        itemValor retorno = new itemValor(simbolo);
        retorno.parseToChar(listaAtributos.getAtributo(0));
        Object ObjRet=retorno.getParseadoNumero(atributo);
        if(ObjRet==null){
            return retorno;
        }
        retorno.cadenaDasm.add(String.valueOf((double)ObjRet));
        return retorno;
    }

}
