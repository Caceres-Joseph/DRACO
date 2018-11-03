/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Elementos;

import Dasm.Estructuras.Listas.lstMetodoFuncion;
import Dasm.Estructuras.Listas.lstPrincipal;
import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class elementoClase {
    
    public lstMetodoFuncion listaMetodoFuncion; 
    public elementoGlobal simbolo;
    
    
    
    public elementoClase(elementoGlobal simbolo){
        this.simbolo=simbolo; 
        this.listaMetodoFuncion=new lstMetodoFuncion(simbolo); 
    }
     
    
    
    public void println(String mensaje){
        System.out.println("[DASM][elementoClase]"+mensaje);
    }
}
