/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.EstructurasDasm.Stack.nodoStack;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_17 extends nodoModelo{
    
    public _CASO_17(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tGet_local valId
     * <br> +----------------  
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++; 
        validandoDebug(); 
        
         itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
              get_local_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
              get_local_ret(entorno); 
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
          
        }        
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | get_local $calc
     * <br> +---------------- 
     * <br> | Sirve para get_local calc
     * <br> | Extrae en stack la pos de la cima de pilita y push en pilita
     * @param entorno Es el ambito que recibe 
     */
    public void get_local_calc(elementoEntorno entorno) { 
         
        if(hayErrores())
            return ;
        
        //sacando de pilita
        Double index = entorno.Pilita.pop(atributo);
        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[get_local_calc]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Stack.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
           
    }
    
    /**
     * <br> +----------------
     * <br> | get_local $ret
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe 
     */
    
    public void get_local_ret(elementoEntorno entorno) {   
        if(hayErrores())
            return ;
         
        
        //extraer  de pilita  retorno
        Double valor=entorno.Pilita.popRetorno(atributo);
        //insertar en pilita
        entorno.Pilita.push(valor);
          
    }
}
