/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;

import Gui.Listas.lstPuntosDeInterrupcion;

/**
 *
 * @author joseph
 */
public class elementoDebug {
    public Thread hiloEjecucion;
    elementoGlobal simbolo;
    public boolean siguienteInstruccion=false;  
    
    
    public lstPuntosDeInterrupcion puntosDeInterrupcion;
    
    /**
     * Constructor del debug
     * @param tipoArchivo Soporta el de draco script, d++ y dasm
     * @param simbolo Se encuentra el metodo global que se va pasando en todos los metodos
     * @param cadenaEntrada La cadena que se va analizar
     * @param nombreArchivo Es el nombre del archivo que se va analizar
     */
    public elementoDebug(String tipoArchivo, elementoGlobal simbolo, String cadenaEntrada, String nombreArchivo){
        this.simbolo=simbolo;
        elementoRunnable run=new elementoRunnable(tipoArchivo, simbolo, cadenaEntrada, nombreArchivo);
        hiloEjecucion=new Thread(run);
        puntosDeInterrupcion=new lstPuntosDeInterrupcion();
        
        siguienteInstruccion=false;
    }
    
    
    /**
     * Es la ejecución normal, ignorando los puntos de quiebre
     */
    public void ejecutar(){ 
        if(!esNuloHilo()){ 
            hiloEjecucion.start();
        } 
    }
    
    
    /**<br>+----------------------------------------------------
     * <br>| INICIO DE TODA LA EJECUCION
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    public void iniciar(){ 
        if(!esNuloHilo()){
//            println("[iniciar]Iniciando el hilo de ejecución");
            hiloEjecucion.start();
        }
    }
    
    
    /**<br>+----------------------------------------------------
     * <br>| MODOS DE EJECUCION
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    
    /**
     * Inicia el análisis pero en modo debug, que irá marcando los puntos de interrupcion
     */
    
     
    
    
    
    /**<br>+----------------------------------------------------
     * <br>| PARA MOVERSE DENTRO DEL DEBUG
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    
    public void siguienteInstruccion(){
        this.siguienteInstruccion=true;
        if(!esNuloHilo()){
//            println("[siguienteLinea]");
            hiloEjecucion.resume();
        }
    }
    
    public void continuar(){
        this.siguienteInstruccion=false;
        if(!esNuloHilo()){
//            println("[siguienteLinea]");
            hiloEjecucion.resume();
        } 
    }
    
    
    
    /**<br>+----------------------------------------------------
     * <br>| OPERACIONES DEL DEBUG
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    
    
    public void pausar(){
        if(!esNuloHilo()){
//            println("[pausar]");
            hiloEjecucion.suspend();
        }
    }
    
    public void detener() {
        try {
            if (!esNuloHilo()) {
//            println("[detener]");
                simbolo.listaTabsClases.despintarLineas();
                println("[run]\n\t*********  Fin del analisis **********");
                hiloEjecucion.stop();
                hiloEjecucion.destroy();
            }
        } catch (Exception e) {
            println("[detener][ERROR]" + e.getMessage());
        }
    }
    
    public boolean estaActivo(){
        
        if(!esNuloHilo()){
//            println("[estaActivo]"); 
            if(hiloEjecucion.isAlive()){
                return true;
            }else{
                return false;
            }
             
        }else{
            return false;
        }
    }
    
    
    
    public boolean esNuloHilo(){
        if(hiloEjecucion==null){ 
            println("[esNuloHilo]Hilo Nulo");
            return true;
        }else{
            return false;
        }
    }
    
    
    public void println(String mensaje){
        System.out.println("[elementoDebug]"+mensaje);
    }
    
}
