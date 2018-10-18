/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;

import DracoScript.Estructuras.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class elementoHilo extends Thread{
    
    elementoGlobal simbolo;
    int tabEjecutando= -1;
    
    
    public elementoHilo(elementoGlobal simbolo){
        this.simbolo=simbolo;
    }
    
    @Override
    public void run(){
        simbolo.listaTabsClases.ejecutarNodo(tabEjecutando); 
    }
    
    
    public void ejecutar(int i){
        this.tabEjecutando=i;
        this.start();
    }
}
