/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.AsignarValor._LST_VALOR;
import DracoScript.Nodos.nodoModelo;
import java.util.ArrayList;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
    LINE            ::= tLine sAbreParent LST_VALOR sCierraParent;
 */
 
public class _LINE extends nodoModelo{
    
    /**
     * constructor de _LINE
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _LINE(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
     
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     *<br> Metodo de ejecución final
     *<br> Point (posición en X, posición en Y, color, Diámetro);
     *<br> Line (posición en Xi, posición en Yi, posición Xf, posición Yf, color, grosor )

     * @param entorno Es la tabla que contiene las variables
     * @return
     */
    
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno) { 
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;
        validandoDebug();
        
        
         _LST_VALOR nodoLstValores= (_LST_VALOR)listaHijos.lstHijos.get(0);
         ArrayList<itemValor> lstValores= nodoLstValores.getLstValores(entorno);
         
         
         if(lstValores.size() == 6 ){
             itemValor valPosXi =lstValores.get(0);
             itemValor valPosYi = lstValores.get(1);
             itemValor valPosXf=lstValores.get(2);
             itemValor valPosYf=lstValores.get(3);
             itemValor valColor=lstValores.get(4);
             itemValor valGrosor=lstValores.get(5);
             
             
             //Validando los tipos de datos
             Object oPosXi=valPosXi.getParseadoNumero(atributo);
             Object oPosYi=valPosYi.getParseadoNumero(atributo); 
             Object oPosXf=valPosXf.getParseadoNumero(atributo);
             Object oPosYf=valPosYf.getParseadoNumero(atributo);
             Object oColor=valColor.getParseadoCadena(atributo); 
             Object oGrosor=valGrosor.getParseadoNumero(atributo);
             
             
             if(oPosXi==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El primer parámetro, PosXi debe de ser de tipo número no de tipo :"+valPosXi.tipo);               
                return retorno;
             }
             if(oPosYi==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El segundo parámetro, PosYi debe de ser de tipo número no de tipo :"+valPosYi.tipo);               
                return retorno;
             }
             if(oPosXf==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El primer parámetro, PosXf debe de ser de tipo número no de tipo :"+valPosXf.tipo);               
                return retorno;
             }
             if(oPosYf==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El segundo parámetro, PosYf debe de ser de tipo número no de tipo :"+valPosYf.tipo);               
                return retorno;
             }
             if(oColor==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El tercer parámetro, Color debe de ser de tipo cadena no de tipo :"+valColor.tipo);               
                return retorno;
             }
             if(oGrosor==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El quinto parámetro, oGrosor debe de ser de tipo número no de tipo :"+valGrosor.tipo);               
                return retorno;
             }
             
           
             
             int pPosXi=(int)(double)oPosXi;
             int pPosYi=(int)(double)oPosYi;
             int pPosXf=(int)(double)oPosXf;
             int pPosYf=(int)(double)oPosYf;
             String pColor=(String)oColor;
             int pGrosor=(int)(double)oGrosor;
             
             
             
             if(pPosXi>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosXi supera el límite del lienzo (500) PosX:"+String.valueOf(pPosXi));               
                return retorno;
             }
             if(pPosXf>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosXf supera el límite del lienzo (500) PosX:"+String.valueOf(pPosXf));               
                return retorno;
             }
             
             if(pPosYi>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosYi supera el límite del lienzo (500) PosY:"+String.valueOf(pPosYi));               
                return retorno;
             }
             
             if(pPosYf>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosYf supera el límite del lienzo (500) PosY:"+String.valueOf(pPosYf));               
                return retorno;
             }
             
             simbolo.ctrlLienzo.pintarLinea(pPosXi, pPosYi, pPosXf, pPosYf, pColor, pGrosor); 
             return retorno;
         }else{
             //error
             simbolo.tablaErrores.insertErrorSemantic(atributo, "No se recibieron 6 parámetros para Line (posición en Xi, posición en Yi, posición Xf, posición Yf, color, grosor );");               
             return retorno;
             
         } 
    }
}
