/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;

import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstEtiquetas {
    public  Map<String, Integer> hashEtiquetas=new LinkedHashMap<>();
    private elementoGlobal simbolo;
    
    public lstEtiquetas(elementoGlobal simbolo){
        this.simbolo=simbolo;
    }
    
    
    
    public void insertar(String nombreEtiqueta, int indice, itemAtributo error){
        
        if(hashEtiquetas.containsKey(nombreEtiqueta)){
            simbolo.tablaErrores.insertErrorSemantic(error, "La etiqueta:"+nombreEtiqueta +" ya se encuentra registrada en el mismo ámbito.");
            return;
        }
        
        hashEtiquetas.put(nombreEtiqueta, indice);
    }

    public void imprimir() {
        
        println("------------Imprimiendo--------");
        //llenando la tabla 
        for (String key : hashEtiquetas.keySet()) {
//            System.out.println("Clave: " + key + " -> Valor: " + Heap.listaNodoStack.get(key));
            Integer valor = hashEtiquetas.get(key);
            println(key+" : "+String.valueOf(valor));
            
        }
    }
    
    
    public void println(String mensaje){
        System.out.println("[lstEtiquetas]"+mensaje);
    }
    
     
}
