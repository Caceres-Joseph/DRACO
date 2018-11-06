/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Elementos;

import Dasm.Estructuras.Listas.lstEtiquetas;
import Dasm.Estructuras.Listas.lstMetodoFuncion;
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
    public lstMetodoFuncion listaFunciones;
    
    
    
    public lstEtiquetas listaEtiquetas; 
    public int punteroCodigo=0;
    /**
     *  
     * @param simbolo Simbolo que maneja la tabla de errores 
     * @param listaFunciones 
     * @param listaEtiquetas 
     */
    public elementoEntorno(elementoGlobal simbolo,lstMetodoFuncion listaFunciones,lstEtiquetas listaEtiquetas){
       
        
        this.Heap=new heap(simbolo, this);
        this.Stack=new stack(simbolo, this);
        this.Pilita=new pilita(simbolo, this);
        this.listaFunciones=listaFunciones;
        this.listaEtiquetas=listaEtiquetas;
         
    }
      
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | OPERACIONES CON LA LISTA DE VARIABLES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
     
    
}

