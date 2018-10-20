/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Sentencias.While;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
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

    WHILE           ::=tWhile sAbreParent VALOR sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves;
 */
 
public class _WHILE extends nodoModelo{
    
  
    /**
     * constructor de _WHILE
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _WHILE(itemAtributo atrib, elementoGlobal simbolo) {
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
     * tWhile sAbreParent VALOR sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
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
        boolean condicion = condicion(entorno);
        
        if (hayErrores())  
            return ret;

        

        int contador = 0;
        while (condicion) {
            elementoEntorno entornoWhile = new elementoEntorno(entorno, "while", simbolo);
            _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(1);
            ret = nodoLstCuerpo.ejecutar(entornoWhile);

            //validando los breaks que vengan dentro de while
            if (ret.ifBreak()) {
                return new itemRetorno();
            }

            //volviendo a evaluar la condicion
            condicion = condicion(entorno);
            contador++;

            //validando si no se cierra el if
            if (contador > 40000) {
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El while ha excedido el límite de iteraciones, verifique si hay una sentencia que lo finalice");
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
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        Object objCondicion = val.getParseadoBooleano(atributo);

        if (objCondicion == null) {
            return false;
        }

        boolean condicion = (boolean) objCondicion;

        return condicion;

    }
     
    
}
