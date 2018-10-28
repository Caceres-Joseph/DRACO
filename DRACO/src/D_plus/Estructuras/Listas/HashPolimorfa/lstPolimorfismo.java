/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas.HashPolimorfa;

import D_plus.Estructuras.Listas.*;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author joseph
 */
public class lstPolimorfismo  {
    ArrayList<nodoArreglo> nod=new ArrayList<>();
    
     
     public void println(String mensaje){
         System.out.println("[lstPolimorfismo]"+mensaje);
     }
     
     
     public void insertar(clavePolimorfa clave, valorPolimorfo valor){
         nodoArreglo nuevo=new nodoArreglo(clave, valor);
         nod.add(nuevo);
     }
     
     public boolean containsKey(clavePolimorfa clave2){
          
         for (nodoArreglo arreglo : nod) {
             //verificar si tiene la misma cantidad de parámetros 
             clavePolimorfa clave=arreglo.getClave(); 
             if(clave.esIgual(clave2)){
                 return true;
             }
         } 
         return false;
     }
    
     
     public void imprimir(){ 
         for (nodoArreglo arreglo : nod) {
             clavePolimorfa clave=arreglo.getClave();
             valorPolimorfo valor=arreglo.getValor();
             println("---------");
//             println("Clave:");
             clave.imprimir();
//             println("VAlor:");
             valor.imprimir();
         }
     }
     public class nodoArreglo{
         clavePolimorfa clave;
         valorPolimorfo valor;
         public nodoArreglo(clavePolimorfa clave, valorPolimorfo valor){
             this.clave=clave;
             this.valor=valor; 
         }

        public clavePolimorfa getClave() {
            return clave;
        }

        public valorPolimorfo getValor() {
            return valor;
        }
         
         
         
     } 
    
     
     

}
