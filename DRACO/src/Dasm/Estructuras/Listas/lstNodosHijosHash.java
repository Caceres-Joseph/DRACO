/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;

import Dasm.Estructuras.Items.itemFuncion;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo; 
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstNodosHijosHash {

    public Map<Integer, nodoModelo> hashHijos = new HashMap<>();
    public lstEtiquetas listaEtiquetas; 
    public lstMetodoFuncion listaMetodoFuncion;  
            
    elementoGlobal simbolo;
    int numHijo=0;

    
    
    public lstNodosHijosHash(elementoGlobal simbolo) {
        this.simbolo = simbolo;
        this.listaEtiquetas=new lstEtiquetas(simbolo);
        this.listaMetodoFuncion =new lstMetodoFuncion(simbolo);
    }
    
    
    
    /**
     * Insertando las instrucciones
     * @param hijo 
     * @param linea 
     * @param columna 
     */
    public void insertar(nodoModelo hijo, int linea, int columna) {
        hijo.atributo.linea = linea + 1;
        hijo.atributo.columna = columna + 1;
        

        //valido si es instruccion
        if (hijo.atributo.nombreToken.equals("INSTRUCCION")) {
            hashHijos.put(numHijo, hijo);
            validandoEtiquetas(hijo);
            numHijo++;
        } else if (hijo.atributo.nombreToken.equals("FUNCION")) {
            //es una funcion 
            itemAtributo nombreFuncion = hijo.listaAtributos.getAtributo(0);
            itemFuncion nuevaFuncion = new itemFuncion(nombreFuncion, hijo.listaHijos.lstHijos.get(0));
            listaMetodoFuncion.insertar(nuevaFuncion);
        } else {
            println("No se reconoce el nombre del nodo:" + hijo.atributo.nombreToken);
        }

        
    }
    
    
    
    /**
     * Aquí inserto la posicion de la etiqueta
     * Sirve para luego hacer los saltos
     * @param nodoHijo 
     */
    public void validandoEtiquetas(nodoModelo nodoHijo){
        if (nodoHijo.listaAtributos.lstAtributos.size() == 2) {
                itemAtributo etiquetaDestino = nodoHijo.listaAtributos.lstAtributos.get(0);
                itemAtributo etiquetaDestino2 = nodoHijo.listaAtributos.lstAtributos.get(1);
                
                if (etiquetaDestino.nombreToken.equals("valId") && etiquetaDestino2.nombreToken.equals("salto")) {
                    listaEtiquetas.insertar(etiquetaDestino.valor, numHijo, etiquetaDestino); 
                }
            }
    }
    
    
    
    public void println(String mensaje){
        System.out.println("[lstNodosHijosHash]"+mensaje);
    }
}
