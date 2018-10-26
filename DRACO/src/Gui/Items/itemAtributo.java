/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Items;

/**
 *Sirve para guardar los tokens
 * @author joseph
 */
public class itemAtributo {
    public int linea=-1;
    public int columna=-1;
    public String nombreToken="";
    public String nombreArchivo="";
    public String valor="";
    public String valLower="";
    
    
    /**
     * Sirve para los niveles del nodo, o para saber en que produccción estoy 
     */
    public int nivelProduccion=-1;
    
    
     /** 
      * @param nombreToken Es el nombre que tiene el token
      * @param valor Valor que se reconoce al momento de leer
      * @param columna La columna donde está ubicado el token
      * @param linea La linea donde esta ubicado el token
      * @param nombreArchivo El nombre del archivo del cual proviene el token
      */
    public itemAtributo (String nombreToken,  String valor, int columna,int linea, String nombreArchivo){
        
        
        this.linea=linea+1;
        this.columna=columna+1;
        this.nombreToken=nombreToken;
        this.nombreArchivo=nombreArchivo;
        this.valor=valor;
        this.valLower=valor.toLowerCase();
    }
    
    
     /**
      * Este contructor sirve para los nodos NO TERMINALES
      * @param nombreToken Es el nombre que tiene el token 
      * @param columna La columna donde está ubicado el token
      * @param linea La linea donde esta ubicado el token
      * @param nombreArchivo El nombre del archivo del cual proviene el token
      */
    public itemAtributo (String nombreToken, int columna,int linea, String nombreArchivo){
        
        this.linea=linea+1;
        this.columna=columna+1;
        this.nombreToken=nombreToken;
        this.nombreArchivo=nombreArchivo;
        this.valor="";
        this.valLower="";
    }
    
    
    
     /**
      * Este contructor sirve para los nodos NO TERMINALES al momento de crear los nodos
      * @param nombreToken Es el nombre que tiene el token  
      * @param nombreArchivo El nombre del archivo del cual proviene el token
     * @param nivelProduccion Es el nivel para diferenciar, en que producción me encuentro
      */
    public itemAtributo (String nombreToken, String nombreArchivo,int nivelProduccion){
        
        this.linea=-1;
        this.columna=-1;
        this.nombreToken=nombreToken;
        this.nombreArchivo=nombreArchivo;
        this.valor="";
        this.valLower="";
        this.nivelProduccion=nivelProduccion;
         
    }
    
     
    
    
    
    /**
     * Imprime el token actual
     */
    public void imprimir(){
        
        println("linea->"+String.valueOf(linea)); 
        println("columna->"+String.valueOf(columna)); 
        println("nombreToken->"+nombreToken); 
        println("nombreArchivo->"+nombreArchivo); 
        println("valor->"+valor);
        println("valor->"+valLower);
    }
    
    
    /**
     * @param mensaje Imprime el mensaje con el nombre de la clase para ubicarlo de forma fácil
     */
    
    public void println(String mensaje){
        System.out.println("\t[itemAtributo]"+mensaje);
    }
}
