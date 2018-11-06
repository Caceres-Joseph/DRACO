/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_23 extends nodoModelo {
    
    public _CASO_23(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tSet_global valId
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;  
        validandoDebug();
        
        itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
              set_global_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
              set_local_ret(entorno);
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
            
        }
        
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | set_global $calc
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe 
     */
    public void set_global_calc(elementoEntorno entorno){ 
        if(hayErrores())
            return ;
          
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        Double index = entorno.Pilita.pop(atributo);

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[set_global_calc]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Heap.set(valor, index.intValue(), atributo); 
        
    }
    
    /**
     * <br> +----------------
     * <br> | set_local $ret
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe 
     */
    public void set_local_ret(elementoEntorno entorno) {   
      
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo); 
        //insertar en pila retorno
        entorno.Pilita.pushRetorno(valor);
         
    }
     
}
