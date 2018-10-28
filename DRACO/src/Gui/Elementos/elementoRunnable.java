/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;

import D_plus.Estructuras.Elementos.elementoClase;
import D_plus.Gramatica.Analizador.anlzDplusPlus;
import DracoScript.Estructuras.Elementos.elementoEntorno;
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
//        this.extension="d++";
        switch (extension) {
            case "djs":
                println("[run]Iniciando Hilo de Ejecución");
                //            println("[run]\n\t*********  Iniciando analisis ********"); 
                anlzDracoScript dra = new anlzDracoScript(cadenaEntrada, nombreArchivo, simbolo);
                dra.analizar();
                raiz = dra.raiz;
                elementoEntorno entornoGlobal = new elementoEntorno(null, "global", simbolo);
                if(raiz!=null){
                    raiz.ejecutar(entornoGlobal);
                }   
                break;
            case "dpp":
                println("[run][Dpp]Iniciando Hilo de Ejecución");
                anlzDplusPlus dPlus = new anlzDplusPlus(cadenaEntrada, nombreArchivo, simbolo);
                dPlus.analizar();
                 
                elementoClase clase=new elementoClase(simbolo);
                
                if(dPlus.raiz!=null){
                    dPlus.raiz.primerPasada(clase);
//                    clase.imprimir();
                }else{
                    println("raiz vacía");
                }
                
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
