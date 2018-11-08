/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.IdVarFunc;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.itemClave;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import D_plus.Nodos.Parametros._LST_VAL;
import Gui.Items.itemAtributo;
import Gui.Elementos.elementoGlobal;  
import java.util.ArrayList;

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
public class _ID_VAR_FUNC extends _ID_VAR_FUNC_PADRE {
    
    public _ID_VAR_FUNC(itemAtributo atrib, elementoGlobal simbolo) {
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

    public itemValor getValor(elementoEntorno entorno) { 
        itemValor retorno=new itemValor(simbolo);
        if (hayErrores()) {
            return retorno;
        }  
        return v_casos(entorno);

    }
    
    
    
    public itemValor v_casos(elementoEntorno entorno){
        itemValor retorno=new itemValor(simbolo);
          
        switch(atributo.nivelProduccion){
            case 0:
                return v_case_0(entorno);
            case 1:
                return v_case_1(entorno);
            case 2:
                return v_case_2(entorno);
            case 3:
                return v_case_3(entorno);
            case 4:
                return v_case_4(entorno);
            case 5:
                return v_case_5(entorno);
            case 6:
                return v_case_6(entorno);
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
    public itemValor v_case_0(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 

       
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> |valId  
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_1(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
        //verifico si existe la varaible
        itemAtributo nombreVariable=listaAtributos.getAtributo(0);
        itemValor val= entorno.getValVariable(nombreVariable);
        if(hayErrores())
            return new itemValor(simbolo);
        
        
        //verificando si no es una variable global
        if(val.nombreEntorno.equals("global")){
            //posicion relativa de la variable
            retorno.cadenaDasm.add(String.valueOf(val.posRelativa));
            //obteniendo el valor de esa posicion
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_calc());
            
        }else{
            //obtengo el puntero
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_id("0"));
            //posicion relativa de la variable
            retorno.cadenaDasm.add(String.valueOf(val.posRelativa));
            //sumando
            retorno.cadenaDasm.add(simbolo.salidaDasm.getAdd());
            //obteniendo el valor de esa posicion
            retorno.cadenaDasm.add(simbolo.salidaDasm.getGet_local_calc());
        }
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId  sAbreParent  LST_VAL  sCierraParent
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_2(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        

        //la funcion no tiene que ser de tipo void
        _LST_VAL nodoLstValores=(_LST_VAL)listaHijos.lstHijos.get(0);
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>(); 
        for (itemValor lstValore : nodoLstValores.getLstValores(entorno)) {
            itemClave nuevaClave=new itemClave(lstValore.tipo, lstValore.dimension); 
            listaTipos.add(nuevaClave);
        }
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion);
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){   
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        valorPolimorfo retornoFunc= entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.getValorPolimorfo(clave);
        if(retornoFunc.retornoVal.isTypeVacio()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La funcion:"+nombreFuncion.valor+" es de tipo vacio, y no retorna valores");
            return retorno;
        }
        
        
        
        //ahora coloco el codigo de los parametros y el llamado a la funcion
        retornoFunc.retornoVal.cadenaDasm.addAll(cadenaDasm_case2(entorno));
        retornoFunc.retornoVal.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
        //colocando el retorno en la pila
        retornoFunc.retornoVal.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());
        
        return retornoFunc.retornoVal;
    }
    
    /**
     * <br> +----------------
     * <br> |valId sAbreParent           sCierraParent
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_3(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>();  
      
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion);
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){   
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        valorPolimorfo retornoFunc= entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.getValorPolimorfo(clave);
        if(retornoFunc.retornoVal.isTypeVacio()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La funcion:"+nombreFuncion.valor+" es de tipo vacio, y no retorna valores");
            return retorno;
        }
        
        
        
        //ahora coloco el codigo de los parametros y el llamado a la funcion
        retornoFunc.retornoVal.cadenaDasm.addAll(cadenaDasm_case3(entorno));
        //colocando el retorno en la pila
        retornoFunc.retornoVal.cadenaDasm.add(("//Obteniendo el retorno de la funcion"));
        retornoFunc.retornoVal.cadenaDasm.add(simbolo.salidaDasm.getGet_local_ret());
        
        return retornoFunc.retornoVal;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  LST_CORCHETES_VAL:h1
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_4(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 

             
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  sAbreParent  LST_VAL:h1  sCierraParent  LST_CORCHETES_VAL:h2
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_5(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
            simbolo.tablaErrores.insertErrorSemantic(atributo,"No se permite el retorno de arreglos.");

       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  sAbreParent           sCierraParent  LST_CORCHETES_VAL:h1
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemValor v_case_6(elementoEntorno entorno) {
        itemValor retorno = new itemValor(simbolo); 
        
            simbolo.tablaErrores.insertErrorSemantic(atributo,"No se permite el retorno de arreglos.");
 
        return retorno;
    }
    
     
}
