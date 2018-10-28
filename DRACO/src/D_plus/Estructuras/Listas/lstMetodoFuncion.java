/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.lstPolimorfismo;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import Gui.Elementos.elementoGlobal;
import java.util.Iterator; 

/**
 *
 * @author joseph
 */


public class lstMetodoFuncion {
    public lstPolimorfismo listaMetodoFuncion = new lstPolimorfismo();
    elementoGlobal simbolo;

    
    public lstMetodoFuncion(elementoGlobal simbolo){
        this.simbolo=simbolo;
        
//        
//        map.put("Adobe", "Mountain View, CA");
//        Iterator k = map.keySet().iterator();
//        while (k.hasNext()) {
//          String key = (String) k.next();
//          System.out.println("Key " + key + "; Value " + (String) map.get(key));
//        }
        
    }

    public void imprimir() {
        
       
        println("[--- Imprimiendo la lista polimorfa---");
        listaMetodoFuncion.imprimir();
    }
    
    
    public void println(String mensaje){
        System.out.println("[lstMetodoFuncion]"+mensaje);
    }
    
    
}
