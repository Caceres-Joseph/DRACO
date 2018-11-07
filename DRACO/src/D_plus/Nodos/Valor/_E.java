/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Valor.OpeAritmetica.suma;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  

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
                if(hayErrores())
                    return retorno;
                
                return case_0(entorno); 
 
            case 1:
                if(hayErrores())
                    return retorno;
                
                return case_1(entorno); 
 
            case 2:
                if(hayErrores())
                    return retorno;
                
                return case_2(entorno); 
            case 3:
                if(hayErrores())
                    return retorno; 
                return case_3(entorno); 
            case 4:
                if(hayErrores())
                    return retorno; 
                return case_4(entorno);  
            case 5:
                if(hayErrores())
                    return retorno; 
                return case_5(entorno);  
            case 6:
                if(hayErrores())
                    return retorno; 
                return case_6(entorno); 
            case 7:

                if(hayErrores())
                    return retorno; 
                return case_7(entorno);  
            case 8:

                if(hayErrores())
                    return retorno; 
                return case_8(entorno);  
            case 9:

                if(hayErrores())
                    return retorno; 
                return case_9(entorno);  
            case 10:

                if(hayErrores())
                    return retorno; 
                return case_10(entorno);  
            case 11:

                if(hayErrores())
                    return retorno; 
                return case_11(entorno);  
            case 12:

                if(hayErrores())
                    return retorno; 
                return case_12(entorno);  
            case 13:

                if(hayErrores())
                    return retorno; 
                return case_13(entorno);  
            case 14:

                if(hayErrores())
                    return retorno; 
                return case_14(entorno);  
            case 15:

                if(hayErrores())
                    return retorno; 
                return case_15(entorno);  
            case 16:
                if(hayErrores())
                    return retorno;
                
                return case_16(entorno);  
            case 17:
                if(hayErrores())
                    return retorno;
                
                return case_17(entorno);
            case 18:
                if(hayErrores())
                    return retorno;
                
                return case_19(entorno); 
            case 19:
                if(hayErrores())
                    return retorno;
                
                return case_19(entorno); 
            case 20:
                if(hayErrores())
                    return retorno;
                
                return case_20(entorno); 
                
            case 21:
                if(hayErrores())
                    return retorno;
                
                return case_21(entorno); 
            case 22:
                
                if(hayErrores())
                    return retorno;

                return case_22(entorno);
            case 23:

                if (hayErrores()) {
                    return retorno;
                }

                return case_23(entorno);

            default:
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
        _E nod = (_E) listaHijos.lstHijos.get(0);

//        itemValor le = nod.getValor(entorno);
//        Object tel = le.getNumero();
//        if (tel != null) {
//            double el = (double) tel;
//            retorno.setValor((-1) * el);
//            return retorno;
//        } else {
//            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede convertir a negativo el tipo " + le.tipo);
//            
//        }
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;     
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor val2=e2.getValor(entorno);
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;     
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;     
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;       
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;        
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;         
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
        itemValor retorno = new itemValor(simbolo);
        return retorno;      
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
     * <br> | valId
     * <br> +----------------
     * <br> | Producción para reconocer cuando viene un Id
     * <br> | Hay que buscarlo dentro de la tabla de entornos, jejejejejeje
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemValor case_17(elementoEntorno entorno) {
        return entorno.getValVariable(listaAtributos.getAtributo(0)); 
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
