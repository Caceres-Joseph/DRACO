/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.EstructurasDasm.Pilita;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author joseph
 */
public class pilita {
    
    elementoGlobal simbolo;
//    public ArrayList<Double> listaDoubles;
    public Stack<Double> listaDoubles;


    //sirve para los operadores de imprimir
    public ArrayList<String> listaDeStrings;
    
    //sirve para los retorno
    public ArrayList<Double> listaDeRetornos;
    public elementoEntorno entorno;
    
    /**
     *
     * @param simbolo
     * @param entorno
     */
    public pilita(elementoGlobal simbolo, elementoEntorno entorno){
        this.simbolo=simbolo;
        this.entorno=entorno;
//        this.listaDoubles=new ArrayList<>();
        this.listaDoubles=new Stack<>();
        this.listaDeStrings=new ArrayList<>();
        this.listaDeRetornos=new ArrayList<>();
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PILA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Inserta un nuevo valor a la pilita
     * @param num  valor a insertar en la pilita
     */
    public void push(double num){
//        listaDoubles.add(num); 
        listaDoubles.push(num);
//        println("Push en pilita: "+String.valueOf(num));
    }
    
    /**
     * Hace pop de pilita
     * @param etiqu
     * @return 
     */
    public Double pop(itemAtributo etiqu){
        if(listaDoubles.isEmpty()){
            simbolo.tablaErrores.insertErrorSemantic(etiqu,"La pila de operaciones esta vacia, índice excedido");
            return -1.0;
        }
        
//        Double retorno= listaDoubles.get(listaDoubles.size()-1);
//        
//        //lo quito de la pilita
//        listaDoubles.remove(listaDoubles.size()-1);
//        listaDoubles.trimToSize();
//        println("Pop en pilita: "+String.valueOf(retorno));

        return listaDoubles.pop();
    }
    
    /**
     * Obtiene lo que está en la Cima de la pilita
     * @param etiqu Sirver para marcar los errores
     * @return  Devuelve el valor de la  cima
     */
    public Double pull(itemAtributo etiqu){
        if(listaDoubles.isEmpty()){
            simbolo.tablaErrores.insertErrorSemantic(etiqu,"La pila de operaciones esta vacia, índice excedido");
            return -1.0;
        }
        
        Double retorno= listaDoubles.get(listaDoubles.size()-1);
        
        //lo quito de la pilita
//        listaDoubles.remove(listaDoubles.size()-1);
//        listaDoubles.trimToSize();
//        println("Pull en pilita: "+String.valueOf(retorno));
        return listaDoubles.peek();
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PILA CADENA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Inserta un nuevo valor a la pilita
     * @param cadena  valor a insertar en la pilita
     */
    public void push(String cadena){
        listaDeStrings.add(cadena);  
    }
    
    /**
     * Hace pop de pilita
     * @param etiqu
     * @return 
     */
    public String popCadena(itemAtributo etiqu){
        if(listaDeStrings.isEmpty()){
            simbolo.tablaErrores.insertErrorSemantic(etiqu,"La pila de etiquetas para imprimir esta vacia, índice excedido");
            return "";
        }
        
        String retorno= listaDeStrings.get(listaDeStrings.size()-1);
        
        //lo quito de la pilita
        listaDeStrings.remove(listaDeStrings.size()-1);
        listaDeStrings.trimToSize();
        return retorno;
    }

    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PILA RETORNOS
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Inserta un nuevo valor a la pilita retorno
     * @param valor  valor a insertar en la pilita
     */
    public void pushRetorno(Double valor){ 
        listaDeRetornos.add(valor);
    }
    
    /**
     * Hace pop de pilaRetorno
     * @param etiqu
     * @return 
     */
    public Double popRetorno(itemAtributo etiqu){
        if(listaDeRetornos.isEmpty()){
            simbolo.tablaErrores.insertErrorSemantic(etiqu,"La pila de retornos esta vacia, índice excedido");
            return -1.0;
        }
        
        Double retorno= listaDeRetornos.get(listaDeRetornos.size()-1);
        
        //lo quito de la pilita
        listaDeRetornos.remove(listaDeRetornos.size()-1);
        listaDeRetornos.trimToSize(); 
        return retorno;
    }

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | FUNCIONES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    
    
    public void println(String mensaje){
        System.out.println("[DASM][pilita]"+mensaje);
    }
    
    
    public void imprimir(){
        println("[imprimir]imprimiendo");
        for (Double listaDouble : listaDoubles) {
            println(listaDouble.toString());
        }
    }
    
}
