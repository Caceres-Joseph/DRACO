/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import D_plus.Estructuras.Items.itemValor;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Dasm.Nodos.Inicio._E;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class set extends saltos{
    
    public set(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tSet_local  E
     * <br> +---------------- 
     * <br> | Sirve para set_local num
     * <br> | Pop en pilita y push en stack
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_20(elementoEntorno entorno) {  
        
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
        
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case20][tSet_local_E]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Stack.set(valor, index.intValue(), atributo); 
        return retorno;     
    }
    /**
     * <br> +----------------
     * <br> | tSet_global  E
     * <br> +---------------- 
     * <br> | Sirve para set_local num
     * <br> | Pop en pilita y push en heap
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_22(elementoEntorno entorno) {   
        
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
        
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        Double index = valE.getNumero();

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[case_22][tSet_global_E]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Heap.set(valor, index.intValue(), atributo); 
        return retorno;   
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | SET LOCAL ID
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    /**
     * <br> +----------------
     * <br> | tSet_local valId
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_21(elementoEntorno entorno) {  
        
        itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
            return set_local_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
            return set_local_ret(entorno); 
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
            return new itemRetorno();
        }     
    }
    
    
    /**
     * <br> +----------------
     * <br> | set_local $calc
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno set_local_calc(elementoEntorno entorno) {  
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
         
        
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        Double index = entorno.Pilita.pop(atributo);

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[set_local_calc]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Stack.set(valor, index.intValue(), atributo); 
        return retorno;      
    }
     
    
    /**
     * <br> +----------------
     * <br> | set_local $ret
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno set_local_ret(elementoEntorno entorno) {  
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
         
        
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo); 
        //insertar en pila retorno
        entorno.Pilita.pushRetorno(valor);
        
        return retorno;      
    }
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | SET GLOBAL ID
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    /**
     * <br> +----------------
     * <br> | tSet_global valId
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_23(elementoEntorno entorno) { 
         
        itemAtributo respuesta=listaAtributos.getAtributo(0);
        if(respuesta.valLower.equals("$calc")){
            return set_global_calc(entorno);
        }
        else if(respuesta.valLower.equals("$ret")){
            return set_local_ret(entorno);
        }
        else{
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se reconoce el id como $calc o $ret, en su lugar:"+respuesta.valor);
            return new itemRetorno();
        }
    }
    
    
    /**
     * <br> +----------------
     * <br> | set_global $calc
     * <br> +---------------- 
     * <br> | Primer pop valor, segundo pop indice
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno set_global_calc(elementoEntorno entorno){
        itemRetorno  retorno=new itemRetorno();
        if(hayErrores())
            return retorno;
          
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        Double index = entorno.Pilita.pop(atributo);

        if (!(index%1 == 0))  
            //el indice no es un entero
            println("[set_global_calc]El indice contiene decimales pero se truncaron");
             
        //guardando en stack
        entorno.Heap.set(valor, index.intValue(), atributo); 
        return retorno;   
    }
    
    
    
    
    
}
