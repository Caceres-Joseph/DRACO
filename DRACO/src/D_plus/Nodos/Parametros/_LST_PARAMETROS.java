/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Parametros;

import D_plus.Estructuras.Listas.lstParametro;
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
LST_PARAMETROS      ::= LST_PARAMETROS sComa PARAMETRO
                    |   PARAMETRO
 */
public class _LST_PARAMETROS extends nodoModelo{
    
    public _LST_PARAMETROS(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    public lstParametro getListaParametros(){
         
        switch(atributo.nivelProduccion){
            case 0:
                _LST_PARAMETROS lstParam=(_LST_PARAMETROS)listaHijos.lstHijos.get(0);
                _PARAMETRO param0=(_PARAMETRO)listaHijos.lstHijos.get(1);
                lstParametro ret= lstParam.getListaParametros();
                ret.insertar(param0.getParametro());
                return ret;
                
            case 1:
                lstParametro retorno=new lstParametro(simbolo);
                _PARAMETRO param=(_PARAMETRO)listaHijos.lstHijos.get(0);
                retorno.insertar(param.getParametro());
                return retorno;
            default:
                return new lstParametro(simbolo);
        } 
    }
    
}
