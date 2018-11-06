/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno; 
import Dasm.Nodos.Inicio._E;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class num extends logicas{
    
    public num(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | E
     * <br> +----------------
     * <br> |Hay que igresar el valor a la pilita
     * @param entorno Es el ambito que recibe 
     */
    public void case_26(elementoEntorno entorno) {   
         if(hayErrores())
             return ; 
         
         
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return ;
        }
        
        
         
         //guradandolo en pilita 
        entorno.Pilita.push(valE.getNumero());  
    }
    
    
    /**
     * <br> +----------------
     * <br> | valDecimal
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
//    public void case_27(elementoEntorno entorno) {  
//        itemRetorno retorno=new itemRetorno();
//         if(hayErrores())
//             return ; 
//         //parseando el numero
//         itemValor temp=new itemValor(simbolo);
//         Object objTemp=temp.getParseadoNumero(listaAtributos.lstAtributos.get(0));
//         
//         if(objTemp==null)
//             return ;
//         
//         
//         Double doubleTemp=(Double)objTemp;
//         //guradandolo en pilita 
//         entorno.Pilita.push(doubleTemp); 
//        return ;      
//    }
    
    
    /**
     * <br> +----------------
     * <br> | valCadena
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    public void case_28(elementoEntorno entorno) {    
         if(hayErrores())
             return ; 
         
          
         //parseando a cadena
         itemValor valor=new itemValor(simbolo);
         valor.parseToCadena(listaAtributos.getAtributo(0)); 
        
        if (!valor.isTypeCadena()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo cadena, pero se recibió: "+valor.tipo);
            return ;
        }
        
         //guradandolo en pilita 
        entorno.Pilita.push(valor.getCadena());   
    }
    
    
}
