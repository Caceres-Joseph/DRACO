/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.AsignarValor;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo; 
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.Valor._E;
import DracoScript.Nodos.nodoModelo;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
    LST_DECLARAR_VAR::= LST_DECLARAR_VAR sComa  valId
                |   LST_DECLARAR_VAR sComa ASGIN_VAR
                |   valId
                |   ASGIN_VAR  ;
 */
 
public class _LST_DECLARAR_VAR extends nodoModelo {
    
    /**
     * constructor de _LST_DECLARAR_VAR
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _LST_DECLARAR_VAR(itemAtributo atrib, elementoGlobal simbolo) {
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
            case 3:
                case_3(entorno);
                break;
                
            default:
                println("[execute]Ninguno de los casos del AST");
        }
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | LST_DECLARAR_VAR sComa  valId
     * <br> +----------------
     * <br> | Se ha declarado una variable, pero no se le ha asignando ningun valor
     * <br> | Primero se ejecuta LST_DECLARAR_VAR, y de último se declara la nueva variable
     * @param entorno Es el ambito que recibe
     */
    public void case_0(elementoEntorno entorno) { 
        
        _LST_DECLARAR_VAR nod = (_LST_DECLARAR_VAR) listaHijos.lstHijos.get(0);
        nod.ejecutar(entorno);
        
        
        itemValor val=new itemValor(simbolo);
        val.setValor();  
        entorno.lstVariables.insertarVariable(listaAtributos.getAtributo(0), val); 
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | LST_DECLARAR_VAR sComa ASGIN_VAR
     * <br> +----------------
     * <br> | Se ha declarado una variable con valor
     * @param entorno Es el ambito que recibe
     */
    public void case_1(elementoEntorno entorno) {
        
        _LST_DECLARAR_VAR nod = (_LST_DECLARAR_VAR) listaHijos.lstHijos.get(0);
        nod.ejecutar(entorno);
        
        
        _ASGIN_VAR nod2 = (_ASGIN_VAR) listaHijos.lstHijos.get(1);
        nod2.ejecutarDeclarar(entorno);
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId
     * <br> +----------------
     * <br> | Se ha declarado una variable, pero no se le ha asignando ningun valor
     * <br>
     * @param entorno Es el ambito que recibe
     */
    public void case_2(elementoEntorno entorno) { 
        itemValor val=new itemValor(simbolo);
        val.setValor();  
        entorno.lstVariables.insertarVariable(listaAtributos.getAtributo(0), val); 
    }
    
    
    /**
     * <br> +----------------
     * <br> | ASGIN_VAR
     * <br> +----------------
     * <br> | Se ha declarado una variable con valor
     * @param entorno Es el ambito que recibe
     */
    public void case_3(elementoEntorno entorno) {
        
        _ASGIN_VAR nod = (_ASGIN_VAR) listaHijos.lstHijos.get(0);
        nod.ejecutarDeclarar(entorno);
    }
      
}
