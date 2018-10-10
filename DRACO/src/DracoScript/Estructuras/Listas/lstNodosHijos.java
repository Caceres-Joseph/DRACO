/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Listas;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Nodos.nodoModelo;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class lstNodosHijos {

    public ArrayList<nodoModelo> lstHijos = new ArrayList<>();

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
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * 
     * @param entorno 
     * @return El retorno 
     */
    public itemRetorno ejecutar(elementoEntorno entorno){
        itemRetorno retorno =new itemRetorno();
        retorno.setNormal();
        
        for (nodoModelo lstHijo : lstHijos) {
            lstHijo.ejecutar(entorno);
        }
        
        return retorno;
    }
}
