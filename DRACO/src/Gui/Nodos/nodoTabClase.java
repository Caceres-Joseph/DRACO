/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Nodos;
  
import Gui.Elementos.elementoGlobal;
import Gui.Elementos.elementoDebug;  
import Gui.Listas.lstPuntosDeInterrupcion;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView; 

/**
 *
 * @author joseph
 */
public class nodoTabClase {
    
    public String ruta="";
    public String nombre="";
    public AnchorPane panelPadre = new AnchorPane();
    public Tab nuevaTab=new Tab();
    public WebView areaWeb;
    public elementoGlobal simbolo;
    
    public String extension="";
    public String contenidoArchivo="";
    
    
    public nodoTabClase(String ruta, String nombre,String extension, elementoGlobal simbolo){
        this.ruta=ruta;
        this.simbolo=simbolo;
        this.nombre=nombre;
        this.extension=extension;
        nuevaTab = new Tab(nombre); 
        nuevaTab.setContent(panelPadre); 
        areaWeb=new WebView();
        areaWeb.getStylesheets().add("/Gui/Estilos/Metro-UI.css");
        
        leerArchivo();
        crearEditor();
        
    }
    
    public void leerArchivo() {
        try { 
            contenidoArchivo = new String(Files.readAllBytes(Paths.get(ruta)));
        } catch (IOException e) {
            simbolo.mensaje.informacion("Error al leer", "No se pudo leer el archivo");
            println("[leerArchivo]"+e.getMessage());
        }
    }
    
    
    /**
     * Metodo que crea el edito de texto 
     * Se lee el archivo nodoEditor.html que contiene el codigo js del editor
     */
    public void crearEditor(){
        
        String editingCode = contenidoArchivo; 
        String editingTemplate="";

        try {            
            editingTemplate = new String(Files.readAllBytes(Paths.get("src/Gui/Nodos/nodoEditor.html")));
        } catch (IOException ex) {
            println("[crearEditor][Error]"+ex.getMessage());
        }
         
        editingTemplate=  editingTemplate.replace("${code}", editingCode);
        areaWeb.getEngine().loadContent(editingTemplate);
        
        
        AnchorPane.setBottomAnchor(areaWeb, 10.0);
        AnchorPane.setLeftAnchor(areaWeb, 10.0);
        AnchorPane.setRightAnchor(areaWeb, 10.0);
        AnchorPane.setTopAnchor(areaWeb, 10.0);
        panelPadre.getChildren().setAll(areaWeb);
        
    }
     
    
    public lstPuntosDeInterrupcion getPuntosDeInterrupcion(){
        lstPuntosDeInterrupcion retorno=new lstPuntosDeInterrupcion();
        
        try{
            String cadenaJson = (String ) areaWeb.getEngine().executeScript("getHashMap();"); 
//            println(cadenaJson);
            String[] arr= cadenaJson.split(",");
            
//            if(arr.length==1){
//                nodoPuntoInterrupcion nuevoPunto=new nodoPuntoInterrupcion(nombre, Integer.valueOf(cadenaJson));
//                retorno.insertar(nuevoPunto);
//                return retorno;
//            }
            for(String en : arr){
                nodoPuntoInterrupcion nuevoPunto=new nodoPuntoInterrupcion(nombre, Integer.valueOf(en));
                retorno.insertar(nuevoPunto);
            }
        }catch(Exception e){
            println("[getPuntosDeInterrupcion][ERROR]"+e.getMessage());
        }
         
        
        return retorno;
    }
    
    public void pintarLinea(int linea){
        
        Platform.runLater(() -> {
            try {
                areaWeb.getEngine().executeScript("pintarLinea("+linea+");");
            } catch (Exception e) {
                println("[pintarLinea][ERROR]"+e.getMessage());
            }
        });
    }
    
    public void removerLineasPintadas(){
        
        Platform.runLater(() -> {
            try {
                areaWeb.getEngine().executeScript("removerLineas();");
            } catch (Exception e) {
                println("[removerLineasPintadas][ERROR]"+e.getMessage());
            }
        });
    }

    public void ejecutar() {
        
        if(simbolo.debug!=null){
            if(simbolo.debug.estaActivo()){
                simbolo.mensaje.informacion("Análisis en ejecución", "Actualmente sigue en ejecución,\n seleccione Terminar Todo para finalizar el analisis que está detenido");
                return;
            }
        }
         
        System.out.println("+------------------------------------------------+"); 
        System.out.println("| [nodoTabClase]Iniciando Análisis               |");
        System.out.println("+------------------------------------------------+");
        
        
        //Limpiando la tabla de errores
        simbolo.tablaErrores.clean();
        simbolo.ctrlLienzo.limpiarLienzo();
        simbolo.clearConsola();
        String    salida = (String) areaWeb.getEngine().executeScript("editor.getValue();");
          
        elementoDebug debug=new elementoDebug(extension.toLowerCase(), simbolo, salida, nombre);
        simbolo.debug=debug;
        
        if(simbolo.modoDebug){
            //Enviando los puntos de quibre, una vez ya se creo el elementoDebu
            simbolo.listaTabsClases.cargarPuntosDeInterrupcion(); 
        }
        
        try {
            simbolo.debug.iniciar(); 
        } catch (Exception e) {
            println("[ejecutar][Error]"+e.getMessage());
        }
//        simbolo.debug.detener();
//        println("[ejecutar]****  Fin del analisis *****");
//        simbolo.debug=null;
    } 
    /**
     * Retorna la nueva tab
     * @return 
     */
    public Tab getNuevaTab() {
        return nuevaTab;
    } 
    
    public void println(String mensaje){
        System.out.println("[nodoTabClase]"+mensaje);
    }
    
}
