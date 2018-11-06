/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.EstructurasDasm.Heap;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.EstructurasDasm.Stack.stack;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class heap extends stack { 

    public heap(elementoGlobal simbolo, elementoEntorno entorno) {
        super(simbolo, entorno);
        set(1, 0, new itemAtributo("", "", 0));
    }

    @Override
    public void println(String mensaje){
        System.out.println("[DASM][Heap]"+mensaje);
    }
    
    
    
}
