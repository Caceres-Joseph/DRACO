/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Valor;

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
E                       ::=sMenos  E
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

                        | ID_VAR_FUNC  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                        | valFalse
                        | valTrue
                        | valCadena
                        | valChar
                        | valDecimal
                        | valEntero
                        | tNulo  
                        ;
        
 */
public class _E extends nodoModelo{
    
    public _E(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
