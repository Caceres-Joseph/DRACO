/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionMetodo;
import D_plus.Estructuras.Items.itemAtributo;
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
METODO              ::= TIPO VAR_ARREGLO sAbreParent LST_PARAMETROS sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    |   TIPO VAR_ARREGLO sAbreParent  sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    ;
 */
public class _METODO extends nodoModelo{
    
    public _METODO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
