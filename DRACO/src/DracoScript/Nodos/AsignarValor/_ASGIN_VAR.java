 
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * |
 * |
 * |MENSAJE.Rule = tMensaje + sAbreParent + E + sCierraParent
 * |             | tMensaje + sAbreParent + sCierraParent;
 * |
 */
 
public class _ASGIN_VAR extends nodoModelo
    
{
     
    /**
     * constructor de _ASGIN_VAR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ASGIN_VAR(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
     
}
