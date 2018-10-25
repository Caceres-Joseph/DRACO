/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias.For;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.AsignarValor._ASIGNAR_VAL;
import DracoScript.Nodos.AsignarValor._DECLARAR_VAR;
import DracoScript.Nodos.Inicio._LST_CUERPO; 
import DracoScript.Nodos.Valor._VALOR;
import DracoScript.Nodos.nodoModelo; 


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------

    FOR             ::= tFor sAbreParent DECLARAR_VAR sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
                |   tFor sAbreParent ASIGNAR_VAL  sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves;

 */
 
public class _FOR extends nodoModelo{
    
   
    /**
     * constructor de _FOR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

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
     * @return 
     */
        @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        validandoDebug();
        
        return execute(entorno);
    }

    public itemRetorno execute(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        if(hayErrores())
            return ret;
        switch (atributo.nivelProduccion) {

            case 0:
                return case_0(entorno);

            case 1:
                return case_1(entorno); 
            default:
                return ret;
        }
    }
    
     
    /**
     * <br> +----------------
     * <br> |  tFor sAbreParent DECLARAR_VAR sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
     * <br> +----------------
     * <br> | Sentencia FOR 
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno(); 
        
        
        if (hayErrores())  
            return ret;

        
        elementoEntorno primerEntornoFor = new elementoEntorno(entorno, "primerFor", simbolo);
        
        _DECLARAR_VAR nodoDeclararVar = (_DECLARAR_VAR) listaHijos.lstHijos.get(0);
        nodoDeclararVar.ejecutar(primerEntornoFor);

        boolean condicion = condicion(primerEntornoFor);
          
        if (hayErrores())  
            return ret;
        
        int contador = 0;
        while (condicion) {
            
            elementoEntorno entornoFor = new elementoEntorno(primerEntornoFor, "for", simbolo);
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(3);
            ret = nodoLstCuerpo.ejecutar(entornoFor);

            //validando los breaks que vengan dentro de while
            if (ret.ifBreak()) {
                return new itemRetorno();
            }

            //ejecuto la asignacion
            _ASIGNAR_VAL nodoAsignarVal = (_ASIGNAR_VAL) listaHijos.lstHijos.get(2);
            nodoAsignarVal.ejecutar(primerEntornoFor);
            
            //volviendo a evaluar la condicion
            condicion = condicion(primerEntornoFor);
            contador++;

            //validando si no se cierra el if
            if (contador > 40000) {
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El for ha excedido el límite de iteraciones, verifique si hay una sentencia que lo finalice");
                return new itemRetorno();
            }
        } 
        return ret; 
    }
    
    
    
    /**
     * <br> +----------------
     * <br> |  tFor sAbreParent ASIGNAR_VAL  sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
     * <br> +----------------
     * <br> | Sentencia IF con ELIF
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno(); 
        
        
        if (hayErrores())  
            return ret;
        
        
        elementoEntorno primerEntornoFor = new elementoEntorno(entorno, "primerFor", simbolo);
        

        _ASIGNAR_VAL nodoDeclararVar = (_ASIGNAR_VAL) listaHijos.lstHijos.get(0);
        nodoDeclararVar.ejecutar(primerEntornoFor);

        boolean condicion = condicion(primerEntornoFor);
          
        if (hayErrores())  
            return ret;
        
        int contador = 0;
        while (condicion) {
            
            elementoEntorno entornoFor = new elementoEntorno(primerEntornoFor, "for", simbolo);
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(3);
            ret = nodoLstCuerpo.ejecutar(entornoFor);

            //validando los breaks que vengan dentro de while
            if (ret.ifBreak()) {
                return new itemRetorno();
            }

            //ejecuto la asignacion
            _ASIGNAR_VAL nodoAsignarVal = (_ASIGNAR_VAL) listaHijos.lstHijos.get(2);
            nodoAsignarVal.ejecutar(primerEntornoFor);
            
            //volviendo a evaluar la condicion
            condicion = condicion(primerEntornoFor);
            contador++;

            //validando si no se cierra el if
            if (contador > 40000) {
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El for ha excedido el límite de iteraciones, verifique si hay una sentencia que lo finalice");
                return new itemRetorno();
            }
        } 
        return ret; 
    }
    
    
    
    /**
     * Validando la condición
     * @param entorno 
     * @return Retorna un booleano que indica si puede seguir ejecutando el while
     */
    public boolean condicion(elementoEntorno entorno) {
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(1);
        itemValor val = nodoVal.getValor(entorno);
        Object objCondicion = val.getParseadoBooleano(atributo);

        if (objCondicion == null) {
            return false;
        }

        boolean condicion = (boolean) objCondicion; 
        return condicion; 
    }
    
     
    
}
