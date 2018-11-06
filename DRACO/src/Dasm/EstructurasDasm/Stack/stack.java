/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.EstructurasDasm.Stack;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class stack {
    elementoGlobal simbolo;
//    public ArrayList<nodoStack> listaNodoStack;
    public Map<Integer,nodoStack> listaNodoStack;
    elementoEntorno entorno;
    public stack(elementoGlobal simbolo, elementoEntorno entorno){
        this.simbolo=simbolo;
        this.entorno=entorno;
//        this.listaNodoStack=new ArrayList<>();
        this.listaNodoStack=new LinkedHashMap<>();
        //creando ptr
        ptrCrear();
    }
    
     
     
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PTR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Se crea el puntero
     * Este apunta a cero
     */
    public void ptrCrear(){
        
        listaNodoStack.put(0, new nodoStack(0.0)); 
    }
    
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | DASM
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
//    public void push(nodoStack nuevoNodo){
//        listaNodoStack.add(nuevoNodo);
//    }
//    
    
    /**
     * Inserta el nodo en una posicion especifica en el stack
     * @param valor El valor a insertar
     * @param index El indice donde se insertará el nuevo nodo
     * @param errores Sirve para saber donde marcar el error
     */
    
    public void set(double valor, int index, itemAtributo errores){
        nodoStack nuevoNodo=new nodoStack(valor);
        
        listaNodoStack.put(index, nuevoNodo);
        
    }
    
    
    public nodoStack get(int index, itemAtributo errores){
        //verificando si no es mayor 
        
    
        if(!listaNodoStack.containsKey(index)){
            simbolo.tablaErrores.insertErrorSemantic(errores,"No existe el  indice :"+String.valueOf(index)+"");
            return new nodoStack(-1);
        }
         
         
        return listaNodoStack.get(index);
    }

    
    public void println(String mensaje){
        System.out.println("[DASM][Stack]"+mensaje);
    }
    
    
    public void imprimir(){
        println("[imprimir]imprimiendo");
 
        
        for (Integer key : listaNodoStack.keySet()) {
//            System.out.println("Clave: " + key + " -> Valor: " + Heap.listaNodoStack.get(key));
            nodoStack heap = listaNodoStack.get(key);
            println(String.valueOf(key)+": "+String.valueOf(heap.valor));
        }
//        for (nodoStack listaDouble : listaNodoStack) {
//            
//            println(String.valueOf(indice)+": "+String.valueOf(listaDouble.valor));
//            indice++;
//        }
    }
}
