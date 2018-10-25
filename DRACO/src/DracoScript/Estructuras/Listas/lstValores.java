/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Listas;

import Gui.Elementos.elementoGlobal; 
import DracoScript.Estructuras.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemValor;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstValores {
    public Map<String, itemValor> lstVariables ;
    public elementoGlobal simbolo;
    
    public lstValores(elementoGlobal simbolo){
        lstVariables=new LinkedHashMap<>(); 
        this.simbolo=simbolo;
    }
     
    
    /**
     * Es el metodo para ingresar las nuevas varaibles al ambito
     * @param nombreVar Es el nombre de la nueva variable.
     * @param var Varaible nueva que va ser ingresada.
     */
    public void insertarVariable(itemAtributo nombreVar, itemValor var){
        
        if(_siExisteLaVariable(nombreVar)){
            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" ya se encuentra declarada en el mismo ámbito");
        }else{
            lstVariables.put(nombreVar.valLower, var);
        }
        
    }
    
    
     
    /**
     * Validando si ya se encuentra declarada la variable 
     * @param var Varaible nueva que va ser ingresada.
     * @return True si ya se declaró la variable
     */
    public boolean _siExisteLaVariable(itemAtributo var){
        
        for (Map.Entry<String,itemValor> lstVariable : lstVariables.entrySet()) {
            String nombreVar=lstVariable.getKey();
            if(var.valLower.equals(nombreVar)){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Recuperando el valor de la variable
     * @param atribNombreVar
     * @return 
     */
    public itemValor _getValVariable(itemAtributo atribNombreVar){
         
        for (Map.Entry<String,itemValor> lstVariable : lstVariables.entrySet()) {
            String nombreVar=lstVariable.getKey();
            
            if(atribNombreVar.valLower.equals(nombreVar)){
                return lstVariable.getValue();
            }
        }
        //hay que buscar en los ambitos anteriores
        
        
//        simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
        return null;
    }
    
    
    /**
     * Enviando el valor de la variable
     * @param atribNombreVar
     * @param val
     * @return 
     */
    public boolean _setValVariable(itemAtributo atribNombreVar, itemValor val){
          
        for (Map.Entry<String,itemValor> lstVariable : lstVariables.entrySet()) {
            String nombreVar=lstVariable.getKey();
            
            if(atribNombreVar.valLower.equals(nombreVar)){
                lstVariables.put(nombreVar, val);
                return true;
            }
        }
        
        simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
        return true;
    }
    
}
