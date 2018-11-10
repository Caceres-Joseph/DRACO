/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.IdVarFunc;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemEstructura;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Valor._E;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
LST_PUNTOSP         ::= sPunto  valId
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent
                    |   sPunto  valId  sAbreParent           sCierraParent

                    //Corchetes
                    |   sPunto  valId  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
                    ;
 */
public class _LST_PUNTOSP extends nodoModelo{
    
    public _LST_PUNTOSP(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param entorno Es la tabla que contiene las variables
     * @return
     */ 
    public itemValor getValor(elementoEntorno entorno, itemEstructura estructura){ 
        return iniciar(entorno, estructura); 
    }
    
    
    /**
     * Inicia el analisis de ejecución
     *
     * @param entorno
     * @param estructura
     * @return Retorno para revisión de break
     */
     
    public itemValor iniciar(elementoEntorno entorno, itemEstructura estructura) {
        itemValor retorno=new itemValor(simbolo);
             
        if(hayErrores())
            return retorno;

        switch (atributo.nivelProduccion) {

            case 0: 
                return case_0(entorno, estructura); 
 
            case 1: 
                return case_1(entorno, estructura); 
            case 2:  
                return case_2(entorno, estructura); 
            case 3: 
                return case_3(entorno, estructura); 
            case 4: 
                return case_4(entorno,estructura);  
            case 5: 
                return case_5(entorno, estructura);   
            default:
                println("[getValor]No se encontro el nivel");
                return new itemValor(simbolo);
        }

        //return new itemValor(simbolo);
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | sPunto  valId
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @param estructura
     * @return Retorna para revisión de break
     */
    public itemValor case_0(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         
        //hay que buscar si existe el elemento dentro de la estructura
        
        itemAtributo nombreVar=listaAtributos.getAtributo(0);
        itemValor val=estructura.lstVariables._getValVariable(nombreVar);
        
        if(val==null)  
            return retorno;
        
        val.miembroEstructura=true;
        return val;
         
    }

    
    /**
     * <br> +----------------
     * <br> | sPunto  valId  sAbreParent  LST_VAL  sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_1(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No estan permitidos las funciones dentro de estructuras");
        return retorno;
    }

    
    
    /**
     * <br> +----------------
     * <br> |sPunto  valId  sAbreParent           sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_2(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No estan permitidos las funciones dentro de estructuras");
        return retorno;
    }

    
    
    /**
     * <br> +----------------
     * <br> | sPunto  valId  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_3(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         
        return retorno;
    }

    
    /**
     * <br> +----------------
     * <br> | sPunto  valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_4(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No estan permitidos las funciones dentro de estructuras");
        return retorno;
    }

    
    
    /**
     * <br> +----------------
     * <br> | sPunto  valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor case_5(elementoEntorno entorno, itemEstructura estructura) {
        
        itemValor retorno = new itemValor(simbolo);
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No estan permitidos las funciones dentro de estructuras");
        return retorno;
    }

    
    
    
    
}
