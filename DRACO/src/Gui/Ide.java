/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
  
import DracoScript.Estructuras.Elementos.elementoGlobal; 
import Gui.Componentes.ideVistaArbol;  
import Gui.Elementos.elementoMensaje;
import Gui.Listas.lstTabClase;  
import java.net.URL;
import java.util.ResourceBundle;  
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab; 
import javafx.scene.input.MouseEvent; 

/**
 * FXML Controller class
 *
 * @author joseph
 */
public class Ide extends ideVistaArbol  {
  
    
    
    /**<br>+----------------------------------------------------
     * <br>| CLICK DE LA BARRA DE MENU
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos del menu
     * <br>|
     */    
    @FXML 
    void clckAbrirCarpeta(ActionEvent event) {
        cargarCarpeta();
    }
    

    @FXML
    void clckCerrar(ActionEvent event) {
        println("[clckCerrar]"); 
    }
    
    @FXML
    void clckGuardar(ActionEvent event) { 
        println("[clckGuardar]"); 
    }

    @FXML
    void clckNuevaCarpeta(ActionEvent event) {

    }

    @FXML
    void clckNuevoArchivo(ActionEvent event) {

    }

    @FXML
    void clckSalir(ActionEvent event) {

    }
    
    

    /**<br>+----------------------------------------------------
     * <br>| DEBUGGER
     * <br>+----------------------------------------------------
     * <br>| Metodos para el debugger
     * <br>|
     */    
    
    
    /**
     * Se mueve de instrucción en instrucción
     * @param event 
     */
    @FXML
    void clckSiguienteLinea(ActionEvent event) {
        if(simbolo.debug!=null){ 
            println("[clckSiguienteLinea]"); 
            simbolo.debug.siguienteInstruccion=true; 
            simbolo.debug.hiloEjecucion.resume();
        }
        
    }
    
 
    /**
     * Permite de ir de punto de interrupción a otro punto de interrupción
     * @param event 
     */
    @FXML
    void clckContinuar(ActionEvent event) {
        if(simbolo.debug!=null){ 
            println("[clckContinuar]"); 
            simbolo.debug.siguienteInstruccion=false;
            simbolo.debug.hiloEjecucion.resume();
        }
    }
    
    
    /**
     * Termina toda la ejecución
     * @param event 
     */
    @FXML
    void clckTerminarTodo(ActionEvent event) {
        if(simbolo.debug!=null){
            simbolo.debug.detener();
        }
    }
    
    

    /**<br>+----------------------------------------------------
     * <br>| MODOS DE EJECUCIÓN
     * <br>+----------------------------------------------------
     * <br>| Metodos para el debugger
     * <br>|
     */    
    @FXML
    void clckEjecutar(ActionEvent event) {
        simbolo.modoDebug=false;
        ejecutar();
    }
    
    @FXML
    void clckDepurar(ActionEvent event) { 
        simbolo.modoDebug=true;
        ejecutar();

    }
    
    public void ejecutar(){
        SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
        int indice = selectionModel.getSelectedIndex(); 
        simbolo.listaTabsClases.ejecutarNodo(indice);
    }
  

    /**<br>+----------------------------------------------------
     * <br>| ACERCA DE LA APLICACION
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    
    
    @FXML
    void clckAcercaDe(ActionEvent event) {
        System.out.println("acerca de");
    }
    /**<br>+----------------------------------------------------
     * <br>| CLICK VISTA ARBOL
     * <br>+----------------------------------------------------
     * <br>| Estan los eventos de la vista ábol
     * <br>|
     */    
    
    
    @FXML
    void clckEstadoEjecucion(ActionEvent event) {
       
    }
    
    @FXML
    void clckVistaArbol(MouseEvent event) {
        enventoClickVistaArbol(event);
    }
    
      
    /**<br>+----------------------------------------------------
     * <br>| Metodo que se ejecuta de primero
     * <br>+---------------------------------------------------- 
     * <br>|
     */    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Vista árbol    
        mensaje=new elementoMensaje(stackPadre);
        simbolo=new elementoGlobal(mensaje, listaTabsClases, txtConsola);
        listaTabsClases=new lstTabClase(tabClases, simbolo);
        simbolo.listaTabsClases=listaTabsClases;
    }
    
}
