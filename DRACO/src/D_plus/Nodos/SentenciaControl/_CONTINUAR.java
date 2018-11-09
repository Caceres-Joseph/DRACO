/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.SentenciaControl;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
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

CONTINUAR           ::=tContinuar  sPuntoComa
                    ; 
 */
public class _CONTINUAR extends nodoModelo {
    
    public _CONTINUAR(itemAtributo atrib, elementoGlobal simbolo) {
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
        //tengo que ir en busca de un entorno que se llame while o for y recuperar su nivel
        
        buscarEntorno(entorno, entorno.nivel);
        return retorno;
    }
    
     
    /**
     * Recuperando el valor de la variable
     * @param entorno El entorno que estoy buscando
     * @param nivelActual Nivel del metodo
     */
    
    public void buscarEntorno(elementoEntorno entorno, int nivelActual){
         
        
        //buscando un ciclo
        if(entorno.nombre.equals("while")){ 
            String etiquetaSalidaCiclo="$e_while_condicion"+String.valueOf(entorno.nivel-1);
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaSalidaCiclo), "CONTINUE:", nivelActual);
        
        }else if(entorno.nombre.equals("for")){
            String etiquetaSalidaCiclo="$e_incremento_for"+String.valueOf(entorno.nivel-1);
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaSalidaCiclo), "CONTINUE:", nivelActual);
        
        }else{
            
             if(entorno.anterior!=null){
                 buscarEntorno(entorno.anterior, nivelActual);
             }else{ 
                 simbolo.tablaErrores.insertErrorSemantic(atributo, "La sentencia denter solo puede venir dentro de un ciclo");
                 //no se encontro dentro de un cilco erro prro
             }
        }
        
    }
     
}
