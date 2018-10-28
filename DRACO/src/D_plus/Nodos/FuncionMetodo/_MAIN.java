/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionMetodo;

import D_plus.Estructuras.Elementos.elementoClase;
import D_plus.Estructuras.Items.itemRetorno;
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
MAIN                ::= TIPO tPrincipal sAbreParent  sCierraParent sAbreLlave  LST_CUERPO  sCierraLlave
                    |   tPrincipal sAbreParent  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave              
                    ;
 */
public class _MAIN extends nodoModelo{
    
    public _MAIN(itemAtributo atrib, elementoGlobal simbolo) {
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
        
         
        itemAtributo nombre= new itemAtributo("principal","principal", atributo.columna,atributo.linea, atributo.nombreArchivo);
        itemAtributo tipo= new itemAtributo("vacio","vacio", atributo.columna,atributo.linea, atributo.nombreArchivo);
        
        switch(atributo.nivelProduccion){
            case 0:
                /**
                 * TIPO tPrincipal sAbreParent  sCierraParent sAbreLlave  LST_CUERPO  sCierraLlave
                 */
                
                valorPolimorfo valor;
                valor=new valorPolimorfo(new lstParametro(simbolo),nombre ,tipo, 0, listaHijos.lstHijos.get(1));
                clavePolimorfa clave=new clavePolimorfa(new lstParametro(simbolo), nombre);
                
                
                if(clase.listaPrincipal.listaMain.containsKey(clave)){
                    //error por que ya existe
                    //simbolo.tablaErrores.insertErrorSemantic(atributo,"El metodo: "+clave.nombre.valor+" ya se encuentra declarado con los mismos parametros y el mismo nombre");
                }else{
                    clase.listaPrincipal.listaMain.insertar(clave, valor);
                } 
                break; 
            case 1: 
                /**
                 * tPrincipal sAbreParent  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  
                 */
                
                valorPolimorfo valor2;
                valor2=new valorPolimorfo(new lstParametro(simbolo),nombre ,tipo, 0, listaHijos.lstHijos.get(0));
                clavePolimorfa clave2=new clavePolimorfa(new lstParametro(simbolo), nombre);
                
                
                if(clase.listaPrincipal.listaMain.containsKey(clave2)){
                    //error por que ya existe
                    //simbolo.tablaErrores.insertErrorSemantic(atributo,"El metodo: "+clave.nombre.valor+" ya se encuentra declarado con los mismos parametros y el mismo nombre");
                }else{
                    clase.listaPrincipal.listaMain.insertar(clave2, valor2);
                }  
                break;
        }
        
    }
}
