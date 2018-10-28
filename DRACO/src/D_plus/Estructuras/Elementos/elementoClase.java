/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Elementos;

import D_plus.Estructuras.Listas.lstMetodoFuncion;
import D_plus.Estructuras.Listas.lstPrincipal;
import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class elementoClase {
    
    public lstMetodoFuncion listaMetodoFuncion;
    public lstPrincipal listaPrincipal;
    public elementoGlobal simbolo;
    
    
    public elementoClase(elementoGlobal simbolo){
        this.simbolo=simbolo;
        this.listaPrincipal=new lstPrincipal(simbolo);
        this.listaMetodoFuncion=new lstMetodoFuncion(simbolo); 
    }
     
    public void imprimir(){
        println("----Lista de metodos y funciones -----");
        listaMetodoFuncion.imprimir();
        println("---Lista de principal---");
        listaPrincipal.imprimir(); 
    }
    
    
    public void println(String mensaje){
        System.out.println("[elementoClase]"+mensaje);
    }
}
