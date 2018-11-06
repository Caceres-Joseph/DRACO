/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Casos;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class _CASO_14 extends nodoModelo {
    
    public _CASO_14(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    
    /**
     * <br> +----------------
     * <br> | tBr valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
//        entorno.punteroCodigo++;  
        validandoDebug();
         saltar(entorno);
        
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
