/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.EstructurasDasm.Pilita;

import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class pilita {
    
    elementoGlobal simbolo;
    public ArrayList<Double> listaDoubles;
    
    
    public pilita(elementoGlobal simbolo){
        this.simbolo=simbolo;
        this.listaDoubles=new ArrayList<>();
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PILA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    public void push(double num){
        listaDoubles.add(num);
    }
    
    public Double pop(itemAtributo etiqu){
        if(listaDoubles.isEmpty()){
            simbolo.tablaErrores.insertErrorSemantic(etiqu,"La pila de operaciones esta vacia, índice excedido");
            return null;
        }
        return listaDoubles.get(listaDoubles.size()-1);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | ARITMETICA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    
}
