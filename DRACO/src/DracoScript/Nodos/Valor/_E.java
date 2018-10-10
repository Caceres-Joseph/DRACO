/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Valor;

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
    E              ::= sMenos  E

               //Aritemeticas

                | E  sPot  E
                | E  sDiv  E
                | E  sPor  E
                | E  sMas  E
                | E  sMenos  E
                | E  sModulo  E

                //Relacional

                | E  sIgualacion  E
                | E  sDiferenciacion  E
                | E  sMenor  E
                | E  sMenorIgual  E
                | E  sMayor  E
                | E  sMayorIgual  E


                //logicos

                | E  sAnd  E
                | E  sOr  E
                | sNot  E

                | sAbreParent  E  sCierraParent

                | valId  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                | valTrue
                | valFalse
                | valCadena 
                | valDecimal
                | valEntero
 
                ;  
 */
 
public class _E extends nodoModelo {
    
    /**
     * constructor de _E
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _E(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
}
