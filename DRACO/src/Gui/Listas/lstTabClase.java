/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Listas;
  
import DracoScript.Estructuras.Elementos.elementoGlobal;
import Gui.Nodos.nodoTabClase; 
import com.jfoenix.controls.JFXTabPane;
import java.util.ArrayList; 
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;

/**
 *
 * @author joseph
 */
public class lstTabClase {
    
    public JFXTabPane tabClases;    
    public ArrayList<nodoTabClase> listaTabs; 
    public elementoGlobal simbolo;
    public lstTabClase(JFXTabPane tabClases, elementoGlobal simbolo){
        this.tabClases=tabClases;
        this.simbolo=simbolo;
        listaTabs=new ArrayList<>();
        
    }
    
    public void insertarTab(nodoTabClase nuevaTab){
        if(nuevaTab.getNuevaTab()==null){
            System.out.println("[lstTabClases][insertTab]Tab nula");
            return;
        }
        
        if(tabClases==null){
            System.out.println("[lstTabClases][insertTab]TabClases nula");
            return;
        }
        
        insertNuevoNodo(nuevaTab);
    }
    
    /**
     * Inserta un nuevo nodo
     * @param nuevaTab Es la nueva tab que se va insertar
     * @return 
     */
    public boolean insertNuevoNodo(nodoTabClase nuevaTab) {

        for (nodoTabClase listaTab : listaTabs) {
            if (nuevaTab.nombre.equals(listaTab.nombre)) {
                simbolo.mensaje.informacion("Draco", "Ya se encuentra abierto el archivo: " + nuevaTab.nombre);
                return false;
            }
        }
        
        

        tabClases.getTabs().add(nuevaTab.getNuevaTab());
        listaTabs.add(nuevaTab);
        return true;
    } 
    
    
    
    public void cargarPuntosDeInterrupcion(){
        lstPuntosDeInterrupcion retorno=new lstPuntosDeInterrupcion();
        for (nodoTabClase listaTab : listaTabs) {
            retorno.concat(listaTab.getPuntosDeInterrupcion());
        }
        if(simbolo.debug!=null){
            
            simbolo.debug.puntosDeInterrupcion=retorno; 
        }else{
            println("[cargarPuntosDeInterrupcion]El debug es nulo");
        }
    }
    
    
    public void ejecutarNodo(int i){
        
         
        if(listaTabs.size()>i){
            nodoTabClase temp= listaTabs.get(i);
            temp.ejecutar();
        }else{
            println("[ejecutarNodo]Se sobrepaso el indice del arreglo");
        }
    }
    
    
    
    public void pintarLinea(String nombreArchivo, int linea){
        for (nodoTabClase listaTab : listaTabs) {
            if(listaTab.nombre.equals(nombreArchivo)){
                listaTab.pintarLinea(linea);
                
                
                //seleccionando la pestaña del debug
                SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
                selectionModel.select(listaTab.getNuevaTab());
                
                return;
            }
        }
    }
    
    public void despintarLineas() {

        for (nodoTabClase listaTab : listaTabs) {
            listaTab.removerLineasPintadas();
        }
    }
    
    public void println(String mensaje){
        System.out.println("[lstTabClase]"+mensaje);
    }
    
}
