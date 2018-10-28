/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas.HashPolimorfa;

import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.lstParametro;
import D_plus.Nodos.nodoModelo;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class valorPolimorfo {
    public itemAtributo tipo;
    public itemAtributo nombre;
    public int dimension;
    public lstParametro parametros;
    public nodoModelo cuerpo;
    
    
    
    public valorPolimorfo(lstParametro parametros ,itemAtributo tipo, itemAtributo nombre, int dimension, nodoModelo nodoCuerpo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.dimension = dimension;
        this.parametros=parametros;
        this.cuerpo=nodoCuerpo;
        
    }
    
     
    
    
    
    
    
    
   public void imprimir(){
       println("VALOR:");
       println("Nombre:"+nombre.valor+"| Dim:"+String.valueOf(dimension)+"| Tipo:"+tipo.valor);
       
   }
   
   
   public void println(String mensaje){
       System.out.println("[valorPolimorfo]"+mensaje);
   }
    
    
}
