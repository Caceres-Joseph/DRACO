/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos;
    
import Dasm.Estructuras.Elementos.elementoClase;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Gui.Items.itemAtributo; 
import Gui.Elementos.elementoGlobal;

import Dasm.Estructuras.Listas.*;
 
public class nodoModelo {
    
    public elementoGlobal simbolo;
    public String nombreNodo = "";
    public lstAtributos listaAtributos;
    public lstNodosHijos listaHijos;
    public itemAtributo atributo;
    
    
    //para controlar los saltos
    public nodoModelo nodoPadre;
    
    
    /**
     * constructor de _ASGIN_VAR 
     * @param atrib Atributo que contiene el nombre y la linea del nodo
     * @param simbolo Es el simbolo global
     */
    
    public nodoModelo(itemAtributo atrib, elementoGlobal simbolo){
        this.atributo = atrib;
        this.simbolo=simbolo;
        this.listaAtributos =new lstAtributos();
        this.listaHijos =new lstNodosHijos(simbolo); 
    }
    
     
    
     
    /**
     * @param mensaje Imprime el mensaje con el nombre de la clase para ubicarlo de forma fácil
     */
    public void println(String mensaje){
        System.out.println("[DASM]["+atributo.nombreToken+"]"+mensaje);
    }
    
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PRIMER PASADA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Metodo para la primer pasada
     * @param clase Es la tabla que contiene las variables  
     */
    public void primerPasada(elementoClase clase) {
//        validandoDebug();

        if (hayErrores()) {
            return;
        }
        listaHijos.primerPasada(clase);
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables
     * @param index Puntero de codigo
     * @return El retorno es cuando viene un break
     */
    public itemRetorno ejecutar(elementoEntorno entorno, int index){
//        validandoDebug();
       
        itemRetorno retorno=new itemRetorno();
        if(hayErrores()){
            return retorno;
        } 
        return listaHijos.ejecutar(entorno, index);
    }
    
    
    
    public void validandoDebug(){ 
        simbolo.listaTabsClases.despintarLineas();
        
        if(simbolo.modoDebug){
            if(simbolo.debug.siguienteInstruccion){
                
                    simbolo.listaTabsClases.pintarLinea(atributo.nombreArchivo, atributo.linea-1); 
                    simbolo.debug.pausar();  
            }else{
                //reviso si esta linea esta dentro del debug
                
                if(simbolo.debug.puntosDeInterrupcion.esPuntoDeInterrupcion(atributo)){
                    println("deteniendo hilo");
                    simbolo.listaTabsClases.pintarLinea(atributo.nombreArchivo, atributo.linea-1);
                    simbolo.debug.pausar();
                }
            }     
        }
    }
    
    /**
     * Para detectar si hay errores semanticos
     * @return  Retorna un boolean para indicar si hubieron errores
     */
    public boolean hayErrores(){
        if(!simbolo.tablaErrores.tablaError.isEmpty()){
            println("[HAY_ERRORES]No se puede ejecutar porque hay errores");
            return true;
        }
        return false;
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PARA LOS SALTOS
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Se almacena el padre para poder saltar a otros nodos
     * @param padre 
     */
    public void insertarPadre(nodoModelo padre){
        this.nodoPadre=padre;
    }
    
    /**
     * Tengo que recorrer los hijos dle padre en busca
     * de la etiqueta e iniciar la ejecucion desde ahi prro 
     * @param etiquetaOrigen el nombre de la etiqueta a la que se quiere saltar prro
     * @param entorno Para retomar el entorno
     */
//    public void saltar(itemAtributo etiquetaOrigen, elementoEntorno entorno) {
//
//        if (nodoPadre == null) {
//            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede realizar el salto debido a que el nodo padre es nulo");
//            return;
//        }
//        for (nodoModelo nodoHijo : nodoPadre.listaHijos.lstHijos) {
//            //hay que revisar los atributos
//            if (nodoHijo.listaAtributos.lstAtributos.size() >= 1) {
//                itemAtributo etiquetaDestino = nodoHijo.listaAtributos.lstAtributos.get(0);
//
//                if (etiquetaDestino.nombreToken.equals("valId")) {
//
//                    if (etiquetaDestino.valor.equals(etiquetaOrigen.valor)) {
//                        //aqui retomo la ejecucion
//                        nodoHijo.ejecutar(entorno);
//                        break;
//                    }
//                }
//            }
//        }
//        simbolo.tablaErrores.insertErrorSemantic(atributo, "No se encontró la etiqueta: " + etiquetaOrigen.valor);
//    }

   
    
}
