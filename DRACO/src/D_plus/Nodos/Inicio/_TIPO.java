/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Inicio;

import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import DracoScript.Estructuras.Listas.lstAtributos;
import Gui.Elementos.elementoGlobal;  

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
TIPO            ::= tEntero         0
                |   tDecimal        1
                |   tCaracter       2
                |   tBooleano       3
                |   tVacio          4
                |   tCadena         5
                ;
 */
public class _TIPO extends nodoModelo{
    
    public _TIPO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    public itemAtributo getTipo(){
        
       itemAtributo retorno= listaAtributos.getAtributo(0);
       return retorno;
        
    }
    
    
    
}
