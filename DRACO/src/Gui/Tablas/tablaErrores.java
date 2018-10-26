/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Tablas;
 
import Gui.Elementos.elementoError;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import java.util.ArrayList; 
import java.util.List;

/**
 *
 * @author joseph
 */
public class tablaErrores {
    public List<elementoError> tablaError=new ArrayList<>(); 
    public elementoGlobal simbolo;
    
    public void clean(){
        tablaError=new ArrayList<>();
        simbolo.tbErrores.clean();
    }
    
    public tablaErrores(elementoGlobal simbolo){
        this.simbolo=simbolo;
    }
    public void insertar(elementoError nodo){
        tablaError.add(nodo);
    }
    
    
    public void println(Object str){
        String mensaje=String.valueOf(str);
        System.out.println(mensaje);
//        System.out.print("\n>");
    }
    
    
    public void print(Object str){
        String mensaje=String.valueOf(str);
        System.out.print(mensaje);
    }
    
    public void tablaGUI(elementoError elem){
//        simbolo.selectTabInferior(0); 
        simbolo.tbErrores.insertarError(elem);
    }
//    
    public void insertErrorSyntax(String ambito,int linea, int columna, String mensaje){
        elementoError elem=new elementoError();
        elem.ambito=ambito;
        elem.tipo="Sintactico";
        elem.linea=String.valueOf(linea+1);
        elem.columna=String.valueOf(columna+1);
        elem.descripcion=mensaje;
        
        this.tablaError.add(elem);
        tablaGUI(elem);
        println("[Error]Sintactico-> "+mensaje);
    }
//    
    public void insertErrorLexical(String ambito,int linea, int columna,String mensaje){
        elementoError elem=new elementoError();
        elem.ambito=ambito;
        elem.tipo="Lexico";
        elem.linea=String.valueOf(linea+1);
        elem.columna=String.valueOf(columna+1);
        elem.descripcion=mensaje;
        this.tablaError.add(elem);
        
        tablaGUI(elem);
        
        println("[Error]Lexico-> "+mensaje);
    }
//    
//    public void insertErrorSemantic(String  ambito, int linea, int columna, String mensaje){
//        
//        elementoError elem=new elementoError();
//        elem.ambito= ambito;
//        elem.tipo="Semantico";
//        elem.linea=String.valueOf(linea+1);
//        elem.columna=String.valueOf(columna+1);
//        elem.descripcion=mensaje;
//        this.tablaError.add(elem);
//        println("[Error]Semantico-> "+mensaje);
// 
//    }
//    
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| Mostrando los erroes
     * <br>|--------------------------------------------------------------------------
     * <br>| Para enviar el token, y el mensaje
     */

    
    /**
     * Mostrando un error sintactico 
     * @param atrib El atributo, que contiene el nombre del archivo, linea, columna
     * @param mensaje Mensaje del error
     */
    
    public void insertErrorSyntax(itemAtributo atrib, String mensaje){
        elementoError elem=new elementoError();
        elem.ambito=atrib.nombreArchivo;
        elem.tipo="Sintactico";
        elem.linea=String.valueOf(atrib.linea);
        elem.columna=String.valueOf(atrib.columna);
        elem.descripcion=mensaje; 
        this.tablaError.add(elem);
        
        tablaGUI(elem);
        
        println("[Error]Sintactico-> "+mensaje);
    }
    
    
    /**
     * Mostrando un error lexico 
     * @param atrib El atributo, que contiene el nombre del archivo, linea, columna
     * @param mensaje Mensaje del error
     */
    
    public void insertErrorLexical(itemAtributo atrib, String mensaje){
        elementoError elem=new elementoError();
        elem.ambito=atrib.nombreArchivo;
        elem.tipo="Lexico";
        elem.linea=String.valueOf(atrib.linea);
        elem.columna=String.valueOf(atrib.columna);
        elem.descripcion=mensaje; 
        this.tablaError.add(elem);
        
        tablaGUI(elem);
        
        println("[Error]Lexico-> "+mensaje);
    }
     
    
    /**
     * Mostrando un error lexico 
     * @param atrib El atributo, que contiene el nombre del archivo, linea, columna
     * @param mensaje Mensaje del error
     */
    
    public void insertErrorSemantic(itemAtributo atrib, String mensaje){
        elementoError elem=new elementoError();
        elem.ambito=atrib.nombreArchivo;
        elem.tipo="Semantico";
        elem.linea=String.valueOf(atrib.linea);
        elem.columna=String.valueOf(atrib.columna);
        elem.descripcion=mensaje; 
        this.tablaError.add(elem);
        
        tablaGUI(elem); 
        
        println("[Error]Semantico-> "+mensaje);
    } 
    
    
    public void concat(tablaErrores tab){
        List<elementoError> mergeList=new ArrayList<>(); 
        mergeList.addAll(tab.tablaError);
        mergeList.addAll(this.tablaError);
        this.tablaError = mergeList; 
         
        
    }
    
    
    
    public void imprimir() {
        System.out.println("-----cError--------");
        for (elementoError lstErrore : this.tablaError) { 
            print("Ambito{");
            print(lstErrore.ambito);
            println("}");
            print("Linea{");
            print(lstErrore.linea);
            println("}");
            print("Columna{");
            print(lstErrore.columna);
            println("}");
            print("Tipo{");
            print(lstErrore.tipo);
            println("}");
            print("Descripcion{");
            print(lstErrore.descripcion);
            println("}");
        }
    }
     
}
