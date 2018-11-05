/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Dasm.Nodos.Inicio._E;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class tee extends set{
    
    public tee(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tTee_local  E
     * <br> +---------------- 
     * <br> | Sirve para set_local num
     * <br> | Pull en pilita y push en stack
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_30(elementoEntorno entorno) {  
        
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        //recuperando el numero 
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return retorno;
        }
        
        //extraer  de pilita sin hacer pop
        Double valor = entorno.Pilita.pull(atributo);
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_30][tTee_local  E]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Stack.set(valor, index.intValue(), atributo); 
        return retorno;     
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tTee_global  E
     * <br> +---------------- 
     * <br> | Sirve para set_local num
     * <br> | Pull en pilita y push en heap
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_31(elementoEntorno entorno) {   
        
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        //recuperando el numero 
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return retorno;
        }
        
        //extraer  de pilita sin hacer pop
        Double valor = entorno.Pilita.pull(atributo);
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_31][tTee_global  E]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Heap.set(valor, index.intValue(), atributo); 
        return retorno;   
    }
    
    
    
}
