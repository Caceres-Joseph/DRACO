/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.EstructurasDasm.Stack;

import Gui.Elementos.elementoGlobal;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class stack {
    elementoGlobal simbolo;
    public ArrayList<nodoStack> listaNodoStack;
    
    public stack(elementoGlobal simbolo){
        this.simbolo=simbolo;
        this.listaNodoStack=new ArrayList<>();
        
        //creando ptr
        ptrCrear();
    }
    
    
    /**
     * Inserta un nuevo nodo a stack
     * @param nuevoNodo 
     */
    public void insertar(nodoStack nuevoNodo){
        listaNodoStack.add(nuevoNodo);
    }
     
     
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PTR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    public void ptrCrear(){
        nodoStack nuevoNodo=new nodoStack(0, 0);
        insertar(nuevoNodo);
    }
    
    
}
