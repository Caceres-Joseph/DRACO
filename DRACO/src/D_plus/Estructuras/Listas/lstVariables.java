/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Estructuras.Items.itemValor;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstVariables {
    public Map<String, itemValor> lstVariables ;
    public Map<String, nodTipo> lstVariablesTipo ;
    public elementoGlobal simbolo;
    
    public int numVar=0;
    public lstVariables(elementoGlobal simbolo){
        lstVariables=new LinkedHashMap<>(); 
        lstVariablesTipo=new LinkedHashMap<>();
        this.simbolo=simbolo;
    }
     
    
    /**
     * Es el metodo para ingresar las nuevas varaibles al ambito
     * @param nombreVar Es el nombre de la nueva variable.
     * @param var Varaible nueva que va ser ingresada.
     * @param tipo El tipo de la variable
     */
//    public void lstVariables(itemAtributo nombreVar, itemValor var, String tipo){
//        //tiene que coincidir los tipos para guardarlos
//        if(var.isTypeNulo()){
//            
//        } if(!tipo.toLowerCase().equals(var.tipo.toLowerCase())){
//            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" es de tipo: "+tipo+", pero se esta recibiendo una variable de tipo:"+var.tipo);
//            return;
//        }
//        
//        if(_siExisteLaVariable(nombreVar)){
//            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" ya se encuentra declarada en el mismo ámbito");
//        }else{
//            lstVariables.put(nombreVar.valor, var);
//            lstVariablesTipo.put(nombreVar.valor, tipo);
//        }
//        
//    }
    
    
    /**
     * Es el metodo para ingresar las nuevas varaibles al ambito
     * @param nombreVar Es el nombre de la nueva variable.
     * @param var Varaible nueva que va ser ingresada.
     * @param tipo TIpo de variable
     * @param dimension Dimesion de la varibale
     * @param posRelativa Posicion relativa
     * @param nombreEtorno
     */
    
    public void insertarVariable(itemAtributo nombreVar, itemValor var, String tipo, int dimension, int posRelativa, String nombreEtorno){
        //tiene que coincidir los tipos para guardarlos
        var.nombreEntorno=nombreEtorno;
        var.posRelativa=posRelativa;
        var.posVarDpp=numVar++;
        
//        if(dimension!=var.dimension){
//            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" es de dimension: "+String.valueOf(dimension)+", pero se esta recibiendo una valor de tipo:"+String.valueOf(var.dimension));
//            return;
//        }
        
        if(var.isTypeNulo()){
            
        } else if(!tipo.toLowerCase().equals(var.tipo.toLowerCase())){
            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" es de tipo: "+tipo+", pero se esta recibiendo un valor de tipo:"+var.tipo);
            return;
        }
        
        if(_siExisteLaVariable(nombreVar)){
            simbolo.tablaErrores.insertErrorSemantic(nombreVar, "La variable "+ nombreVar.valor +" ya se encuentra declarada en el mismo ámbito");
        }else{
            lstVariables.put(nombreVar.valor, var);
            nodTipo nod=new nodTipo(tipo, posRelativa);
            lstVariablesTipo.put(nombreVar.valor, nod);
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
              
                nodTipo tipo = lstVariablesTipo.get(nombreVar);
                itemValor retorno= lstVariable.getValue();
                retorno.tipoSupremo=tipo.tipo;
                return retorno;
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
    
    
    public void imprimir(){
          //llenando la tabla 
        for (String key : lstVariables.keySet()) {
//            System.out.println("Clave: " + key + " -> Valor: " + Heap.listaNodoStack.get(key));
            itemValor val = lstVariables.get(key);
            nodTipo tipo=lstVariablesTipo.get(key);
            println("tipo:"+tipo.tipo+" dim:"+val.dimension+" nombre"+key);
        }
    }
    
    public void println(String mensaje){
        System.out.println("[Dpp][lstVariabels]"+mensaje);
    }
    
    
    public class nodTipo{
        public String tipo;
        public int posRelativa;
        
        public nodTipo(String tipo, int posRelativa){
            this.tipo=tipo;
            this.posRelativa=posRelativa;
        }
    }
}
