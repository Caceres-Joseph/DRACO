/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class saltos extends relacional{
    
    public saltos(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {   
         if(hayErrores())
             return new itemRetorno();
        
         
        return new itemRetorno();     
    }
    
    
    /**
     * <br> +----------------
     * <br> | tBr valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_14(elementoEntorno entorno) {  
        itemRetorno retorno=new itemRetorno();
        
        if(hayErrores())
             return retorno; 
         
         itemAtributo etiquetaOrigen = listaAtributos.getAtributo(0);
         retorno.setBreak(etiquetaOrigen);

        return retorno;     
    }
    
    
    /**
     * <br> +----------------
     * <br> | tBrIf valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_15(elementoEntorno entorno) { 
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer  de pilita 
        Double num1 = entorno.Pilita.pop(atributo);
 
        
        //Si es cero hace el salto
        if (num1 == 0.0) {
            itemAtributo etiquetaOrigen = listaAtributos.getAtributo(0);
            retorno.setBreak(etiquetaOrigen);
            return retorno;
        } 

        return retorno;    
    }
    
    
    
}
