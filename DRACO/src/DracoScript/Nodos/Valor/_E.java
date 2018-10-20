/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;  
import DracoScript.Estructuras.Listas.lstAtributos;
import DracoScript.Nodos.Valor.OpeAritmetica.division;
import DracoScript.Nodos.Valor.OpeAritmetica.modulo;
import DracoScript.Nodos.Valor.OpeAritmetica.multiplicacion;
import DracoScript.Nodos.Valor.OpeAritmetica.potencia;
import DracoScript.Nodos.Valor.OpeAritmetica.resta;
import DracoScript.Nodos.Valor.OpeAritmetica.suma;
import DracoScript.Nodos.Valor.OpeLogico.and;
import DracoScript.Nodos.Valor.OpeLogico.not;
import DracoScript.Nodos.Valor.OpeLogico.or;
import DracoScript.Nodos.Valor.OpeRelacional.MenorIgual;
import DracoScript.Nodos.Valor.OpeRelacional.diferenciacion;
import DracoScript.Nodos.Valor.OpeRelacional.igualacion;
import DracoScript.Nodos.Valor.OpeRelacional.mayor;
import DracoScript.Nodos.Valor.OpeRelacional.mayorIgual;
import DracoScript.Nodos.Valor.OpeRelacional.menor;
import DracoScript.Nodos.nodoModelo;

/**
 * Nodo para asignar el valor
 *
 * <br> +----------------------
 * <br> | NO TERMINAL:
 * <br> | Es donde se guardan los no terminales
 * <br> +----------------------
 * <br> E 0 ::= sMenos E
 * <br>
 * <br> //Aritemeticas
 * <br>
 * <br> 1 | E sPot E
 * <br> 2 | E sDiv E
 * <br> 3 | E sPor E
 * <br> 4 | E sMas E
 * <br> 5 | E sMenos E
 * <br> 6 | E sModulo E
 * <br>
 * <br> //Relacional
 * <br>
 * <br> 7 | E sIgualacion E
 * <br> 8 | E sDiferenciacion E
 * <br> 9 | E sMenor E
 * <br> 10| E sMenorIgual E
 * <br> 11| E sMayor E
 * <br> 12| E sMayorIgual E
 * <br>
 * <br>
 * <br> //logicos
 * <br>
 * <br> 13| E sAnd E
 * <br> 14| E sOr E
 * <br> 15| sNot E
 * <br>
 * <br> 16| sAbreParent E sCierraParent
 * <br>
 * <br> 17| valId //validar que si viene func() tiene que retornar algo 
 * <br> 18| valTrue
 * <br> 19| valFalse
 * <br> 20| valCadena
 * <br> 21| valDecimal
 * <br> 22| valEntero
 * <br> 23| valChar
 * <br>
 * <br> ;
 *
 * @author joseph
 */
public class _E extends nodoModelo {

    /**
     * constructor de _E
     *
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la
     * columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */
    public _E(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo de ejecución final
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
//    @Override
//    public itemRetorno ejecutar(elementoEntorno entorno) {
//        return listaHijos.ejecutar(entorno);
//
////        return iniciar(entorno);
//    }
    
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

        itemValor le = nod.getValor(entorno);
        Object tel = le.getNumero();
        if (tel != null) {
            double el = (double) tel;
            retorno.setValor((-1) * el);
            return retorno;
        } else {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede convertir a negativo el tipo " + le.tipo);
            return retorno;
        }
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
        potencia sum=new potencia(simbolo, listaAtributos.getAtributo(0), "POTENCIA");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        division sum=new division(simbolo, listaAtributos.getAtributo(0), "DIV");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        multiplicacion sum=new multiplicacion(simbolo, listaAtributos.getAtributo(0), "MULTIPLICACIÓN");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        suma sum=new suma(simbolo, listaAtributos.getAtributo(0), "SUMA");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        resta sum=new resta(simbolo, listaAtributos.getAtributo(0), "RESTA");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno); 
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
        modulo sum=new modulo(simbolo, listaAtributos.getAtributo(0), "MODULO");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        igualacion sum=new igualacion(simbolo, listaAtributos.getAtributo(0), "IGUALACIÓN");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        diferenciacion sum=new diferenciacion(simbolo, listaAtributos.getAtributo(0), "DIFERENCIACIÓN");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        menor sum=new menor(simbolo, listaAtributos.getAtributo(0), "MENOR");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        MenorIgual sum=new MenorIgual(simbolo, listaAtributos.getAtributo(0), "MENOR IGUAL QUE");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        mayor sum=new mayor(simbolo, listaAtributos.getAtributo(0), "MAYOR");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        mayorIgual sum=new mayorIgual(simbolo, listaAtributos.getAtributo(0), "MAYOR IGUAL QUE");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        and sum=new and(simbolo, listaAtributos.getAtributo(0), "AND");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        or sum=new or(simbolo, listaAtributos.getAtributo(0), "OR");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0);
        _E e2 = (_E) listaHijos.lstHijos.get(1);
        
         
        return sum.getValor(e1.getValor(entorno),e2.getValor(entorno), entorno);     
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
        not sum=new not(simbolo, listaAtributos.getAtributo(0), "NOT");
//        println(atributo.nombreArchivo);
        _E e1 = (_E) listaHijos.lstHijos.get(0); 
        
         
        return sum.getValor(e1.getValor(entorno), entorno);     
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
//        println("----impriendo-----");
//        retorno.imprimir();
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
        retorno.parseToNumero(listaAtributos.getAtributo(0));
//        println("----impriendo-----");
//        retorno.imprimir();
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
        retorno.parseToNumero(listaAtributos.getAtributo(0));
//        println("impriendo");
//        retorno.imprimir();
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
//        println("impriendo");
//        retorno.imprimir();
        return retorno;
    }

}
