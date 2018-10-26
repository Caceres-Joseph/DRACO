/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos;

import DracoScript.Estructuras.Elementos.elementoEntorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Listas.lstAtributos;
import DracoScript.Estructuras.Listas.lstNodosHijos;

 
public class nodoModelo {
    
    public elementoGlobal simbolo;
    //public String nombreNodo = "";
    public lstAtributos listaAtributos;
    public lstNodosHijos listaHijos;
    public itemAtributo atributo;
    
    /**
     * constructor de _ASGIN_VAR 
     * @param atrib Atributo que contiene el nombre y la linea del nodo
     * @param simbolo Es el simbolo global
     */
    
    public nodoModelo(itemAtributo atrib, elementoGlobal simbolo){
        this.atributo = atrib;
        this.simbolo=simbolo;
        this.listaAtributos =new lstAtributos();
        this.listaHijos =new lstNodosHijos(); 
    }
    
     
    
     
    /**
     * @param mensaje Imprime el mensaje con el nombre de la clase para ubicarlo de forma fácil
     */
    public void println(String mensaje){
        System.out.println("["+atributo.nombreToken+"]"+mensaje);
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
    public itemRetorno ejecutar(elementoEntorno entorno){
//        validandoDebug();
       
        itemRetorno retorno=new itemRetorno();
        if(hayErrores()){
            return retorno;
        }
        
        return listaHijos.ejecutar(entorno);
    }
    
    
    public void validandoDebug(){
        simbolo.listaTabsClases.despintarLineas();
        
        if(simbolo.modoDebug){
            if(simbolo.debug.siguienteInstruccion){
                
                    simbolo.listaTabsClases.pintarLinea(atributo.nombreArchivo, atributo.linea-1); 
                    simbolo.debug.pausar(); 
                    
            }else{
                //reviso si esta linea esta dentro del debug
                if(simbolo.debug.puntosDeInterrupcion.esPuntoDeInterrupcion(atributo)){
                    println("deteniendo hilo");
                    simbolo.listaTabsClases.pintarLinea(atributo.nombreArchivo, atributo.linea-1);
                    simbolo.debug.pausar();
                }
            }
                
        }  
    }
    
    /**
     * Para detectar si hay errores semanticos
     * @return  Retorna un boolean para indicar si hubieron errores
     */
    public boolean hayErrores(){
        if(!simbolo.tablaErrores.tablaError.isEmpty()){
            println("[hayErrores]No se puede ejecutar porque hay errores");
            return true;
        }
        return false;
    }
    
}
