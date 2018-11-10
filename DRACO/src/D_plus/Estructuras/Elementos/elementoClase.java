/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Elementos;

import D_plus.Estructuras.Listas.lstEstructura;
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
    public lstEstructura listaEstructuras;
    
    public elementoGlobal simbolo;
    
    
    
    public elementoClase(elementoGlobal simbolo){
        this.simbolo=simbolo;
        this.listaPrincipal=new lstPrincipal(simbolo);
        this.listaMetodoFuncion=new lstMetodoFuncion(simbolo); 
        this.listaEstructuras=new lstEstructura(simbolo);
    }
     
    public void imprimir(){
        println("----Lista de metodos y funciones -----");
        listaMetodoFuncion.imprimir();
        println("---Lista de principal---");
        listaPrincipal.imprimir(); 
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Ejecucion de los metodos
     * @param entorno 
     */
     public void ejecutar(elementoEntorno entorno){
          ejecutarPrincipal(entorno);
          ejecutarDemasMetodos(entorno);
     }
     
     
     /**
      * Colocando el codigo del metodo principal
     * @param entorno
      */
     public void ejecutarPrincipal(elementoEntorno entorno){
         simbolo.salidaDasm.comentarioPequeño("Llamado a principal", "", entorno.nivel);
         //obtengo el puntero
         simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Cambiando de ambito", entorno.nivel);
         //tamanio del ambito
         simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa-1), "Tam de ambito", entorno.nivel);
         //sumando
         simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
         //actualizando puntero
         simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_id("0"), "actualizando puntero",entorno.nivel);
         
         if(!listaPrincipal.listaMain.lista.isEmpty()){
             simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$principal"), "Llamado main", entorno.nivel);
              
             listaPrincipal.ejecutar(entorno);
         }else{
             //no hay principal
         }
     }
     
     /**
      * ejecuta los demas metodos
     * @param entorno
      */
     public void ejecutarDemasMetodos(elementoEntorno entorno){
         listaMetodoFuncion.ejecutar(entorno);
     }
      
     /**
      * 
      * @param mensaje 
      */ 
    public void println(String mensaje){
        System.out.println("[elementoClase]"+mensaje);
    }
}
