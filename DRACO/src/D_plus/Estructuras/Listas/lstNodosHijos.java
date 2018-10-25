/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Nodos.nodoModelo;
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
}
