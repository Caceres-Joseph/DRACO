/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.EstructurasDasm.Stack.nodoStack;
import Dasm.Nodos.Inicio._E;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_18 extends nodoModelo {
    
    public _CASO_18(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    
    /**
     * <br> +----------------
     * <br> | tGet_global  E
     * <br> +---------------- 
     * <br> | Sirve para get_local num
     * <br> | Extrae en heap y push en pilita
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;
        validandoDebug();  
        //recuperando el numero 
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return ;
        }
        
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_18][tGet_global]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Heap.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
        
    }
}
