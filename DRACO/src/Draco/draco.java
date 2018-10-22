/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draco;

import GUI.Principal;

/**
 *
 * @author joseph
 */
public class draco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
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
    
}
