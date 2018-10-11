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
import DracoScript.Nodos.Valor.OpeAritmetica.suma;
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
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        return listaHijos.ejecutar(entorno);

//        return iniciar(entorno);
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

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                if(hayErrores())
                    return retorno;
                
                return case_4(entorno); 
                
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
            case 14:

                break;
            case 15:

                break;
            case 16:

                break;
            case 17:
                
                break;
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
                
                if(hayErrores())
                    return retorno;
                
                return case_23(entorno);
                
                
        }

        return new itemValor(simbolo);
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

        return retorno;
    }

    
    /**
     * <br> +----------------
     * <br> | Operación de la suma
     * <br> +----------------
     * <br> | Producción para reconocer los booleanos
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
     *
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
