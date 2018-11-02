/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionMetodo;
import D_plus.Estructuras.Elementos.elementoClase; 
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import D_plus.Estructuras.Listas.lstParametro;
import D_plus.Nodos.Arreglo._VAR_ARREGLO;
import D_plus.Nodos.Inicio._TIPO;
import D_plus.Nodos.Parametros._LST_PARAMETROS;
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
METODO              ::= TIPO VAR_ARREGLO sAbreParent LST_PARAMETROS sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    |   TIPO VAR_ARREGLO sAbreParent  sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    ;
 */
public class _METODO extends nodoModelo{
    
    public _METODO(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | PRIMER PASADA
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    /**
     * Metodo para la primer pasada
     * @param clase Es la tabla que contiene las variables  
     */
    @Override
    public void primerPasada(elementoClase clase){
        
        
        if(hayErrores()){
            return ;
        }  
        casos(clase); 
        
        //listaHijos.primerPasada(clase);
    }
    
    public void casos(elementoClase clase){
        
        _TIPO tip=(_TIPO)listaHijos.lstHijos.get(0);
        _VAR_ARREGLO varArr=(_VAR_ARREGLO)listaHijos.lstHijos.get(1);
        
        
        itemAtributo nombre=varArr.getId();
        itemAtributo tipo= tip.getTipo();
        int dimension= varArr.getDimension();
        
//        println("id:"+nombre.valor+"| tipo:"+tipo.valor+"| dim:"+String.valueOf(dimension));
        
        switch(atributo.nivelProduccion){
            case 0:
                /**
                 * TIPO VAR_ARREGLO sAbreParent LST_PARAMETROS sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                 */
                _LST_PARAMETROS parametros=(_LST_PARAMETROS)listaHijos.lstHijos.get(2);
   
                valorPolimorfo valor;
                valor=new valorPolimorfo(parametros.getListaParametros(), tipo, nombre, dimension, listaHijos.lstHijos.get(3));
                clavePolimorfa clave=new clavePolimorfa(parametros.getListaParametros(), nombre);
                
                if(clase.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){
                    //error por que ya existe
                    simbolo.tablaErrores.insertErrorSemantic(atributo,"El metodo: "+clave.nombre.valor+" ya se encuentra declarado con los mismos parametros y el mismo nombre");
                
                }else{
                    clase.listaMetodoFuncion.listaMetodoFuncion.insertar(clave, valor);
                } 
                break; 
            case 1: 
                valorPolimorfo valor2;
                valor2=new valorPolimorfo(new lstParametro(simbolo), tipo, nombre, dimension, listaHijos.lstHijos.get(2));
//                println("imprimiendo");
//                valor2.imprimir();
                clavePolimorfa clave2=new clavePolimorfa(new lstParametro(simbolo), nombre);
//                 println("imprimir");
//                 clave2.imprimir();
                if(clase.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave2)){
                    //error por que ya existe 
                    simbolo.tablaErrores.insertErrorSemantic(atributo,"El metodo: "+clave2.nombre.valor+" ya se encuentra declarado con el mismo nombre");
                    
                }else{
                    clase.listaMetodoFuncion.listaMetodoFuncion.insertar(clave2, valor2);
                } 
                
                break;
        }
        
    }

}


    