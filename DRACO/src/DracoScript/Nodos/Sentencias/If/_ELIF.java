/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias.If;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
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
ELIF            ::= tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves ELIF
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves IF_NOT;
 */
 
public class _ELIF extends nodoModelo {
    
   
    /**
     * constructor de _ELIF
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ELIF(itemAtributo atrib, elementoGlobal simbolo) {
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
        return execute(entorno); 
    }
    
        public itemRetorno execute(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        switch (atributo.nivelProduccion) {

            case 0:
                return case_0(entorno);

            case 1:
                return case_1(entorno); 
            case 2:
                return case_2(entorno);
            default:
                return ret;
        }
    }
    
    
    
    
    /**
     * <br> +----------------
     * <br> |  tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves 
     * <br> +----------------
     * <br> | Sentencia ELIF 
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        Object objCondicion = val.getParseadoBooleano(atributo);

        if (objCondicion == null) {
            return ret;
        }

        boolean condicion = (boolean) objCondicion;
        elementoEntorno entornoIf = new elementoEntorno(entorno, "if", simbolo);
        if (condicion) { 
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(1);
            return nodoLstCuerpo.ejecutar(entornoIf);
        } else {
            
            return ret;
        }
    }
    
    
    
    /**
     * <br> +----------------
     * <br> |  tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves ELIF
     * <br> +----------------
     * <br> | Sentencia ELIF con ELIF
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        Object objCondicion = val.getParseadoBooleano(atributo);

        if (objCondicion == null)  
            return ret; 

        boolean condicion = (boolean) objCondicion;
        elementoEntorno entornoIf = new elementoEntorno(entorno, "elif", simbolo);
        if (condicion) {
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(1);
            return nodoLstCuerpo.ejecutar(entornoIf);
        } else {
            _ELIF nodoElif = (_ELIF) listaHijos.lstHijos.get(2);
            return nodoElif.ejecutar(entornoIf);
        }
    }
    
    
    /**
     * <br> +----------------
     * <br> |  tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves IF_NOT
     * <br> +----------------
     * <br> | Sentencia ELIF con IF_NOT
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemRetorno case_2(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        Object objCondicion = val.getParseadoBooleano(atributo);

        if (objCondicion == null)  
            return ret; 

        boolean condicion = (boolean) objCondicion;
        elementoEntorno entornoIf = new elementoEntorno(entorno, "elif", simbolo);
        if (condicion) {
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(1);
            return nodoLstCuerpo.ejecutar(entornoIf);
        } else {
            _IF_NOT nodoIfNot = (_IF_NOT) listaHijos.lstHijos.get(2);
            return nodoIfNot.ejecutar(entornoIf);
        }
    }
     
     
}
