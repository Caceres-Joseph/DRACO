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
import DracoScript.Nodos.Inicio._LST_CUERPO;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
    IF_NOT          ::= tIf2  sAbreLlaves  LST_CUERPO sCierraLlaves;
 */
 
public class _IF_NOT extends nodoModelo{
    
   
    /**
     * constructor de _IF_NOT
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _IF_NOT(itemAtributo atrib, elementoGlobal simbolo) {
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
     * tIf2  sAbreLlaves  LST_CUERPO sCierraLlaves;
     * @param entorno Es la tabla que contiene las variables
     * @return 
     */
       @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) {
            return ret;
        } 
        
        
        elementoEntorno entornoIf = new elementoEntorno(entorno, "if_not", simbolo);
        _LST_CUERPO nodoLstCuerpo = (_LST_CUERPO) listaHijos.lstHijos.get(0);
        return nodoLstCuerpo.ejecutar(entornoIf); 
    }
    
}
