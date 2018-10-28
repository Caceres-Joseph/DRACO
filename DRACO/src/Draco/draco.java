/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draco;
 
import D_plus.Estructuras.Listas.HashPolimorfa.lstPolimorfismo;
import GUI.Principal;
import java.util.Iterator;

/**
 *
 * @author joseph
 */
public class draco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
//        pruebaHash();
        iniciarInterfaz(args);  
    }
    
    /**
     * Main que inicializa la interfaz
     * @param args 
     */ 
    public static void iniciarInterfaz(String[] args) {
        System.out.println("Inicializando...");
        Principal pri = new Principal(); 
        pri.correr(args);
    }
    
//    public static void pruebaHash(){
//        lstPolimorfismo map = new lstPolimorfismo();
//        
////        map.put("Adobe", "Mountain View, CA");  
//       
//        
//        System.out.println(map.containsKey("Adobe"));
//        
//        map.put("Adobe4", "Mountain View, CA2");
//        
//        Iterator k = map.keySet().iterator();
//        while (k.hasNext()) {
//          String key = (String) k.next();
//          System.out.println("Key " + key + "; Value " + (String) map.get(key));
//        }
//    }
    
}
