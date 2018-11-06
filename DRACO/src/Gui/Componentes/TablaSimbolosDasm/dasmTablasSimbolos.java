/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes.TablaSimbolosDasm;

import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class dasmTablasSimbolos {
    
    public dasmTablaStack tablaSimbolosDasmStack;
    public dasmTablaHeap tablaSimbolosDasmHeap;
    public dasmTablaStackAux tablaSimbolosDasmPilita;
//    public elementoGlobal simbolo;
    public dasmTablasSimbolos(dasmTablaStack tablaSimbolosDasmStack, dasmTablaHeap tablaSimbolosDasmHeap, dasmTablaStackAux tablaSimbolosDasmPilita) {
        this.tablaSimbolosDasmStack = tablaSimbolosDasmStack;
        this.tablaSimbolosDasmHeap = tablaSimbolosDasmHeap;
        this.tablaSimbolosDasmPilita = tablaSimbolosDasmPilita;
//        this.simbolo=simbolo;
    }
    
    public void mostrar(elementoGlobal simbolo) {
        if (simbolo.entornoDasm == null) {
            return;
        }
        try {
            tablaSimbolosDasmStack.mostrar(simbolo.entornoDasm.Stack);
            tablaSimbolosDasmHeap.mostrar(simbolo.entornoDasm.Heap);
            tablaSimbolosDasmPilita.mostrar(simbolo.entornoDasm.Pilita);

        } catch (Exception e) {
            println("[Mostrar][Error]"+e.getMessage());
        }
    }
    
    
    public void println(String mensaje){
        System.out.println("[DASM][dasmTrablasSimbolos]"+mensaje);
    }
   
}
