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

OVALO                   ::= tOvalo  sAbreParent  LST_VAL  sCierraParent
 */
public class _OVALO extends nodoModelo{
    
    public _OVALO(itemAtributo atrib, elementoGlobal simbolo) {
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
         
         
         
         if(lstValores.size() == 5 ){
             itemValor valPosX =lstValores.get(0);
             itemValor valPosY = lstValores.get(1);
             itemValor valColor=lstValores.get(2);
             itemValor valAncho=lstValores.get(3);
             itemValor valAlto=lstValores.get(4);
             
             //validando los tipos de parametros
             if(!valPosX.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El primer parámetro, valPosX debe de ser de tipo número no de tipo :"+valPosX.tipo);               
                return retorno;
             }else if(!valPosY.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El segundo parámetro, valPosY debe de ser de tipo número no de tipo :"+valPosY.tipo);               
                return retorno; 
             }else if(!valColor.isTypeCadena()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El tercer parámetro, Color debe de ser de tipo cadena no de tipo :"+valColor.tipo);               
                return retorno; 
             }
             else if(!valAncho.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El cuarto parámetro, valAncho debe de ser de tipo número no de tipo :"+valAncho.tipo);               
                return retorno; 
             }
             else if(!valAlto.isTypeNumero()){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El quinto parámetro, valAlto debe de ser de tipo número no de tipo :"+valAlto.tipo);               
                return retorno; 
             }
             
             
             
             simbolo.salidaDasm.comentarioPequeño("OVALO","Pintando un ovalo", entorno.nivel);
             
             /*COLOCANDO valPosX*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosX", entorno.nivel);
             for (String string : valPosX.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             /*COLOCANDO valPosY*/
             simbolo.salidaDasm.comentario("PARAMETRO: valPosY", entorno.nivel);
             for (String string : valPosY.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
         
             
             /*COLOCANDO valColor*/
             //convirtiendo de hexaecial a tipo entero
             
            String hexNumber = valColor.getCadena(); 
            hexNumber= hexNumber.replace("#",""); 
            int decimal = Integer.parseInt(hexNumber, 16); 
            simbolo.salidaDasm.lineaComentada(String.valueOf(decimal), "PARAMETRO: valColor", entorno.nivel);
             
            
             /*COLOCANDO valAncho*/
             simbolo.salidaDasm.comentario("PARAMETRO: valAncho", entorno.nivel);
             for (String string : valAncho.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             
             /*COLOCANDO valAlto*/
             simbolo.salidaDasm.comentario("PARAMETRO: valAlto", entorno.nivel);
             for (String string : valAlto.cadenaDasm) {
                 simbolo.salidaDasm.linea(string, entorno.nivel);
             }
             
             simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$Oval"), "Pintando el ovalo", entorno.nivel);
              
             return retorno;
         }else{
             //error
             simbolo.tablaErrores.insertErrorSemantic(atributo, "No se recibieron 5 parámetros para  Oval (posición en X, posición en Y, color, Ancho, Alto);");               
             return retorno;
         }  
    }
    
    
}
