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
    public elementoClase clase;
    
     
    
    
    /**
     *  
     * @param simbolo Simbolo que maneja la tabla de errores
     * @param clase Contiene las funcioens
     */
    public elementoEntorno(elementoGlobal simbolo, elementoClase clase){
       
        
        this.Heap=new heap(simbolo, this);
        this.Stack=new stack(simbolo, this);
        this.Pilita=new pilita(simbolo, this);
        
        this.clase=clase;
    }
      
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | OPERACIONES CON LA LISTA DE VARIABLES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
     
    
}

