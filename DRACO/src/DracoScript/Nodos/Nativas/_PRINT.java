/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno; 
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.Valor._VALOR;
import DracoScript.Nodos.nodoModelo;
import javafx.application.Platform;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------

    PRINT           ::= tPrint sAbreParent VALOR sCierraParent
                |   tPrint sAbreParent  sCierraParent;
 */
 
public class _PRINT extends nodoModelo {
    
    /**
     * constructor de _PRINT
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _PRINT(itemAtributo atrib, elementoGlobal simbolo) {
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
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;
        validandoDebug();
        
        
        
        if (atributo.nivelProduccion == 0) {
            _VALOR nod = (_VALOR) listaHijos.lstHijos.get(0);
            itemValor tel = nod.getValor(entorno);
            Object ret = tel.getValorParseado("cadena", atributo);

            if (ret != null) {

                    simbolo.setConsola("\n" + ret);
                    //                simbolo.txtConsola+="\n"+ret;
               
            } else {
                 
                    simbolo.setConsola("\nnull");
                    //                simbolo.txtConsola+="\n"+ret;
               
                //                simbolo.txtConsola+="\nnull";
            }

        } else {

        }

        return retorno;
    }

     
    
}
