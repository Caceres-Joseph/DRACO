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

/**
 *
 * @author joseph
 */
public class stack {
    elementoGlobal simbolo;
    public ArrayList<nodoStack> listaNodoStack;
    elementoEntorno entorno;
    public stack(elementoGlobal simbolo, elementoEntorno entorno){
        this.simbolo=simbolo;
        this.entorno=entorno;
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
    
    /**
     * Se crea el puntero
     * Este apunta a cero
     */
    public void ptrCrear(){
        nodoStack nuevoNodo=new nodoStack(0);
        insertar(nuevoNodo);
    }
    
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | DASM
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    public void push(nodoStack nuevoNodo){
        listaNodoStack.add(nuevoNodo);
    }
    
    
    /**
     * Inserta el nodo en una posicion especifica en el stack
     * @param valor El valor a insertar
     * @param index El indice donde se insertará el nuevo nodo
     * @param errores Sirve para saber donde marcar el error
     */
    
    public void set(double valor, int index, itemAtributo errores){
        nodoStack nuevoNodo=new nodoStack(valor);
        
        //verificando si no es mayor
        if (index < 0) {
            simbolo.tablaErrores.insertErrorSemantic(errores,"El indice para guardar en stack no tiene que ser negativo, valor recibido:"+String.valueOf(index));
            return 
                    ;
        }
        
        if (index >= listaNodoStack.size()) {   
            int i = index-(listaNodoStack.size()-1);
            //insertando nuevos nodos
            for (int j = 0; j < i; j++) {
                nodoStack nuevoNodo2=new nodoStack(-1.0);
                listaNodoStack.add(nuevoNodo2);
            }
        }
        
        //insertando el nuevo nodo
        listaNodoStack.set(index, nuevoNodo);
    }
    
    
    public nodoStack get(int index, itemAtributo errores){
        //verificando si no es mayor 
        
        if (index < 0) {
            simbolo.tablaErrores.insertErrorSemantic(errores,"El indice para guardar en stack no tiene que ser negativo, valor recibido:"+String.valueOf(index));
            return new nodoStack(-1);
        }
        
        if (index >= listaNodoStack.size()) { 
            simbolo.tablaErrores.insertErrorSemantic(errores,"El indice excedido , el indice :"+String.valueOf(index)+"no existe");
            return new nodoStack(-1);
        }
        
        return listaNodoStack.get(index);
    }

    
    public void println(String mensaje){
        System.out.println("[DASM][Stack]"+mensaje);
    }
    
    
    public void imprimir(){
        println("[imprimir]imprimiendo");
        int indice=0;
        for (nodoStack listaDouble : listaNodoStack) {
            
            println(String.valueOf(indice)+": "+String.valueOf(listaDouble.valor));
            indice++;
        }
    }
}
