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
import Gui.Nodos.nodoVistaArbol;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

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
 
    }

    @FXML
    void clckDepurar(ActionEvent event) {

    }
    
    
    @FXML
    void clckSiguienteLinea(ActionEvent event) {
        simbolo.clock.play();
    }
    

    @FXML
    void clckEjecutar(ActionEvent event) {
        
        SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
        int indice = selectionModel.getSelectedIndex();  
        txtConsola.setText("");
//        simbolo.listaTabsClases.ejecutarNodo(indice);
        ejecut(indice);
//        System.out.println("123");
////        Platform.runLater(() -> {
//            System.out.println("jajaja");
////            simbolo.listaTabsClases.ejecutarNodo(indice);
//            System.out.println("jejeje");
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    Platform.runLater(() -> {
//                        simbolo.listaTabsClases.ejecutarNodo(indice);
//                    });
//                }
//            };
//
//            thread.start();
////        });
//        System.out.println("543");
//        simbolo.hiloEjecucion.ejecutar(indice);
        
//        simbolo.listaTabsClases.ejecutarNodo(indice); 
        
        
    }
    
    public void ejecut(int indice) {
//        Platform.runLater(() -> {
//            simbolo.listaTabsClases.ejecutarNodo(indice);
//        });

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                 
//                simbolo.listaTabsClases.ejecutarNodo(indice);
//            }
//        };
//        Thread thread = new Thread(runnable);
//
//        System.out.println("Starting Thread...");
//        thread.start();
//        try {
//            run.wait();
//        } catch (InterruptedException ex) {
//            println(ex.getMessage());
//        }

//        Platform.runLater(runnable);
        simbolo.prueba="es una preuba";
         simbolo.clock = new Timeline(
                new KeyFrame(Duration.seconds(0), evt -> {
                    
                    System.out.println("123");
                    simbolo.listaTabsClases.ejecutarNodo(indice);
                    System.out.println("543");
                }),
                 new KeyFrame(Duration.seconds(1))
        );
         System.out.println("ñkddj");
         simbolo.clock.play();
//        clock.setCycleCount(Animation.INDEFINITE);
        
        

    }

    @FXML
    void clckGuardar(ActionEvent event) {

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
