/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Gramatica.Analizador.anlzDracoScript;
import DracoScript.Nodos.nodoModelo; 

/**
 *
 * @author joseph
 */
public class elementoRunnable implements Runnable {
    elementoGlobal simbolo;
    String extension="";
    String cadenaEntrada;
    public nodoModelo raiz;
    public String nombreArchivo;
    public elementoRunnable(String tipoArchivo, elementoGlobal simbolo, String cadenaEntrada, String nombreArchivo){
        this.extension=tipoArchivo;
        this.simbolo=simbolo;
        this.cadenaEntrada=cadenaEntrada;
        this.nombreArchivo=nombreArchivo;
    }
    
    @Override
    public void run() {
        
        switch (extension) {
            case "djs":
                //            println("[run]\n\t*********  Iniciando analisis ********");
                println("[run]Iniciando Hilo de Ejecución");
                anlzDracoScript dra = new anlzDracoScript(cadenaEntrada, nombreArchivo, simbolo);
                dra.analizar();
                raiz = dra.raiz;
                elementoEntorno entornoGlobal = new elementoEntorno(null, "global", simbolo);
                if(raiz!=null){
                    raiz.ejecutar(entornoGlobal);
                }   
                break;
            case "d++":
                
                
                break;
            default:
                break;
        }
        
        simbolo.debug.detener();
        
//        simbolo.debug=null;
    }

      
    public void println(String mensaje) {
        System.out.println("[elementoRunnable]" + mensaje);
    }

}
