/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;
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
    STRING          ::= tString sAbreParent LST_VALOR sCierraParent;
 */
 
public class _STRING extends nodoModelo{
    
    /**
     * constructor de _STRING
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _STRING(itemAtributo atrib, elementoGlobal simbolo) {
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
     *<br> String (posición en X, posición en Y, color, Cadena);


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
         
         
         if(lstValores.size() == 4 ){
             itemValor valPosX =lstValores.get(0);
             itemValor valPosY = lstValores.get(1);
             itemValor valColor=lstValores.get(2);
             itemValor valCadena=lstValores.get(3);
             
             
             //Validando los tipos de datos
             Object oPosX=valPosX.getParseadoNumero(atributo);
             Object oPosY=valPosY.getParseadoNumero(atributo);
             Object oColor=valColor.getParseadoCadena(atributo);
             Object oCadena=valCadena.getParseadoCadena(atributo);
             
             if(oPosX==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El primer parámetro, PosX debe de ser de tipo número no de tipo :"+valPosX.tipo);               
                return retorno;
             }
             if(oPosY==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El segundo parámetro, PosY debe de ser de tipo número no de tipo :"+valPosY.tipo);               
                return retorno;
             }
             if(oColor==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El tercer parámetro, Color debe de ser de tipo cadena no de tipo :"+valColor.tipo);               
                return retorno;
             }
             if(oCadena==null){
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El cuarto parámetro, Cadena debe de ser de tipo cadena no de tipo :"+valCadena.tipo);               
                return retorno;
             }
             
             int pPosX=(int)(double)oPosX;
             int pPosY=(int)(double)oPosY;
             String pColor=(String)oColor;
             String pCadena=(String)oCadena;
             
             if(pPosX>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosX supera el límite del lienzo (500) PosX:"+String.valueOf(pPosX));               
                return retorno;
             }
             
             if(pPosY>=500){ 
                simbolo.tablaErrores.insertErrorSemantic(atributo, "El parámetro PosY supera el límite del lienzo (500) PosY:"+String.valueOf(pPosX));               
                return retorno;
             }
             simbolo.ctrlLienzo.pintarString(pPosX, pPosY, pColor, pCadena);
             return retorno;
         }else{
             //error
             simbolo.tablaErrores.insertErrorSemantic(atributo, "No se recibieron 4 parámetros para String (posición en X, posición en Y, color, Cadena);");               
             return retorno;
             
         } 
    }
}
