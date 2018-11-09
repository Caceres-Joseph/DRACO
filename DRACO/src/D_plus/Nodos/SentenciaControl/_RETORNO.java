/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.SentenciaControl;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import D_plus.Estructuras.Listas.lstMetodoFuncion;
import D_plus.Nodos.Valor._VALOR;
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
RETORNO             ::= tRetornar  sPuntoComa
                    |   tRetornar  VALOR  sPuntoComa
                    ;
 */
public class _RETORNO extends nodoModelo {
    
    public _RETORNO(itemAtributo atrib, elementoGlobal simbolo) {
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
     * @return El retorno es cuando viene un break
     */
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno){ 
        validandoDebug();
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        
        return casos(entorno);
    }
    
    public itemRetorno casos(elementoEntorno entorno) { 
        itemRetorno retorno=new itemRetorno();
          
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno); 
            
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        }  
    }
    
    
    /**
     * <br> +----------------
     * <br> | tRetornar  sPuntoComa
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
          
        //recuperando el valorPolimorfo de la funcion actual
      
        valorPolimorfo valPolimorfoFunc= lstMetodoFuncion.valPolimorfoFuncActual;
        if(valPolimorfoFunc!=null){
            /*Es un retorno con valor*/
         
           if(!"vacio".equals(valPolimorfoFunc.tipo.valLower)){
                simbolo.tablaErrores.insertErrorSemantic(atributo,"La funcion:"+valPolimorfoFunc.nombre.valor+" no es de tipo vacio, es de tipo:"+valPolimorfoFunc.tipo.valor);
                return retorno;
            }
             
            /*CODIGO DASM*/
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(simbolo.salidaDasm.gettEtiquetaRetornar()), "saliendo del metodo", entorno.nivel);
        }else{
            //asumo que retorna un void prro
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(simbolo.salidaDasm.gettEtiquetaRetornar()), "saliendo del metodo", entorno.nivel);
            return retorno;
        }
        
        return retorno;
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | tRetornar  VALOR  sPuntoComa
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
         
        //recuperando el valorPolimorfo de la funcion actual
      
        valorPolimorfo valPolimorfoFunc= lstMetodoFuncion.valPolimorfoFuncActual;
        if(valPolimorfoFunc!=null){
            /*Es un retorno con valor*/
            _VALOR nodoValor=(_VALOR)listaHijos.lstHijos.get(0);
            itemValor valValor=nodoValor.getValor(entorno);
            
            //validando las dimensiones del retorno y el tipo de retorno
            if(valValor.dimension!=0){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "No puede retornar arreglos en la funcion:"+valPolimorfoFunc.nombre.valor);
                return retorno;
            }else if(valValor.isTypeNulo()){
                
                simbolo.tablaErrores.insertErrorSemantic(atributo, "No puede retornar un valor nulo de la funcion:"+valPolimorfoFunc.nombre.valor);
                println("[tRetornar  VALOR  sPuntoComa]Estoy retornando un nulo");
                return retorno;
            }
            else if(!valValor.tipo.equals(valPolimorfoFunc.tipo.valor)){
                simbolo.tablaErrores.insertErrorSemantic(atributo,"No se puede retornar un tipo:"+valValor.tipo+" en la funcion:" +valPolimorfoFunc.nombre.valor+" de tipo: "+valPolimorfoFunc.tipo.valor);
                return retorno;
            }
             
            /*CODIGO DASM*/
            //Colocando el valor
            simbolo.salidaDasm.comentario("RETORNO VAL:", entorno.nivel);
            for (String string : valValor.cadenaDasm) {
                simbolo.salidaDasm.linea(string, entorno.nivel);
            }
            
            //colocandolo en el retorno
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_ret(),"Colocando el valor del retorno", entorno.nivel);
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(simbolo.salidaDasm.gettEtiquetaRetornar()), "saliendo del metodo", entorno.nivel);
        }else{
            //asumo que retorna un void prro
            simbolo.tablaErrores.insertErrorSemantic(atributo,"No puede retornar un valor en una funcion de tipo vacio.");
            return retorno;
        }
        return retorno;
    }
     
    
}
