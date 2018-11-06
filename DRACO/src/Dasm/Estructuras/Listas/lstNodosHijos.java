/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;
  
import Dasm.Estructuras.Elementos.elementoEntorno; 
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class lstNodosHijos {
     public ArrayList<nodoModelo> lstHijos = new ArrayList<>();
     elementoGlobal simbolo;
    public lstNodosHijos(elementoGlobal simbolo) {
        this.simbolo=simbolo;
    }
     
     
     
     /**
     *
     * @param hijo Es el nodo que se va agregar
     * @param linea La linea donde se encuentra el nodo
     * @param columna La columna donde se encuentra el nodo
     */
    public void insertar(nodoModelo hijo, int linea, int columna) {
        hijo.atributo.linea = linea + 1;
        hijo.atributo.columna = columna + 1;
        lstHijos.add(hijo);

//        println("imprimiendo atributos");
//        hijo.atributo.imprimir();
    }
    
    
    
    /**
     * @param mensaje Imprime el mensaje con el nombre de la clase para ubicarlo
     * de forma fácil
     */
    public void println(String mensaje) {
        System.out.println("[lstNodosHijos]" + mensaje);
    }
     
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PRIMER PASADA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * 
     * @param clase  
     */
//    public void primerPasada(elementoClase clase){ 
//        
//        for (nodoModelo lstHijo : lstHijos) {
//            
//            lstHijo.primerPasada(clase);
//            
//        } 
//    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * 
     * @param entorno  
     */
    
    public void ejecutar(elementoEntorno entorno) {
        for (nodoModelo lstHijo : lstHijos) { 
            lstHijo.ejecutar(entorno); 
        }
    }
//    public void ejecutar(elementoEntorno entorno, int index){
//        itemRetorno retorno =new itemRetorno();
//        retorno.setNormal();
//        itemAtributo etiquetaOrigen = null;
//        
//        
//        
//        //para iniciar la ejecución en un punto especifico 
//        
//        if (index >= lstHijos.size()) {
//            println("[ERROR]ejecutar| El puntero codigo supera el tamaño de la pila de coido");
//            return retorno;
//        }
//        
//        for (int i = index; i < lstHijos.size(); i++) {
//            nodoModelo lstHijo= lstHijos.get(i);
//            itemRetorno ret= lstHijo.ejecutar(entorno,0);
//            if(ret.ifBreak()){
//                etiquetaOrigen=ret.etiquetaDestino;
//                break; 
//            }
//        }
//        
////        for (nodoModelo lstHijo : lstHijos) {
////            
////            itemRetorno ret= lstHijo.ejecutar(entorno);
////            if(ret.ifBreak()){
////                etiquetaOrigen=ret.etiquetaDestino;
////                break; 
////            }
////        }
//         
//        if (etiquetaOrigen == null)
//            return retorno;
//
//        
//        
//        //buscando la etiqueta
//        for (int i = 0; i < lstHijos.size(); i++) {
//            nodoModelo nodoHijo = lstHijos.get(i);
//            
//            if (nodoHijo.listaAtributos.lstAtributos.size() == 2) {
//                itemAtributo etiquetaDestino = nodoHijo.listaAtributos.lstAtributos.get(0);
//                itemAtributo etiquetaDestino2 = nodoHijo.listaAtributos.lstAtributos.get(1);
//                
//                if (etiquetaDestino.nombreToken.equals("valId") && etiquetaDestino2.nombreToken.equals("salto")) {
//                    
//                    if (etiquetaDestino.valor.equals(etiquetaOrigen.valor)) {
//                        //aqui retomo la ejecucion 
//                        nodoHijo.nodoPadre.ejecutar(entorno, i);
//                        return new itemRetorno();
//                    }
//                }
//            }            
//        }
//        
//        simbolo.tablaErrores.insertErrorSemantic(etiquetaOrigen, "No se encontró la etiqueta: "+etiquetaOrigen.valor+" para poder realizar el salto");
//        
//        return new itemRetorno();
//    }
    
    
}
