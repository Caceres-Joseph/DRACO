/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno; 
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
     */
    public void case_0(elementoEntorno entorno) {  
        
    }
    
    
    /**
     * <br> +----------------
     * <br> | tBr valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    public void case_14(elementoEntorno entorno) {

        saltar(entorno);
    }

    
    /**
     * <br> +----------------
     * <br> | tBrIf valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    public void case_15(elementoEntorno entorno) {  
        if (hayErrores()) {
            return ;
        }
        //extraer  de pilita 
        Double num1 = entorno.Pilita.pop(atributo);
 
        
        //Si es cero hace el salto
        if (num1 == 0.0) {
//            itemAtributo etiquetaOrigen = listaAtributos.getAtributo(0); 
            saltar(entorno);
        } else{
            //Si no cumple la condición incremento el puntero
            entorno.punteroCodigo++;
        }
   
    }
    
    
    
    public void saltar(elementoEntorno entorno){
        if (hayErrores()) {
            return;
        }

        if (entorno.listaEtiquetas == null)  
            return;
        
        itemAtributo etiquetaOrigen = listaAtributos.getAtributo(0);
        if(entorno.listaEtiquetas.hashEtiquetas.containsKey(etiquetaOrigen.valor)){
            
            //Modifico la posición del puntero para que haga el salto
            entorno.punteroCodigo=entorno.listaEtiquetas.hashEtiquetas.get(etiquetaOrigen.valor);
            return;
        }else{
            simbolo.tablaErrores.insertErrorSemantic(etiquetaOrigen,"La etiqueta:"+etiquetaOrigen.valor+" no se encuentra en el ambito.");
        }
        entorno.punteroCodigo=-1;
    }
    
    
}
