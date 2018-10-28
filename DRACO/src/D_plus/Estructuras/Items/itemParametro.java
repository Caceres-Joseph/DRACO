/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Items;

import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class itemParametro {
    public itemAtributo nombre;
    public itemAtributo tipo;
    public int dimension;

    public itemParametro(itemAtributo nombre, itemAtributo tipo, int dimension) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dimension = dimension;
    }
    
    public void imprimir(){
        println("nombre: "+nombre.valor+"| tipo:"+tipo.valor+"| dimension:"+String.valueOf(dimension));
    }
    
    public void println(String mensaje){
        System.out.println("[itemParametro]"+mensaje);
    }
    
}
