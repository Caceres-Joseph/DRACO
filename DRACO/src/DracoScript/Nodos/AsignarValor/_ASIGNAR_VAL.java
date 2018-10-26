/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    ASIGNAR_VAL     ::= ASGIN_VAR
                    |   valId sDobleMas
                    |   valId sDobleMenos;
 */
 
public class _ASIGNAR_VAL extends nodoModelo{
    
    
    /**
     * constructor de _ASIGNAR_VAL
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _ASIGNAR_VAL(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables
     * @return 
     */
        @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        validandoDebug();
        
        
        
        // return listaHijos.ejecutar(entorno);
        execute(entorno);
        return ret;
    }
    
    
    public void execute(elementoEntorno entorno){
         
        switch (atributo.nivelProduccion) {

            case 0: 
                case_0(entorno);
                break;
            case 1: 
                case_1(entorno);
                break;
 
            case 2:
                case_2(entorno);
                break;
                
        }
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | ASGIN_VAR
     * <br> +----------------
     * <br> | Se asignará un nuevo valor 
     * @param entorno Es el ambito que recibe
     */
    public void case_0(elementoEntorno entorno) { 
        
        listaHijos.ejecutar(entorno);
    }
    
    
    /**
     * <br> +----------------
     * <br> |  valId sDobleMas
     * <br> +----------------
     * <br> | Incrementando la variable
     * @param entorno Es el ambito que recibe
     */
    public void case_1(elementoEntorno entorno) { 
        itemAtributo atribId=listaAtributos.getAtributo(0); 
        
        itemValor var= entorno.getValVariable(atribId);
        
        if(hayErrores())
            return;
        
        Object ent= var.getParseadoNumero(atribId);
        
        if(ent==null)
            return;
        
        double valor= (double)ent;
        valor++;
        var.setValor(valor);
        
        entorno.setValVariable(atribId, var);
        
        listaHijos.ejecutar(entorno);
    }
    
    
    /**
     * <br> +----------------
     * <br> |  valId sDobleMenos
     * <br> +----------------
     * <br> | Decrementando la variable 
     * @param entorno Es el ambito que recibe
     */
    public void case_2(elementoEntorno entorno) { 
        
        itemAtributo atribId=listaAtributos.getAtributo(0); 
        
        itemValor var= entorno.getValVariable(atribId);
        
        if(hayErrores())
            return;
        
        Object ent= var.getParseadoNumero(atribId);
        
        if(ent==null)
            return;
        
        double valor= (double)ent;
        valor--;
        var.setValor(valor);
        
        entorno.setValVariable(atribId, var);
        
        listaHijos.ejecutar(entorno);
    }
    
    
    
    
}
