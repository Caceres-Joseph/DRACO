/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionesNativas;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.Parametros._LST_VAL;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
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
LINEA                   ::= tLinea  sAbreParent  LST_VAL  sCierraParent
 */
public class _LINEA extends nodoModelo{
    
    public _LINEA(itemAtributo atrib, elementoGlobal simbolo) {
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
        
        
        _LST_VAL nodoLstValores= (_LST_VAL)listaHijos.lstHijos.get(0);
         ArrayList<itemValor> lstValores= nodoLstValores.getLstValores(entorno);
         
         if(lstValores.size() == 6 ){
             
             itemValor valPosXi =lstValores.get(0);
             itemValor valPosYi = lstValores.get(1);
             itemValor valPosXf=lstValores.get(2);
             itemValor valPosYf=lstValores.get(3);
             itemValor valColor=lstValores.get(4);
             itemValor valGrosor=lstValores.get(5);
             
             //validando los tipos de parametros
             if(!valPosXi.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El primer parámetro, PosXi debe de ser de tipo número no de tipo :"+valPosXi.tipo);               
                return retorno;
             }else if(!valPosYi.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El segundo parámetro, PosYi debe de ser de tipo número no de tipo :"+valPosYi.tipo);               
                return retorno; 
             }else if(!valPosXf.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El tercer parámetro, PosXf debe de ser de tipo número no de tipo :"+valPosXf.tipo);               
                return retorno;
                 
             }else if(!valPosYf.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El cuarto parámetro, PosYf debe de ser de tipo número no de tipo :"+valPosYf.tipo);               
                return retorno;
                 
             }else if(!valColor.isTypeCadena()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El quinto parámetro, Color debe de ser de tipo cadena no de tipo :"+valColor.tipo);               
                return retorno;
                 
             }
             else if(!valGrosor.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El sexto parámetro, oGrosor debe de ser de tipo número no de tipo :"+valGrosor.tipo);               
                return retorno; 
             }
             
             
             
             simbolo.salidaDasm.comentarioPequeño("LINEA","Pintando una linea", entorno.nivel);
             
             /*COLOCANDO valPosXi*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosXi", entorno.nivel);
             for (String string : valPosXi.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             /*COLOCANDO valPosYi*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosYi", entorno.nivel);
             for (String string : valPosYi.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             /*COLOCANDO valPosXf*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosXf", entorno.nivel);
             for (String string : valPosXf.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             /*COLOCANDO valPosYf*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosYf", entorno.nivel);
             for (String string : valPosYf.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             /*COLOCANDO valColor*/
             //convirtiendo de hexaecial a tipo entero
             
            String hexNumber = valColor.getCadena(); 
            hexNumber= hexNumber.replace("#",""); 
            int decimal = Integer.parseInt(hexNumber, 16); 
            simbolo.salidaDasm.lineaComentada(String.valueOf(decimal), "PARAMETRO: valColor", entorno.nivel);
             
             
             /*COLOCANDO valGrosor*/
             simbolo.salidaDasm.comentario("PARAMETRO: valGrosor", entorno.nivel);
             for (String string : valGrosor.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$Line"), "Pintando la linea", entorno.nivel);
              
             return retorno;
         }else{
             //error
             simbolo.tablaErrores.insertErrorSemantic(atributo, "No se recibieron 6 parámetros para Line (posición en Xi, posición en Yi, posición Xf, posición Yf, color, grosor );");               
             return retorno;
             
         } 
         
          
    }
    
}
