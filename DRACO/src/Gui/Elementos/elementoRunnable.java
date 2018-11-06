/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;

import D_plus.Estructuras.Elementos.elementoClase;
import D_plus.Gramatica.Analizador.anlzDplusPlus;
import Dasm.Gramatica.Analizador.anlzDasm;
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
                    if(dPlus.raiz.hayErrores()){
                        simbolo.setConsola("No se puede iniciar la traducción debido a que se econtraron errores");
                    }else{
                        simbolo.clase=clase;
                        D_plus.Estructuras.Elementos.elementoEntorno entornoGlobal2 = new D_plus.Estructuras.Elementos.elementoEntorno(null, "global", simbolo,0);
                        clase.traducir(entornoGlobal2);
                    }
//                    clase.imprimir();
                }else{
                    println("raiz vacía");
                } 
                break;
            case "dasm":
                println("[run][DASM]Iniciando Hilo de Ejecución");
                anlzDasm dDasm = new anlzDasm(cadenaEntrada, nombreArchivo, simbolo);
                dDasm.analizar();
                   if(dDasm.raiz!=null){
                       //primer pasada
//                       Dasm.Estructuras.Elementos.elementoClase claseDasm=new Dasm.Estructuras.Elementos.elementoClase(simbolo);
//                       dDasm.raiz.primerPasada(claseDasm); 
                       
                       //ejecución
                       Dasm.Estructuras.Elementos.elementoEntorno entornoDasm = new Dasm.Estructuras.Elementos.elementoEntorno(simbolo, dDasm.raiz.listaHijosHash.listaMetodoFuncion,dDasm.raiz.listaHijosHash.listaEtiquetas);
                       //coloco el puntero de codigo en el inicio
                       entornoDasm.punteroCodigo=0;
                       //lo paso al global para poder mostrarlo en tablas
                       simbolo.entornoDasm=entornoDasm;
//                       
                       dDasm.raiz.ejecutar(entornoDasm);
//                       
                       
                   }else{
                       println("[DASM]Raiz nula");
                   }
                break; 
            default:
                break;
        }
        
        simbolo.debug.detener();
        
//        simbolo.debug=null;
    }

      
    public void println(String mensaje) {
        System.out.println("[DASM][elementoRunnable]" + mensaje);
    }

}
