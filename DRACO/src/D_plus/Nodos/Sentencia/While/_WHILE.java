/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.Sentencia.While;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.CuerpoRelativo._LST_CUERPO;
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
WHILE       ::=tMientras  sAbreParent  VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
            ;

 */
public class _WHILE extends nodoModelo{
    
    public _WHILE(itemAtributo atrib, elementoGlobal simbolo) {
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
         //creando el nuevo entorno
        elementoEntorno entornoWhile=new elementoEntorno(entorno, "while", simbolo, entorno.nivel+1, entorno.funciones);
        
        
        //recuperar el valor de E
        _VALOR nodoE =(_VALOR)listaHijos.lstHijos.get(0);
        itemValor valE=nodoE.getValor(entorno);
        
        //validando si es booleano el valor que devuelve
        if(!valE.isTypeBooleano()){
            simbolo.tablaErrores.insertErrorSemantic(atributo, "La condicion para el while tiene que ser de tipo booleano no de tipo: "+valE.tipo);
            return retorno;
        }
        
        
        simbolo.salidaDasm.comentarioPequeño("Mientras", "Sentencia mientras", entorno.nivel);
        simbolo.salidaDasm.comentario("CONDICION:", entorno.nivel);
        
        
        String etiquetaCondicion = "$e_while_condicion"+entornoWhile.idSentencia;
        String etiquetaFalso="$e_while_falso"+entornoWhile.idSentencia;
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(etiquetaCondicion, "Etiqueta condicion", entorno.nivel);
        
        for (String string : valE.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        //creando la condicion
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBrIf(etiquetaFalso), "Etiqueta para salir del while", entorno.nivel);
        
        
        //pero sigo con el conteo de las posiciones de las variables
        entornoWhile.posRelativa=entorno.posRelativa;
        
        _LST_CUERPO nodoCuerpo=(_LST_CUERPO)listaHijos.lstHijos.get(1);
        nodoCuerpo.ejecutar(entornoWhile);
        
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getBr(etiquetaCondicion), "Evaluando nuevamente la condicion", entornoWhile.nivel);
        
        //creando la etiqueta salida
        simbolo.salidaDasm.lineaComentada(etiquetaFalso, "Etiqueta de salida para el valor falso", entorno.nivel);
         
        return retorno;
    }

}
