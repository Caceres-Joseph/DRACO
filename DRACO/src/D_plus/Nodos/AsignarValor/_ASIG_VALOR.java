/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.AsignarValor;

import D_plus.Estructuras.Elementos.elementoEntorno; 
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Nodos.DeclararVariable._VAL;
import D_plus.Nodos.IdVarFunc._ID_VAR_FUNC;
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

ASIG_VALOR          ::= ID_VAR_FUNC  VAL
                    |   ID_VAR_FUNC  sMas  sMas
                    |   ID_VAR_FUNC  sMenos  sMenos
                    ;
 */
public class _ASIG_VALOR extends nodoModelo{
    
    public _ASIG_VALOR(itemAtributo atrib, elementoGlobal simbolo) {
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
          
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno);
            case 2:
                return case_2(entorno);
            
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        }  
    }
    
    
    
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC  VAL
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {

        itemRetorno reotorno = new itemRetorno();
        _ID_VAR_FUNC nodoVarFunc = (_ID_VAR_FUNC) listaHijos.lstHijos.get(0);
        _VAL nodoVal = (_VAL) listaHijos.lstHijos.get(1);

        itemValor valDestino = nodoVarFunc.getDireccionVal(entorno);
//        println("Pos Relativa:"+String.valueOf(valDestino.posRelativa));
//        println("Pos variable:"+String.valueOf(valDestino.posVarDpp));
//        println("Tipo var:"+valDestino.tipo);

        itemValor valValor = nodoVal.getValor(entorno);

//        if (valDestino.posVarDpp != -1) {
////            println("Es un aestructura");
//            if (valDestino.dimension == 0) {
//                if (valDestino.isTypeCadena()) {
//
//                    agregandoValElementoEstructuraNumero(valDestino, valValor, entorno);
//                    return reotorno;
//                } else {
//                    agregandoValElementoEstructuraNumero(valDestino, valValor, entorno);
//                    return reotorno;
//                }
//
//            } else {
//                //es un arreglo
//            }
//            return reotorno;
//        } else {
//            
//        }
        if (valDestino.miembroEstructura) {
            if (valDestino.dimension == 0) {
                if (valDestino.isTypeCadena()) {

                    agregandoValElementoEstructuraNumero(valDestino, valValor, entorno);
                    return reotorno;
                } else {
                    agregandoValElementoEstructuraNumero(valDestino, valValor, entorno);
                    return reotorno;
                }

            } else {
                //es un arreglo
            }
        }
        return asignarValor(valDestino, valValor, entorno);
 
    }
    
    public void agregandoValElementoEstructuraNumero(itemValor valDestino ,itemValor valValor, elementoEntorno entorno){
        
//        println(valDestino.nombreEntorno);
        
        
        if(valDestino.nombreEntorno.equals("global")){
            //pos del destino
            simbolo.salidaDasm.lineaComentada(String.valueOf(valDestino.posRelativa), "Posicion del destino", entorno.nivel);
            
        }else{
           
            simbolo.salidaDasm.comentarioPequeño("Asignando valor a estructura", "Elemento estructura", entorno.nivel);
            //puntero
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Obteniendo puntero", entorno.nivel);
            //pos del destino
            simbolo.salidaDasm.lineaComentada(String.valueOf(valDestino.posRelativa), "Posicion del destino", entorno.nivel);
            //sumando
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel); 
        }
        /*CODIGO DASM*/
        //Obteniendo puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_calc(), "Pos de puntero en heap", entorno.nivel);
        //lugar del elemento
        simbolo.salidaDasm.lineaComentada(String.valueOf(valDestino.posVarDpp), "pos de elemento en heap", entorno.nivel);
        //sumando
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel); 
        
        //Ubicndo todo lo que viene en E
        simbolo.salidaDasm.comentario("Operaciones E", entorno.nivel);
        for (String string : valValor.cadenaDasm) { 
            simbolo.salidaDasm.linea(string,entorno.nivel);
        }           
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_global_calc(), "Enviando el valor a la posicion", entorno.nivel);  
    }
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC  sMas  sMas
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) { 

        _ID_VAR_FUNC nodoVarFunc = (_ID_VAR_FUNC) listaHijos.lstHijos.get(0);
        

        itemValor valDestino = nodoVarFunc.getDireccionVal(entorno);
        itemValor valValor = nodoVarFunc.getValor(entorno);
        //aqui voy agregar el incremento
        //valor par aincrmentar
        valValor.cadenaDasm.add("1");
        //realizando la suma
        valValor.cadenaDasm.add(simbolo.salidaDasm.getAdd());

        return asignarValor(valDestino, valValor, entorno); 
    }
    
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC  sMenos  sMenos
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_2(elementoEntorno entorno) {
        _ID_VAR_FUNC nodoVarFunc = (_ID_VAR_FUNC) listaHijos.lstHijos.get(0);
        

        itemValor valDestino = nodoVarFunc.getDireccionVal(entorno);
        itemValor valValor = nodoVarFunc.getValor(entorno);
        //aqui voy agregar el incremento
        //valor par aincrmentar
        valValor.cadenaDasm.add("1");
        //realizando la suma
        valValor.cadenaDasm.add(simbolo.salidaDasm.getDiff());

        return asignarValor(valDestino, valValor, entorno); 
    }
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | FUNCIONES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    private itemRetorno asignarValor(itemValor valDestino ,itemValor valValor, elementoEntorno entorno){
        itemRetorno retorno = new itemRetorno();
   
        
        if (valValor.isTypeNulo()) {
            println("[case_0][ERROR]El valor destino es nulo");
        }else if(valDestino.dimension!=valValor.dimension){ 
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede asignar un valor  de dimension :" + valValor.dimension + " a una variable de dimension:" + valDestino.dimension);
            return retorno; 
        }else if (!valDestino.tipoSupremo.equals(valValor.tipo)) {
            simbolo.tablaErrores.insertErrorSemantic(atributo, "No se puede asignar un valor de tipo:" + valValor.tipo + " a una variable de tipo:" + valDestino.tipoSupremo);
            return retorno;
        }else {
            if (valDestino.esEstructura) {
                        parametroNumero(valDestino, valValor, entorno);
////                        println("[case_0]es una estructura");
            } else {
                switch (valDestino.tipoSupremo) {
                    case "numero": 
                        parametroNumero(valDestino, valValor, entorno);
                        break;
                    case "caracter":
                        parametroNumero(valDestino, valValor, entorno);
                        break;
                    case "cadena":
                        parametroNumero(valDestino, valValor, entorno); 
                        break;
                    case "booleano":
                        parametroNumero(valDestino, valValor, entorno); 
                        break;
                    default:
                        println("[case_00]es una estructura");
                        //tiene que ser una estructura
//                        parametroNumero(valDestino, valValor, entorno); 
                        break;
                }
            } 
        }  
        return retorno;
    }
    
    private void parametroNumero(itemValor valDestino ,itemValor valValor, elementoEntorno entorno){
        
//        println(valDestino.nombreEntorno);
        
        
        if(valDestino.nombreEntorno.equals("global")){
            //pos del destino
            simbolo.salidaDasm.lineaComentada(String.valueOf(valDestino.posRelativa), "Posicion del destino", entorno.nivel);
            
        }else{
           
            simbolo.salidaDasm.comentarioPequeño("Asignando valor a var", "", entorno.nivel);
            //puntero
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Obteniendo puntero", entorno.nivel);
            //pos del destino
            simbolo.salidaDasm.lineaComentada(String.valueOf(valDestino.posRelativa), "Posicion del destino", entorno.nivel);
            //sumando
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel); 
        }
        /*CODIGO DASM*/
        //Obteniendo puntero
        
        
        //Ubicndo todo lo que viene en E
        simbolo.salidaDasm.comentario("Operaciones E", entorno.nivel);
        for (String string : valValor.cadenaDasm) { 
            simbolo.salidaDasm.linea(string,entorno.nivel);
        }
           
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_calc(), "Enviando el valor a la posicion", entorno.nivel);
        
          
    }
    
    
}
