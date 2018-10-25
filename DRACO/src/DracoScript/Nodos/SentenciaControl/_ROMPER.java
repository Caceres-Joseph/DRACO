/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.SentenciaControl;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno; 
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
    ROMPER          ::=tSmash sPuntoComa;
 */
 
public class _ROMPER extends nodoModelo{
    
    /**
     * constructor de _ROMPER
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ROMPER(itemAtributo atrib, elementoGlobal simbolo) {
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
        
        
        ret.setBreak();
        return ret; 
    } 
}
