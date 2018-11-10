/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Sentencia.Si;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.CuerpoRelativo._LST_CUERPO;
import D_plus.Nodos.Valor._VALOR;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  
import java.util.Random;

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
SINO_SI ::= tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO_SI
        |   tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO
        ;
 */
public class _SINO_SI extends nodoModelo{
    
    public _SINO_SI(itemAtributo atrib, elementoGlobal simbolo) {
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
     * @param entorno Es la tabla que contiene las variables
     * @return El retorno es cuando viene un break
     */
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno){ 
        validandoDebug();
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        
        return casos(entorno);
    }
    
    public itemRetorno casos(elementoEntorno entorno) { 
        itemRetorno retorno=new itemRetorno();
          
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno);
            case 2:
                return case_2(entorno);
            
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        }  
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
        
        //recuperar el valor de E
        _VALOR nodoE =(_VALOR)listaHijos.lstHijos.get(0);
        itemValor valE=nodoE.getValor(entorno);
        
        //validando si es booleano el valor que devuelve
        if(!valE.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el if tiene que ser de tipo booleano no de tipo: "+valE.tipo);
            return retorno;
        }
        
        
//        simbolo.salidaDasm.comentarioPequeño("SI", "Sentencia si", entorno.nivel);
        simbolo.salidaDasm.comentario("CONDICION IF ELSE:", entorno.nivel);
        
        for (String string : valE.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        
        Random rand = new Random();
        int indice_salto_falso=rand.nextInt(1000);
        //creando la condicion
        String etiquetaFalsa= "$e_ifelse_falso"+String.valueOf(indice_salto_falso);
        String etiquetaSalida = "$e_if_salida"+entorno.idSentencia2;
        
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalsa), "Salto para etiqueta falsa", entorno.nivel);
        //cuerpo del if
        simbolo.salidaDasm.comentario("CUERPO IF ELSE VERDADERO:", entorno.nivel);
       
        //creando el nuevo entorno
        elementoEntorno entornoIF=new elementoEntorno(entorno, "sino_si", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoIF.posRelativa=entorno.posRelativa;
        
        _LST_CUERPO nodoCuerpo=(_LST_CUERPO)listaHijos.lstHijos.get(1);
        nodoCuerpo.ejecutar(entornoIF);
        //saltando a la salida del if
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaSalida), "Salto para el fin del if_else", entornoIF.nivel);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaFalsa, "Etiqueta de salida para el valor falso", entorno.nivel);
        
        return retorno;
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO_SI
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
        
        //recuperar el valor de E
        _VALOR nodoE =(_VALOR)listaHijos.lstHijos.get(0);
        itemValor valE=nodoE.getValor(entorno);
        
        //validando si es booleano el valor que devuelve
        if(!valE.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el if tiene que ser de tipo booleano no de tipo: "+valE.tipo);
            return retorno;
        }
        
        
//        simbolo.salidaDasm.comentarioPequeño("SI", "Sentencia si", entorno.nivel);
        simbolo.salidaDasm.comentario("CONDICION IF ELSE:", entorno.nivel);
        
        for (String string : valE.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        
        Random rand = new Random();
        int indice_salto_falso=rand.nextInt(100);
        //creando la condicion
        String etiquetaFalsa= "$e_ifelse_falso"+String.valueOf(indice_salto_falso);
        String etiquetaSalida = "$e_if_salida"+entorno.idSentencia2;
        
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalsa), "Salto para etiqueta falsa", entorno.nivel);
        //cuerpo del if
        simbolo.salidaDasm.comentario("CUERPO IF ELSE VERDADERO:", entorno.nivel);
       
        //creando el nuevo entorno
        elementoEntorno entornoIF=new elementoEntorno(entorno, "sino_si", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoIF.posRelativa=entorno.posRelativa;
        
        _LST_CUERPO nodoCuerpo=(_LST_CUERPO)listaHijos.lstHijos.get(1);
        nodoCuerpo.ejecutar(entornoIF);
        //saltando a la salida del if
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaSalida), "Salto para el fin del if_else", entornoIF.nivel);
        
        //creando la etiqueta falso
        simbolo.salidaDasm.lineaComentada(etiquetaFalsa, "Etiqueta de salida para el valor falso", entorno.nivel);
         
        
        /*EJECUTANDO EL SINO*/
        _SINO_SI nodoSino=(_SINO_SI)listaHijos.lstHijos.get(2);
        nodoSino.ejecutar(entorno);
         
        
        return retorno; 
    } 
    
    
    /**
     * <br> +----------------
     * <br> | tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_2(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
        
        //recuperar el valor de E
        _VALOR nodoE =(_VALOR)listaHijos.lstHijos.get(0);
        itemValor valE=nodoE.getValor(entorno);
        
        //validando si es booleano el valor que devuelve
        if(!valE.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el if tiene que ser de tipo booleano no de tipo: "+valE.tipo);
            return retorno;
        }
        
        
//        simbolo.salidaDasm.comentarioPequeño("SI", "Sentencia si", entorno.nivel);
        simbolo.salidaDasm.comentario("CONDICION IF ELSE:", entorno.nivel);
        
        for (String string : valE.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        
        Random rand = new Random();
        int indice_salto_falso=rand.nextInt(100);
        //creando la condicion
        String etiquetaFalsa= "$e_ifelse_falso"+String.valueOf(indice_salto_falso);
        String etiquetaSalida = "$e_if_salida"+entorno.idSentencia2;
        
        
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalsa), "Salto para etiqueta falsa", entorno.nivel);
        //cuerpo del if
        simbolo.salidaDasm.comentario("CUERPO IF ELSE VERDADERO:", entorno.nivel);
       
        //creando el nuevo entorno
        elementoEntorno entornoIF=new elementoEntorno(entorno, "sino_si", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoIF.posRelativa=entorno.posRelativa;
        
        _LST_CUERPO nodoCuerpo=(_LST_CUERPO)listaHijos.lstHijos.get(1);
        nodoCuerpo.ejecutar(entornoIF);
        //saltando a la salida del if
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaSalida), "Salto para el fin del if_else", entornoIF.nivel);
        
        //creando la etiqueta falso
        simbolo.salidaDasm.lineaComentada(etiquetaFalsa, "Etiqueta de salida para el valor falso", entorno.nivel);
         
        
        //*EJECUTANDO EL SINO*/
        _SINO nodoSino=(_SINO)listaHijos.lstHijos.get(2);
        nodoSino.ejecutar(entorno);
         
        
        return retorno; 
    }
    
}
