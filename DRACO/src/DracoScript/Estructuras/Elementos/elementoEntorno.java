/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Elementos;
 
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Estructuras.Listas.lstValores; 
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
    public lstValores lstVariables ;
    
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
        this.lstVariables=new lstValores(simbolo);
    }
    
    
    
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | OPERACIONES CON LA LISTA DE VARIABLES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    
    /**
     * Recuperando el valor de la variable
     * @param atribNombreVar
     * @return 
     */
    public itemValor getValVariable(itemAtributo atribNombreVar){
         
         itemValor val= lstVariables._getValVariable(atribNombreVar);
         
         if(val==null){
             if(anterior!=null){
                 return anterior.getValVariable(atribNombreVar);
             }else{ 
                simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
                return new itemValor(simbolo);
             }
         }else{
             return val;
         } 
    }
    
    
    /**
     * Enviando el valor de la variable
     * @param atribNombreVar
     * @param valor El nuevo valor que va tomar la variable
     * @return 
     */
    public boolean setValVariable(itemAtributo atribNombreVar, itemValor valor){
           
         itemValor val= lstVariables._getValVariable(atribNombreVar);
         
         if(val==null){
             if(anterior!=null){
                 return anterior.setValVariable(atribNombreVar, valor);
             }else{ 
                simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
                return false;
             }
         }else{
             lstVariables._setValVariable(atribNombreVar, valor);
             return true;
         } 
         
    }
}
