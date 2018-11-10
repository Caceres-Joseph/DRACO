/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Sentencia.For;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.AsignarValor._ASIG_VALOR;
import D_plus.Nodos.CuerpoRelativo._LST_CUERPO;
import D_plus.Nodos.DeclararVariable._DECLARAR_VARIABLE;
import D_plus.Nodos.Sentencia.Si._SINO;
import D_plus.Nodos.Valor._VALOR;
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
FOR     ::= tPara  sAbreParent  DECLARAR_VARIABLE  sPuntoComa  VALOR  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tPara  sAbreParent  ASIG_VALOR  sPuntoComa  E  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        ;
 */
public class _FOR extends nodoModelo{
    
    public _FOR(itemAtributo atrib, elementoGlobal simbolo) {
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
            
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        }  
    }
    
    
    /**
     * <br> +----------------
     * <br> | tPara  sAbreParent  DECLARAR_VARIABLE  sPuntoComa  VALOR  sPuntoComa  ASIG_VALOR  sCierraParent  
     * <br> |       sAbreLlave  LST_CUERPO  sCierraLlave
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
         
        //recuperarando nodos
        _DECLARAR_VARIABLE nodoDeclararVar =(_DECLARAR_VARIABLE)listaHijos.lstHijos.get(0);
        _VALOR nodoValor=(_VALOR)listaHijos.lstHijos.get(1);
        _ASIG_VALOR nodoAsignar= (_ASIG_VALOR)listaHijos.lstHijos.get(2);
        _LST_CUERPO nodoCuerpo= (_LST_CUERPO)listaHijos.lstHijos.get(3);
        
        simbolo.salidaDasm.comentarioPequeño("Para", "Declarando var", entorno.nivel);
        
        /*ENTORNO*/
        //creando el nuevo entorno
        elementoEntorno entornoFor=new elementoEntorno(entorno, "for", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoFor.posRelativa=entorno.posRelativa;
        
         simbolo.salidaDasm.comentario("DECLARANDO VAR EN FOR:", entorno.nivel);
        /*DECLARANDO LA VARIABLE*/
        nodoDeclararVar.ejecutar(entornoFor);
        itemValor valValor=nodoValor.getValor(entornoFor);
        
        
        /*VALIDACION*/ 
        //validando si es booleano el valor que devuelve
        if(!valValor.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el while tiene que ser de tipo booleano no de tipo: "+valValor.tipo);
            return retorno;
        }
        
         
        /*ETIQUETAS*/
        String etiquetaCondicion = "$e_for_condicion"+entornoFor.idSentencia;
        String etiquetaFalso="$e_for_falso"+entornoFor.idSentencia;
        String etiquetaIncremento="$e_incremento_for"+entornoFor.idSentencia;
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(etiquetaCondicion, "Etiqueta condicion", entorno.nivel);
        
        for (String string : valValor.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalso), "Etiqueta para salir del for", entorno.nivel);
        
        
        /*EJECUTANDO EL CUERPO*/
        simbolo.salidaDasm.comentario("CUERPO FOR:", entorno.nivel);
        nodoCuerpo.ejecutar(entornoFor);
        
        
        /*ASIGNACION DE VARIABLE*/
        simbolo.salidaDasm.comentario("INCREMENTO FOR:", entorno.nivel);
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaIncremento, "Etiqueta incrmento para el continue", entornoFor.nivel);
         
        nodoAsignar.ejecutar(entornoFor);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaCondicion), "Evaluando nuevamente la condicion", entornoFor.nivel);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaFalso, "Etiqueta de salida para el valor falso", entorno.nivel);
          
        return retorno;
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tPara  sAbreParent  ASIG_VALOR  sPuntoComa  VALOR  sPuntoComa  ASIG_VALOR  sCierraParent  
     * <br> |       sAbreLlave  LST_CUERPO  sCierraLlave
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
         
        //recuperarando nodos
        _ASIG_VALOR nodoDeclararVar =(_ASIG_VALOR)listaHijos.lstHijos.get(0);
        _VALOR nodoValor=(_VALOR)listaHijos.lstHijos.get(1);
        _ASIG_VALOR nodoAsignar= (_ASIG_VALOR)listaHijos.lstHijos.get(2);
        _LST_CUERPO nodoCuerpo= (_LST_CUERPO)listaHijos.lstHijos.get(3);
        
        simbolo.salidaDasm.comentarioPequeño("Para", "Declarando var", entorno.nivel);
        
        /*ENTORNO*/
        //creando el nuevo entorno
        elementoEntorno entornoFor=new elementoEntorno(entorno, "for", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoFor.posRelativa=entorno.posRelativa;
        
         simbolo.salidaDasm.comentario("ASIGNANDO VALOR EN VAR FOR:", entorno.nivel);
        /*DECLARANDO LA VARIABLE*/
        nodoDeclararVar.ejecutar(entornoFor);
        itemValor valValor=nodoValor.getValor(entornoFor);
        
        
        /*VALIDACION*/ 
        //validando si es booleano el valor que devuelve
        if(!valValor.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el while tiene que ser de tipo booleano no de tipo: "+valValor.tipo);
            return retorno;
        }
        
        
        
        /*ETIQUETAS*/
        String etiquetaCondicion = "$e_for_condicion"+entornoFor.idSentencia;
        String etiquetaFalso="$e_for_falso"+entornoFor.idSentencia;
        String etiquetaIncremento="$e_incremento_for"+entornoFor.idSentencia; 
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(etiquetaCondicion, "Etiqueta condicion", entorno.nivel);
        
        for (String string : valValor.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalso), "Etiqueta para salir del for", entorno.nivel);
        
        
        /*EJECUTANDO EL CUERPO*/
        simbolo.salidaDasm.comentario("CUERPO FOR:", entorno.nivel);
        nodoCuerpo.ejecutar(entornoFor);
        
        
        /*ASIGNACION DE VARIABLE*/
        simbolo.salidaDasm.comentario("INCREMENTO FOR:", entorno.nivel);
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaIncremento, "Etiqueta incrmento para el continue", entornoFor.nivel);
        
        nodoAsignar.ejecutar(entornoFor);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaCondicion), "Evaluando nuevamente la condicion", entornoFor.nivel);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaFalso, "Etiqueta de salida para el valor falso", entorno.nivel);
          
        return retorno;
    }
    
     
    
}
