/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Items;

import Dasm.Nodos.Inicio._FUNCION;
import Dasm.Nodos.nodoModelo;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class itemFuncion {
    public itemAtributo nombre;
    public nodoModelo cuerpo;
    
    
    public itemFuncion(itemAtributo nombre, nodoModelo cuerpo){
        this.nombre=nombre;
        this.cuerpo=cuerpo;
        
    }
 
}
