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
public class _CASO_29 extends nodoModelo{
    
    public _CASO_29(itemAtributo atrib, elementoGlobal simbolo) {
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
     * <br> | tPrint
     * <br> +---------------- 
     * <br> | Recibe dos parametros, uno de tipo cadena "%c"
     * <br> | el otro de tipo numerico pop a pilita
     * 
     * @param entorno Es el ambito que recibe 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        entorno.punteroCodigo++;  
        validandoDebug();
        
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        String formato = entorno.Pilita.popCadena(atributo);
        int valEntero=valor.intValue();
        switch (formato.toLowerCase()) {
            case "%c":
                simbolo.setConsola(String.valueOf((char)valEntero));
                break;
            case "%d":
                simbolo.setConsola(String.valueOf(valEntero));
                break;
            case "%f":
                simbolo.setConsola(String.valueOf(valor));
                break;
            default:
                simbolo.tablaErrores.insertErrorSemantic(atributo,"No se reconoce el formato" +formato);
                break;
        } 
        
    }
}
