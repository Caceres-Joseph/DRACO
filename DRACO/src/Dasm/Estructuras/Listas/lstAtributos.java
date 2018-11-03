/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Listas;
  
import Gui.Items.itemAtributo;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class lstAtributos {
    public ArrayList<itemAtributo> lstAtributos=new ArrayList<>();
    
    /**
     * Inserta un nuevo atributo
     * @param hijo El nuevo atributo a insertar
     */
    public void insertar(itemAtributo hijo){
        lstAtributos.add(hijo);
    }
    
     
    public itemAtributo getAtributo(int i){
        
        if(i<lstAtributos.size()){ 
            return lstAtributos.get(i);
        }else{
            println("[ERROR][getAtributo i]Indice excedido");
            itemAtributo ite=new itemAtributo("---", "[ERROR][getAtributo i]Indice excedido", -1);
            return ite;
        }
    }
    
    
    public void println(String mensaje){
        System.out.println("[lstAtributos]"+mensaje);
    }
    
    
     
}
