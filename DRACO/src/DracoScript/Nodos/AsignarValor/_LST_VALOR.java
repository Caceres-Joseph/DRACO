/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo; 
import DracoScript.Estructuras.Items.itemValor;  
import DracoScript.Nodos.Valor._VALOR;
import DracoScript.Nodos.nodoModelo;
import java.util.ArrayList;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    LST_VALOR       ::= LST_VALOR sComa VALOR
                |   VALOR;
 */
 
public class _LST_VALOR extends nodoModelo{
    
    /**
     * constructor de _LST_VALOR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */ 
    public _LST_VALOR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR UNA LISTA DE VALRORES
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */

    public ArrayList<itemValor> getLstValores(elementoEntorno entorno) { 
        ArrayList<itemValor> retorno=new ArrayList<>();
        
        if (hayErrores()) {
            return retorno;
        }
        
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
                
                
            case 1:
                retorno.add(case_1(entorno));
                return retorno;
            default:
                println("[getValores]Switch_Default->No se reconoció el caso");
                return retorno;
        }
    }
    
    
    /**
     * <br> +----------------
     * <br> |  LST_VALOR sComa VALOR
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public ArrayList<itemValor> case_0(elementoEntorno entorno) {
        ArrayList<itemValor> ret = new ArrayList<>(); 
        
        if(hayErrores())
            return ret;
        
        _LST_VALOR nodoLstVal = (_LST_VALOR) listaHijos.lstHijos.get(0);
        ArrayList<itemValor> lstVal = nodoLstVal.getLstValores(entorno);
        
        
        
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(1);
        itemValor val = nodoVal.getValor(entorno);
        
        lstVal.add(val);
        
        return lstVal;
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | VALOR
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return  Retoro para verificar break's
     */
    public itemValor case_1(elementoEntorno entorno) {
        itemValor ret = new itemValor(simbolo); 
        
        if(hayErrores())
            return ret;
        
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        return val;
        
    }
     
}
