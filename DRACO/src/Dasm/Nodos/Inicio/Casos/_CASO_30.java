/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.Inicio._E;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_30 extends nodoModelo{
    
    public _CASO_30(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tTee_local  E
     * <br> +---------------- 
     * <br> | Sirve para set_local num
     * <br> | Pull en pilita y push en stack
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
        
        //extraer  de pilita sin hacer pop
        Double valor = entorno.Pilita.pull(atributo);
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_30][tTee_local  E]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Stack.set(valor, index.intValue(), atributo);  
        
    }
}
