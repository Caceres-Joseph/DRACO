/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.nodoModelo;


/**
 *<br> +----------------------
 *<br> | NO TERMINAL:
 *<br> | Es donde se guardan los no terminales
 *<br> +----------------------
 *<br> VALOR          ::= E;
 * Nodo para asignar el valor 
 * @author joseph
 */
 
public class _VALOR extends nodoModelo {

    /**
     * constructor de _VALOR
     *
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la
     * columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */
    public _VALOR(itemAtributo atrib, elementoGlobal simbolo) {
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
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        return new itemRetorno();
    }

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */

    public itemValor getValor(elementoEntorno entorno) { 
        if (hayErrores()) {
            return new itemValor(simbolo);
        }

        _E nod = (_E) listaHijos.lstHijos.get(0);
        return nod.getValor(entorno);

    }

}
