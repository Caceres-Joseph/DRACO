/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 

INSTRUCCION         ::=    valId
                    |   tAdd
                    |   tDiff
                    |   tMult
                    |   tDiv
                    |   tMod
                    |   tPot
                    // Relacionales 
                    |   tLt
                    |   tGt
                    |   tLte
                    |   tGte
                    // Logico 
                    |   tNot
                    |   tAnd
                    |   tOr
                    // Saltos 
                    |   tBr valId
                    |   tBrIf valId

                    // Instruc 
                    |   tGet_local  E 
                    |   tGet_local valId
                    |   tGet_global  E 
                    |   tGet_global valId

                    |   tSet_local  E 
                    |   tSet_local valId
                    |   tSet_global  E 
                    |   tSet_global valId
                    // Funciones 
                    |   tCall valId

                    // EXTRAS 
                    |   tEqz
                    //Tengo duda de como funciona
                    

                     // Num  
                    |   valEntero
                    |   valDecimal

                     // PARA IMPRIMIR  

                    |   valCadena

                    | tPrint

                    //
                    ;
 */
public class _INSTRUCCION extends nodoModelo{
    
    public _INSTRUCCION(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
}
