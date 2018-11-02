/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas.HashPolimorfa;

import java.util.ArrayList; 

/**
 *
 * @author joseph
 */
public class lstPolimorfismo  {
    public ArrayList<nodoArreglo> lista=new ArrayList<>();
    
     
     public void println(String mensaje){
         System.out.println("[lstPolimorfismo]"+mensaje);
     }
     
     
     public void insertar(clavePolimorfa clave, valorPolimorfo valor){
         nodoArreglo nuevo=new nodoArreglo(clave, valor);
         lista.add(nuevo);
     }
     
     public boolean containsKey(clavePolimorfa clave2){
          
         for (nodoArreglo arreglo : lista) {
             //verificar si tiene la misma cantidad de parámetros 
             clavePolimorfa clave=arreglo.getClave(); 
             if(clave.esIgual(clave2)){
                 return true;
             }
         } 
         return false;
     }
    
     
     public void imprimir(){ 
         for (nodoArreglo arreglo : lista) {
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
