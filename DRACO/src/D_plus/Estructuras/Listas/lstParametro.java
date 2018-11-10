/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemParametro;
import D_plus.Estructuras.Items.itemValor;
import Gui.Elementos.elementoGlobal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class lstParametro {
    
    public Map<String, itemParametro> listaParametros ;
    public elementoGlobal simbolo;
    
    
    
    
    public lstParametro(elementoGlobal simbolo){
        this.simbolo=simbolo;
        listaParametros =new LinkedHashMap<>(); 
    }
     
    public void insertar(itemParametro nuevoParametro){
        
        if(listaParametros.containsKey(nuevoParametro.nombre.valor))
        //Ya existe un parametro con el mismo nombre
        {
            simbolo.tablaErrores.insertErrorSemantic(nuevoParametro.nombre, "Ya se encuentra un parámetro con el mismo nombre :"+nuevoParametro.nombre.valor);
        }else
        //Procedemos a insertar el nuevo parámetro
        {
            listaParametros.put(nuevoParametro.nombre.valor, nuevoParametro); 
        }
    }
     
    public void imprimir(){
        
        Iterator k = listaParametros.keySet().iterator();
        println("[--- Imprimiendo la lista parametros---]");
        while (k.hasNext()) {
          
          String key= (String) k.next();
          itemParametro val=(itemParametro) listaParametros.get(key);
          
          println("Param:"+key);
          val.imprimir();
        }
         System.out.println("");
        
    }
    
    public void println(String mensaje){
        System.out.println("[lstParametro]"+mensaje);
    }

    public String getCadena_parametros() {
        String retorno = "";
        Iterator k = listaParametros.keySet().iterator();
        while (k.hasNext()) {
            String key = (String) k.next();

            if (retorno.equals("")) {
                retorno += listaParametros.get(key).tipo.valor + " " + key;
            } else {
                retorno += "," + listaParametros.get(key).tipo.valor + " " + key;
            }

        }

        return retorno;
    }

    /**
     * Por el momento seran parametros de tipo primitivo
     * @param entornoMain para controlar el numero de la variables
     * @return 
     */
    public ArrayList<String> getCodigoParametros(elementoEntorno entornoMain) {
        //hay que llenar el codigo de los parametros
        ArrayList<String> cadenaDasm=new ArrayList<>();
        
        Iterator k = listaParametros.keySet().iterator();
        
        int numParams=0;
        while (k.hasNext()) {
            String key = (String) k.next();
            itemParametro val = (itemParametro) listaParametros.get(key);
            switch (val.tipo.valor) {
                case "numero":
                    cadenaDasm.addAll(parametroNumero(key, val, entornoMain.posRelativa++, entornoMain));
                    numParams++;
                    break;
                case "caracter":
                    cadenaDasm.addAll(parametroNumero(key, val, entornoMain.posRelativa++, entornoMain));
                    numParams++;
                    break;
                case "cadena":
                    cadenaDasm.addAll(parametroNumero(key, val, entornoMain.posRelativa++, entornoMain));
                    numParams++;
                    break;
                case "booleano":
                    cadenaDasm.addAll(parametroNumero(key, val, entornoMain.posRelativa++, entornoMain));
                    numParams++;
                    break;
                default:
                    cadenaDasm.addAll(parametroNumero(key, val, entornoMain.posRelativa++, entornoMain));
                    numParams++;
//                    println("[getCodigoParametros]es una estructura");
                //tiene que ser una estructura
                    break;
            }
        }
        
        cadenaDasm.add("");
        for (int i = 0; i < numParams; i++) {
            //recuperando el valor de la pila
            cadenaDasm.add(simbolo.salidaDasm.getSet_local_calc());
        }
        return cadenaDasm;
    }
    
    public String parteNombreFuncion(){
        String retorno = "";
        Iterator k = listaParametros.keySet().iterator();
        while (k.hasNext()) {
            String key = (String) k.next();

            if (retorno.equals("")) {
                retorno +="_"+ listaParametros.get(key).tipo.valor+listaParametros.get(key).dimension;
            } else {
                retorno += "_" + listaParametros.get(key).tipo.valor+listaParametros.get(key).dimension;
            } 
        }
        return retorno;
    }
    
    private ArrayList<String> parametroNumero(String key, itemParametro val, int numParametro, elementoEntorno entorno){
        ArrayList<String> retorno=new ArrayList<>();
        
        /*CODIGO DASM*/
        //Obteniendo puntero
        retorno.add("//PARAMETRO: "+val.tipo.valor+" "+ key);
        retorno.add(simbolo.salidaDasm.getGet_local_id("0"));
        //numero de parametro
        retorno.add(String.valueOf(numParametro));
        //sumando
        retorno.add(simbolo.salidaDasm.getAdd());
        //valor temporal
        retorno.add("0");
        //guardando el temporal
        retorno.add(simbolo.salidaDasm.getSet_local_calc());
        
        
        /*GUARDANDO LA VARIABLE EN LA TABLA DE SIMBOLOS*/  
        //Valor Temporal que es nulo
        itemValor tempVal=new itemValor(simbolo);
        //asingando el tipo del parametro
        tempVal.tipo=val.tipo.valor;
        //guardando la variable
        entorno.lstVariables.insertarVariable(val.nombre, tempVal, val.tipo.valor, val.dimension, numParametro, entorno.nombre);
        
        return retorno;
    }
}
