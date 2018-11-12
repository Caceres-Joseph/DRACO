/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.IdVarFunc;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemEstructura;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Arreglo._LST_CORCHETES_VAL;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
ID_VAR_FUNC         ::= ID_VAR_FUNC LST_PUNTOSP
                    |   valId
                    |   valId sAbreParent  LST_VAL  sCierraParent
                    |   valId sAbreParent           sCierraParent
                    //para hacer uso de corchetes
                    |   valId  LST_CORCHETES_VAL
                    |   valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
 */
public class _ID_VAR_FUNC_PADRE2 extends nodoModelo{
    
    public _ID_VAR_FUNC_PADRE2(itemAtributo atrib, elementoGlobal simbolo) {
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

    public itemValor getDireccionVal(elementoEntorno entorno) { 
        itemValor retorno=new itemValor(simbolo);
        if (hayErrores()) {
            return retorno;
        }  
        return d_casos(entorno);

    }
    
    
    
    public itemValor d_casos(elementoEntorno entorno){
        itemValor retorno=new itemValor(simbolo);
          
        switch(atributo.nivelProduccion){
            case 0:
                return d_case_0(entorno);
            case 1:
                return d_case_1(entorno);
            case 2:
                return d_case_2(entorno);
            case 3:
                return d_case_3(entorno);
            case 4:
                return d_case_4(entorno);
            case 5:
                return d_case_5(entorno);
            case 6:
                return d_case_6(entorno);
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        } 
        
         
    }
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC  LST_PUNTOSP
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_0(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        _ID_VAR_FUNC nodoVarFun = (_ID_VAR_FUNC)listaHijos.lstHijos.get(0);
       _LST_PUNTOSP nodoLstPuntos=(_LST_PUNTOSP)listaHijos.lstHijos.get(1);
       
        //aqui se que estructura y la busco 
        itemValor valIdVar= nodoVarFun.getDireccionVal(entorno);

        
        if(!entorno.funciones.listaEstructuras.listaEstructuras.containsKey(valIdVar.tipo)){
            simbolo.tablaErrores.insertErrorSemantic(atributo,"No se encontró la estructura de tipo:"+valIdVar.tipo);
            return retorno;   
        }
        
        itemEstructura estructura=  entorno.funciones.listaEstructuras.listaEstructuras.get(valIdVar.tipo);
        itemValor valPuntos=nodoLstPuntos.getValor(entorno, estructura);
        
        if(hayErrores())
            return retorno;
        
        valPuntos.posRelativa=valIdVar.posRelativa;
        valPuntos.nombreEntorno=valIdVar.nombreEntorno;
        //println("[d_case_0]Se econtro la estructura prro");
        
       
        return valPuntos;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_1(elementoEntorno entorno) { 
        //verifico si existe la varaible
        itemAtributo nombreVariable=listaAtributos.getAtributo(0);
        itemValor val= entorno.getValVariable(nombreVariable);
        
        if(hayErrores())
            return val;
        
        
        
        
         //retorno la posicion de la variable
       
        return val;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId sAbreParent  LST_VAL  sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_2(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
        
        simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede asignar un valor a una funcion");
       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId sAbreParent           sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_3(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 

       
        simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede asignar un valor a una funcion");
       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_4(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        retorno.dasmAccediendoElemArreglo=true;
        
        
       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_5(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 

        simbolo.tablaErrores.insertErrorSemantic(atributo, "No se pueden retornar arreglos en funciones");
       
       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> | valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */ 
    public itemValor d_case_6   (elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
        simbolo.tablaErrores.insertErrorSemantic(atributo, "No se pueden retornar arreglos en funciones");
       
        return retorno;
    }
     
}
