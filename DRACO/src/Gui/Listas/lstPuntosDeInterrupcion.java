/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Listas;

import Gui.Items.itemAtributo;
import Gui.Nodos.nodoPuntoInterrupcion;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class lstPuntosDeInterrupcion {
    
    public ArrayList<nodoPuntoInterrupcion> listaDePuntos=new ArrayList<>();
    
    
    public lstPuntosDeInterrupcion(){
        
    }
    
    
    /**
     * Verificando si es un punto de interrupcion
     * @param atributo Contiene el nombre del archivo, y la linea
     * @return 
     */
    
    public boolean esPuntoDeInterrupcion(itemAtributo atributo){
        String nombreArchivo= atributo.nombreArchivo;
        int linea=atributo.linea;
        
        
        for (int i = 0; i < listaDePuntos.size(); i++) {
            nodoPuntoInterrupcion listaDePunto=listaDePuntos.get(i);
            if(listaDePunto.linea==linea&&listaDePunto.nombreArchivo.equals(nombreArchivo)){
                 println("[esPuntoDeInterrupcion]Deteniendo en "+listaDePunto.nombreArchivo+": "+String.valueOf(listaDePunto.linea));
                 listaDePuntos.remove(i);
                return true;
            }
            
            
        }
//        for (nodoPuntoInterrupcion listaDePunto : listaDePuntos) {
//            if(listaDePunto.linea==linea&&listaDePunto.nombreArchivo.equals(nombreArchivo)){
//                println("[esPuntoDeInterrupcion]Deteniendo en "+listaDePunto.nombreArchivo+": "+String.valueOf(listaDePunto.linea));
//                 
//                return true;
//            }
//        }
        
        return false;
    }
    
    /**
     * Insertando un nuevo punto de interrupcion
     * @param nodo  El nuevo punto a insertar
     */
    public void insertar(nodoPuntoInterrupcion nodo){
        listaDePuntos.add(nodo);
    }
    
    /**
     * Concatendando los puntos de interrupción de otras pesatañas o archivos
     * @param nuevaLista 
     */
    public void concat(lstPuntosDeInterrupcion nuevaLista){
        listaDePuntos.addAll(nuevaLista.listaDePuntos);
        
    }
    
    /**
     * Imprimiendo la lista de puntos de interrupcion
     */
    
    public void imprimir(){
        for (nodoPuntoInterrupcion listaDePunto : listaDePuntos) {
            println(listaDePunto.nombreArchivo+": "+String.valueOf(listaDePunto.linea));
        }
    }
    
    
    public void println(String mensaje)
    {
        System.out.println("[lstPUntosDeInterrupcion]"+mensaje);
    } 
}
