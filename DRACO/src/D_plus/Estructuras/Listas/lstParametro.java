/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Estructuras.Items.itemParametro;
import Gui.Elementos.elementoGlobal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstParametro {
    
    public Map<String, itemParametro> listaParametros ;
    public elementoGlobal simbolo;
    
    public lstParametro(elementoGlobal simbolo){
        this.simbolo=simbolo;
        listaParametros =new LinkedHashMap<>(); 
    }
     
    public void insertar(itemParametro nuevoParametro){
        
        if(listaParametros.containsKey(nuevoParametro.nombre.valor))
        //Ya existe un parametro con el mismo nombre
        {
            simbolo.tablaErrores.insertErrorSemantic(nuevoParametro.nombre, "Ya se encuentra un parámetro con el mismo nombre :"+nuevoParametro.nombre.valor);
        }else
        //Procedemos a insertar el nuevo parámetro
        {
            listaParametros.put(nuevoParametro.nombre.valor, nuevoParametro); 
        }
    }
     
    public void imprimir(){
        
        Iterator k = listaParametros.keySet().iterator();
        println("[--- Imprimiendo la lista parametros---]");
        while (k.hasNext()) {
          
          String key= (String) k.next();
          itemParametro val=(itemParametro) listaParametros.get(key);
          
          println("Param:"+key);
          val.imprimir();
        }
         System.out.println("");
        
    }
    
    public void println(String mensaje){
        System.out.println("[lstParametro]"+mensaje);
    }
    
}
