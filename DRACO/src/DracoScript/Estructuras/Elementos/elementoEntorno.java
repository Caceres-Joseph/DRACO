/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Elementos;

import DracoScript.Estructuras.Items.itemEntorno;
import java.util.LinkedHashMap;
import java.util.Map; 

/**
 *
 * @author joseph
 */
public class elementoEntorno {
    /**
     * Es el ambito anterior donde se encuentran las variables
     */
    public elementoEntorno anterior;
    public elementoGlobal simbolo;
    public String nombre;
    public Map<String, itemEntorno> lstVariables ;
    
    /**
     * 
     * @param anterior Es el nodo anterior para moverse al ambito
     * @param nombre Nombre del entorno
     * @param simbolo Simbolo que maneja la tabla de errores
     */
    public elementoEntorno(elementoEntorno anterior,String nombre, elementoGlobal simbolo){
        this.anterior=anterior;
        this.simbolo=simbolo;
        this.nombre=nombre;
        this.lstVariables=new LinkedHashMap<>();
        
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
