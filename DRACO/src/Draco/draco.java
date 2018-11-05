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
//        int_hexa();
    }
    
    public static void int_hexa() {
        int hex = 3869451;
        String al = Integer.toHexString(hex);

        int diferencia = 6 - al.length();

        String cadena = "";
        if (diferencia != 0) {
            for (int i = 0; i < diferencia; i++) {
                cadena += "0";
            }
        }
        System.out.println("#" + cadena + al.toUpperCase());
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
