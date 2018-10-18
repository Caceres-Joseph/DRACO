 
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.Valor._VALOR;
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
 * |ASGIN_VAR       ::=valId sIgual VALOR;
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
            
            
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        
        entorno.setValVariable(listaAtributos.getAtributo(0), val);
        
        return ret;
    }
    
     
    /**
     * Se va guardar una nueva variable con un valor de inicio
     * @param entorno 
     */
    void ejecutarDeclarar(elementoEntorno entorno) {
        
        if (hayErrores())
            return;
        
        
        _VALOR nodoVal = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor val = nodoVal.getValor(entorno);
        entorno.lstVariables.insertarVariable(listaAtributos.getAtributo(0), val);
    }
}
