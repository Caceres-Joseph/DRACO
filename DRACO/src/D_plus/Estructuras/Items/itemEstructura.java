/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Items;

import D_plus.Estructuras.Listas.lstVariables;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class itemEstructura {
    public lstVariables lstVariables ;
    elementoGlobal simbolo;
    public itemAtributo nombre;
    
    public itemEstructura(elementoGlobal simbolo, itemAtributo nombre){
        this.simbolo=simbolo;
        this.nombre=nombre;
        this.lstVariables=new lstVariables(simbolo); 
    }
    
     
    
    public void println(String mensaje){
        System.out.println("[lstEstructura]"+mensaje);
    }
    
    
}
