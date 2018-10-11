/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Items;

import DracoScript.Estructuras.Elementos.elementoGlobal;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class itemEntorno {
    public Map<String, itemEntorno> lstVariables ;
    public elementoGlobal simbolo;
    
    public itemEntorno(elementoGlobal simbolo){
        this.simbolo=simbolo;
    }
    
    
    
    /**
     * Es el metodo para ingresar las nuevas varaibles al ambito
     * @param nombreVar Es el nombre de la nueva variable.
     * @param var Varaible nueva que va ser ingresada.
     */
    public void insertarVariable(String nombreVar, itemEntorno var){
        lstVariables.put(nombreVar, var);
    }
    
}
