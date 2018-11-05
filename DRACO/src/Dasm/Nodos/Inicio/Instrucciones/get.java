/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Dasm.EstructurasDasm.Stack.nodoStack;
import Dasm.Nodos.Inicio._E;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class get extends funcion{
    
    public get(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    
    
    /**
     * <br> +----------------
     * <br> | tGet_local  E
     * <br> +---------------- 
     * <br> | Sirve para get_local num
     * <br> | Extrae en stack y push en pilita
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_16(elementoEntorno entorno) { 
        
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        //recuperando el numero 
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return retorno;
        }
        
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_16][tGet_local_E]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Stack.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
        
        return retorno;    
    }
     
    
    
    /**
     * <br> +----------------
     * <br> | tGet_global  E
     * <br> +---------------- 
     * <br> | Sirve para get_local num
     * <br> | Extrae en heap y push en pilita
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_18(elementoEntorno entorno) { 
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        //recuperando el numero 
         _E nodoE =(_E)listaHijos.lstHijos.get(0);
         //parseando el numero
         itemValor valE=nodoE.getValor(entorno);
        
        if (!valE.isTypeNumero()) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "Se estaba esperando un valor tipo numérico/decimal, pero se recibió: "+valE.tipo);
            return retorno;
        }
        
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_18][tGet_global]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Heap.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
        
        return retorno;       
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | GET LOCAL ID
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * <br> +----------------
     * <br> | tGet_local valId
     * <br> +----------------  
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_17(elementoEntorno entorno) { 
        
        
        itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
            return get_local_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
            return get_local_ret(entorno); 
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
            return new itemRetorno();
        }         
    }
    
    
    /**
     * <br> +----------------
     * <br> | get_local $calc
     * <br> +---------------- 
     * <br> | Sirve para get_local calc
     * <br> | Extrae en stack la pos de la cima de pilita y push en pilita
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno get_local_calc(elementoEntorno entorno) { 
        
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        //sacando de pilita
        Double index = entorno.Pilita.pop(atributo);
        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[get_local_calc]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Stack.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
        
        return retorno;      
    }
    
    /**
     * <br> +----------------
     * <br> | get_local $ret
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    
    public itemRetorno get_local_ret(elementoEntorno entorno) {  
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
         
        
        //extraer  de pilita  retorno
        Double valor=entorno.Pilita.popRetorno(atributo);
        //insertar en pilita
        entorno.Pilita.push(valor);
        
        return retorno;      
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | GET GLOBAL ID
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    
    
    /**
     * <br> +----------------
     * <br> | tGet_global valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_19(elementoEntorno entorno) {
        itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
            return get_global_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
            return get_local_ret(entorno); 
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
            return new itemRetorno();
        }        
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | get_global $calc
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno get_global_calc(elementoEntorno entorno) {
        
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
        
        
         
        Double index = entorno.Pilita.pop(atributo);
        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[get_global_calc]El indice contiene decimales pero se truncaron");
             
        //Obteniendo valor
        nodoStack valor= entorno.Heap.get(index.intValue(), atributo);
        
        //haciendo push en pilita
        entorno.Pilita.push(valor.valor);
        
        return retorno;      
    }
     
    
}
