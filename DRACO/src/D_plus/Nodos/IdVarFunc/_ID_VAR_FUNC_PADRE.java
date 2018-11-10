/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.IdVarFunc;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.itemClave;
import D_plus.Nodos.Parametros._LST_VAL;
import Gui.Items.itemAtributo; 
import Gui.Elementos.elementoGlobal;  
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class _ID_VAR_FUNC_PADRE extends _ID_VAR_FUNC_PADRE2{
    
    public _ID_VAR_FUNC_PADRE(itemAtributo atrib, elementoGlobal simbolo) {
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
    
    
    public itemRetorno casos(elementoEntorno entorno){
        itemRetorno retorno=new itemRetorno();
          
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno);
            case 2:
                return case_2(entorno);
            case 3:
                return case_3(entorno);
            case 4:
                return case_4(entorno);
            case 5:
                return case_5(entorno);
            case 6:
                return case_6(entorno);
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        } 
        
         
    }
    
    /**
     * <br> +----------------
     * <br> | ID_VAR_FUNC  LST_PUNTOSP
     * <br> +----------------
     * <br> |DECLARAR_VARIABLE sComa VAR_ARREGLO
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    /**
     * <br> +----------------
     * <br> |valId  
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();

       

        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId  sAbreParent  LST_VAL  sCierraParent
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_2(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();

        //aqui hago el llamado a funciones que pueden o no retornar valores
        //revisando si el metodo existe
        //crando una clave polimorfa
        //obteniendo los parametros
        _LST_VAL nodoLstValores=(_LST_VAL)listaHijos.lstHijos.get(0);
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>();
        
        for (itemValor lstValore : nodoLstValores.getLstValores(entorno)) {
            itemClave nuevaClave=new itemClave(lstValore.tipo, lstValore.dimension); 
            listaTipos.add(nuevaClave);
        }
        
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion);
        
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){
            
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        
        
        simbolo.salidaDasm.comentarioPequeño(nombreFuncion.valor +"("+clave.getListaTiposString()+")","Llamado a metodo", entorno.nivel);
        /*CODIGO DASM*/
        int numParametro=1;
        for (itemValor lstValor : nodoLstValores.getLstValores(entorno)) {
            
            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Colocando parametro:"+lstValor.tipo, entorno.nivel);
            //tamaño del ambito
            simbolo.salidaDasm.linea(String.valueOf(entorno.posRelativa-1), entorno.nivel);
            //sumanodo
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
            //Num parametro
            simbolo.salidaDasm.linea(String.valueOf(numParametro++), entorno.nivel);
            //sumando
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
            
            simbolo.salidaDasm.comentario("Operaciones E", entorno.nivel);
            for (String string : lstValor.cadenaDasm) {
                //Ubicndo todo lo que viene en E 
                simbolo.salidaDasm.linea(string,entorno.nivel);
            }
        }
        //comentarios
        simbolo.salidaDasm.linea("", numParametro);
        simbolo.salidaDasm.comentario("Iniciando llamado", entorno.nivel);
        //obtengo el puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Cambiando de ambito", entorno.nivel);
        //tamanio del ambito para avanzar
        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa - 1), "Tam de ambito", entorno.nivel);
        //sumando
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
        //actualizando puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_id("0"), "actualizando puntero", entorno.nivel);
        //llamando a la funcion prro
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$"+clave.nombre.valor+clave.getParamsNombreFunc()), "Llamado al metodo", entorno.nivel);
        //obtengo el puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Cambiando de ambito", entorno.nivel);
        
        //tamanio del ambito para regresar
        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa - 1), "Tam de ambito", entorno.nivel);
        //resto
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getDiff(), entorno.nivel);
        //actualizando puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_id("0"), "actualizando puntero", entorno.nivel);
        
         return retorno;
    }
    
    public ArrayList<String> cadenaDasm_case2(elementoEntorno entorno){
        ArrayList<String> retorno=new ArrayList<>(); 
      
        //aqui hago el llamado a funciones que pueden o no retornar valores
        //revisando si el metodo existe
        //crando una clave polimorfa
        //obteniendo los parametros
        _LST_VAL nodoLstValores=(_LST_VAL)listaHijos.lstHijos.get(0);
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>();
        
        for (itemValor lstValore : nodoLstValores.getLstValores(entorno)) {
            itemClave nuevaClave=new itemClave(lstValore.tipo, lstValore.dimension); 
            listaTipos.add(nuevaClave);
        }
        
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion);
        
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){
            
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        
        retorno.add(("//"+nombreFuncion.valor +"("+clave.getListaTiposString()+")"));
        retorno.add("//Llamado a metodo");
        /*CODIGO DASM*/
        int numParametro=1;
        for (itemValor lstValor : nodoLstValores.getLstValores(entorno)) {
            
            retorno.add("//Colocando parametro:"+lstValor.tipo);
            retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
            //tamaño del ambito
            retorno.add(String.valueOf(entorno.posRelativa-1));
            //sumanodo
            retorno.add(simbolo.salidaDasm.getAdd());
            //Num parametro
            retorno.add(String.valueOf(numParametro++));
            //sumando
            retorno.add(simbolo.salidaDasm.getAdd());
            
            retorno.add("//Operaciones E");
            for (String string : lstValor.cadenaDasm) {
                //Ubicndo todo lo que viene en E 
                retorno.add(string);
            }
        }
        //comentarios
        retorno.add("");
        retorno.add("//Iniciando llamado");
        //obtengo el puntero
        retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
        //tamanio del ambito para avanzar
        retorno.add(String.valueOf(entorno.posRelativa - 1));
        //sumando
        retorno.add(simbolo.salidaDasm.getAdd());
        //actualizando puntero
        retorno.add(simbolo.salidaDasm.getSet_local_id("0"));
        //llamando a la funcion prro
        retorno.add(simbolo.salidaDasm.getCall("$"+clave.nombre.valor+clave.getParamsNombreFunc()));
        //obtengo el puntero
        retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
        
        //tamanio del ambito para regresar
        retorno.add(String.valueOf(entorno.posRelativa - 1));
        //resto
        retorno.add(simbolo.salidaDasm.getDiff());
        //actualizando puntero
        retorno.add(simbolo.salidaDasm.getSet_local_id("0"));
           
        return retorno;
    }
    /**
     * <br> +----------------
     * <br> |valId sAbreParent           sCierraParent
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_3(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
        //inicio de nombre
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>(); 
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion); 
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){ 
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        simbolo.salidaDasm.comentarioPequeño( nombreFuncion.valor +"("+clave.getListaTiposString()+")","Llamado a metodo", entorno.nivel);
        
        /*CODIGO DASM*/
        //obtengo el puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Cambiando de ambito", entorno.nivel);
        //tamanio del ambito para avanzar
        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa - 1), "Tam de ambito", entorno.nivel);
        //sumando
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
        //actualizando puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_id("0"), "actualizando puntero", entorno.nivel);
        //llamando a la funcion prro
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$"+clave.nombre.valor+clave.getParamsNombreFunc()), "Llamado al metodo", entorno.nivel);
        //obtengo el puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Cambiando de ambito", entorno.nivel);
        
        //tamanio del ambito para regresar
        simbolo.salidaDasm.lineaComentada(String.valueOf(entorno.posRelativa - 1), "Tam de ambito", entorno.nivel);
        //resto
        simbolo.salidaDasm.linea(simbolo.salidaDasm.getDiff(), entorno.nivel);
        //actualizando puntero
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getSet_local_id("0"), "actualizando puntero", entorno.nivel);
        
        return retorno;
    }
    
    
    public ArrayList<String> cadenaDasm_case3(elementoEntorno entorno){
        ArrayList<String> retorno=new ArrayList<>(); 
        
        
        //inicio de nombre
        itemAtributo nombreFuncion=listaAtributos.getAtributo(0);
        
        /*VALIDANDO SI LA FUNCION EXISTE*/
        ArrayList<itemClave> listaTipos=new ArrayList<>(); 
        clavePolimorfa clave=new clavePolimorfa(listaTipos, nombreFuncion); 
        if(!entorno.funciones.listaMetodoFuncion.listaMetodoFuncion.containsKey(clave)){ 
            simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
            return retorno;
        }
        retorno.add("//Llamado a metodo");
        
        /*CODIGO DASM*/
        //obtengo el puntero
        retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
        //tamanio del ambito para avanzar
        retorno.add(String.valueOf(entorno.posRelativa - 1));
        //sumando
        retorno.add(simbolo.salidaDasm.getAdd());
        //actualizando puntero
        retorno.add(simbolo.salidaDasm.getSet_local_id("0"));
        //llamando a la funcion prro
        retorno.add(simbolo.salidaDasm.getCall("$"+clave.nombre.valor+clave.getParamsNombreFunc()));
        //obtengo el puntero
        retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
        
        //tamanio del ambito para regresar
        retorno.add(String.valueOf(entorno.posRelativa - 1));
        //resto
        retorno.add(simbolo.salidaDasm.getDiff());
        //actualizando puntero
        retorno.add(simbolo.salidaDasm.getSet_local_id("0"));
        
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  LST_CORCHETES_VAL:h1
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_4(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  sAbreParent  LST_VAL:h1  sCierraParent  LST_CORCHETES_VAL:h2
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_5(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
    
    /**
     * <br> +----------------
     * <br> |valId:d1  sAbreParent           sCierraParent  LST_CORCHETES_VAL:h1
     * <br> +----------------
     * <br> | 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_6(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 

       
        return retorno;
    }
    
}
