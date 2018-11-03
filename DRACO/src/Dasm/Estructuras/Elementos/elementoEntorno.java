/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Elementos;

import Dasm.EstructurasDasm.Heap.heap;
import Dasm.EstructurasDasm.Pilita.pilita;
import Dasm.EstructurasDasm.Stack.stack;
import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class elementoEntorno {
    
    public stack Stack;
    public pilita Pilita;
    public heap Heap;
    
    
     
    
    
    /**
     *  
     * @param simbolo Simbolo que maneja la tabla de errores
     */
    public elementoEntorno(elementoGlobal simbolo){
       
        
        this.Heap=new heap(simbolo);
        this.Stack=new stack(simbolo);
        this.Pilita=new pilita(simbolo);
    }
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | OPERACIONES CON LA LISTA DE VARIABLES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
     
    
}

