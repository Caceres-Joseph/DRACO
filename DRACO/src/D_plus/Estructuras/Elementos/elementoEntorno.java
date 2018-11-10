/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Elementos;

import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.lstVariables;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.Random;

/**
 *
 * @author joseph
 */
public class elementoEntorno {
     /**
     * Es el ambito anterior donde se encuentran las variables
     */
    public elementoEntorno anterior;
    public elementoGlobal simbolo;
    public String nombre;
    public lstVariables lstVariables ;
    public elementoClase funciones;
    
    
    /**
     * +--------------------------
     * | Para la traduccion
     * +-------------------------
     */
    
    public int posRelativa=1;
    public String idSentencia="";
    public String idSentencia2="";
    
    
    public void crearIdSentencia(){
        Random rand = new Random();
        int indice_salto_falso=rand.nextInt(1000);
       
        int indice_salto_falso2=rand.nextInt(10);
        idSentencia=String.valueOf(indice_salto_falso+indice_salto_falso);
    }
    
    //sirve para las tabulaciones y saber que tan adentro esta el codigo
    public int nivel=0;
    /**
     * 
     * @param anterior Es el nodo anterior para moverse al ambito
     * @param nombre Nombre del entorno
     * @param simbolo Simbolo que maneja la tabla de errores
     * @param nivel
     */
    public elementoEntorno(elementoEntorno anterior,String nombre, elementoGlobal simbolo, int nivel, elementoClase funciones){
        this.anterior=anterior;
        this.simbolo=simbolo;
        this.nombre=nombre;
        this.nivel=nivel;
        this.lstVariables=new lstVariables(simbolo);
        this.funciones=funciones;
        crearIdSentencia();
//        this.lstVariables=new lstValores(simbolo);
    }
    
     
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | OPERACIONES CON LA LISTA DE VARIABLES
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    
    /**
     * Recuperando el valor de la variable
     * @param atribNombreVar
     * @return 
     */
    public itemValor getValVariable(itemAtributo atribNombreVar){
         
         itemValor val= lstVariables._getValVariable(atribNombreVar);
         
         if(val==null){
             if(anterior!=null){
                 return anterior.getValVariable(atribNombreVar);
             }else{ 
                simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
                return new itemValor(simbolo);
             }
         }else{
             return val;
         } 
    }
    
    
    /**
     * Enviando el valor de la variable
     * @param atribNombreVar
     * @param valor El nuevo valor que va tomar la variable
     * @return 
     */
    public boolean setValVariable(itemAtributo atribNombreVar, itemValor valor){
           
         itemValor val= lstVariables._getValVariable(atribNombreVar);
         
         if(val==null){
             if(anterior!=null){
                 return anterior.setValVariable(atribNombreVar, valor);
             }else{ 
                simbolo.tablaErrores.insertErrorSemantic(atribNombreVar, "La variable "+ atribNombreVar.valor+ " no ha sido declarado, o no se encuentra en el ambito correcto");
                return false;
             }
         }else{
             lstVariables._setValVariable(atribNombreVar, valor);
             return true;
         }  
    }
}
