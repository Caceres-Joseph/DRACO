/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Sentencia.Si;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno; 
import D_plus.Nodos.CuerpoRelativo._LST_CUERPO; 
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

SINO    ::= tSino  sAbreLlave  LST_CUERPO  sCierraLlave
        ;
 */
public class _SINO extends nodoModelo{
    
    public _SINO(itemAtributo atrib, elementoGlobal simbolo) {
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
        itemRetorno retorno = new itemRetorno();
         
        
       
        
         //cuerpo del if
        simbolo.salidaDasm.comentario("CUERPO IF FALSO:", entorno.nivel);
       
        //creando el nuevo entorno
        elementoEntorno entornoIF=new elementoEntorno(entorno, "if_falso", simbolo, entorno.nivel+1, entorno.funciones);
        //pero sigo con el conteo de las posiciones de las variables
        entornoIF.posRelativa=entorno.posRelativa;
        
        _LST_CUERPO nodoCuerpo=(_LST_CUERPO)listaHijos.lstHijos.get(0);
        nodoCuerpo.ejecutar(entornoIF);
        
        return retorno;
        

    }

    
    
    
}
