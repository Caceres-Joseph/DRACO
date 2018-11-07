/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.DeclararVariable;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Arreglo._VAR_ARREGLO;
import D_plus.Nodos.Inicio._TIPO;
import Gui.Items.itemAtributo; 
import Gui.Elementos.elementoGlobal;  

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
                    |   DECLARAR_VARIABLE sComa VAR_ARREGLO
                    |   TIPO VAR_ARREGLO VAL
                    |   TIPO VAR_ARREGLO
                    ;
 */
public class _DECLARAR_VARIABLE extends _DECLARAR_VARIABLE_1{
    
    public _DECLARAR_VARIABLE(itemAtributo atrib, elementoGlobal simbolo) {
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
    
    
    public itemRetorno casos(elementoEntorno entorno){
        itemRetorno retorno=new itemRetorno();
        
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno);
            case 2:
                return case_2(entorno);
            case 3:
                return case_3(entorno);
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        } 
        
    }
    
    
    /**
     * <br> +----------------
     * <br> |CASE 0
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    
    
    /**
     * <br> +----------------
     * <br> |CASE 1
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |CASE 2
     * <br> +----------------
     * <br> |TIPO VAR_ARREGLO VAL 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_2(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();

        

        _TIPO nodTipo = (_TIPO) listaHijos.lstHijos.get(0);
        itemAtributo tipo = nodTipo.getTipo();

        //hay que guardar la variable en la tabla de simbolos
        _VAR_ARREGLO varArreglo = (_VAR_ARREGLO) listaHijos.lstHijos.get(1);
        itemAtributo idVar = varArreglo.getId();
        int dimension = varArreglo.getDimension();

        _VAL nodVal = (_VAL) listaHijos.lstHijos.get(2);
        itemValor val=nodVal.getValor(entorno);
        
        
        
        
        /*INICIO CODIGO*/
        simbolo.salidaDasm.comentarioPequeño("Declarando variable", idVar.valor+"="+tipo.valor, entorno.nivel);
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Obteniendo el puntero", entorno.nivel);
        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa), "Pos relativa de la variable", entorno.nivel);
        entorno.posRelativa++;
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
         
        
        //guardando la variable en la tabla de simbolos
        entorno.lstVariables.insertarVariable(idVar, val, tipo.valor, dimension, entorno.posRelativa-1);
         
         
        //Ubicndo todo lo que viene en E
        simbolo.salidaDasm.comentario("Operaciones E", entorno.nivel);
        for (String string : val.cadenaDasm) { 
            simbolo.salidaDasm.linea(string,entorno.nivel);
        }
         
        
        
        
        /*INICIO CODIGO*/
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_calc(), "Enviando var a la posicion", entorno.nivel);
        return retorno;
         
    }
    
    /**
     * <br> +----------------
     * <br> |CASE 3
     * <br> +----------------
     * <br> |TIPO VAR_ARREGLO 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_3(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    
//    public void tomandoValores(elementoEntorno entorno){
//        
//        simbolo.salidaDasm.get_local(0, entorno.nivel);
//        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa), "Posición relativa", entorno.nivel);
//        entorno.posRelativa++;//incrementando la posicion relativa para la proxima variable 
//        simbolo.salidaDasm.add("Sumando para encontrar el valor real", entorno.nivel);
//    }
     
}
