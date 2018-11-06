/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import GUI.Principal;
import Gui.Listas.lstTabClase;
import Gui.Nodos.nodoTabClase;
import Gui.Nodos.nodoVistaArbol;
import java.io.File; 
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

/**
 *
 * @author joseph
 */
public class ideVistaArbol extends ideTabClases {
    
    
    /**<br>+----------------------------------------
     * <br>| Vista de los directorios
     * <br>+----------------------------------------
     */
    @FXML
    protected TreeView<nodoVistaArbol> vistaArbol; 
    
    
    
    public void enventoClickVistaArbol(MouseEvent event) {
        if (event.getClickCount() == 2) {

            //Obteniendo los valores al hacer doble click
            TreeItem<nodoVistaArbol> selectedItem = vistaArbol.getSelectionModel().getSelectedItem();
            nodoVistaArbol nodVist = selectedItem.getValue();

            nodoTabClase nuevoNodo;
            //Verificando la extensión antes de abrir el archivo
            if (esExtension("djs", nodVist.nombre)) {
                nuevoNodo = new nodoTabClase(nodVist.ruta, nodVist.nombre, "djs", simbolo);
            
            } else if(esExtension("ds", nodVist.nombre)){
                nuevoNodo = new nodoTabClase(nodVist.ruta, nodVist.nombre, "djs", simbolo); 
            
            }else if (esExtension("dpp", nodVist.nombre)) {
                
                nuevoNodo = new nodoTabClase(nodVist.ruta, nodVist.nombre, "dpp", simbolo);
                
            }else if(esExtension("dasm", nodVist.nombre)){
                nuevoNodo = new nodoTabClase(nodVist.ruta, nodVist.nombre, "dasm", simbolo);
            } 
            else {
                simbolo.mensaje.informacion("Error", "No se reconoce la extensión del archivo");
                return;
            }

            //Creando el nuevo nodo, que se va insertar en el tabPanel
            listaTabsClases.insertarTab(nuevoNodo);
        }
    }
    
    
    /**
     * Metodo para verificar la extensión del archivo
     * @param extension El nombre de la extensión que se quiere corroborar
     * @param nombre Nombre del archivo
     * @return 
     */
    
    public boolean esExtension(String extension, String nombre){
//        System.out.println("[ideVistaArbol]"+nombre);
        String[] extenArr= nombre.split("\\.");
        if(extenArr.length==2){
            String exten= extenArr[1];
            return exten.toLowerCase().equals(extension);
        }else{
//            System.out.println("[ideVistaArbol]No es igual a 2 : "+String.valueOf(extenArr.length));
            return false;
        }
    }
    
    /**
     * Abrirá un dialogo para seleccionar la ubicación de la carpeta
     */
    public void cargarCarpeta(){ 
        DirectoryChooser dc = new DirectoryChooser();
        dc.setInitialDirectory(new File(System.getProperty("user.home")));
        File choice = dc.showDialog(Principal.sta);
        if(choice == null || ! choice.isDirectory()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Could not open directory");
            alert.setContentText("The file is invalid.");

            alert.showAndWait();
        } else {
            
            vistaArbol.setRoot(getNodesForDirectory(choice));
        }
    }
    
    
    /**
     * Recorriendo todos los directorios para cargar el elemento
     * @param directory
     * @return 
     */
    public TreeItem<nodoVistaArbol> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
        TreeItem<nodoVistaArbol> root = new TreeItem<>(new nodoVistaArbol(directory.getName(),directory.getPath()), new ImageView("Gui/img/ic_folder_black_24dp_1x.png"));
//        root.setExpanded(true);
        
        
        for(File f : directory.listFiles()) {
//            System.out.println("[ideVistaArbol][getNodesForDirectory]Loading " + f.getName());
            //println("[getNodesForDirectory]Loading " + f.getName());
//            println("[getNodesForDirectory]Paht"+f.getPath());
            if(f.isDirectory()) { //Then we call the function recursively
                root.getChildren().add(getNodesForDirectory(f));
            } else {
                
                ImageView ima=new ImageView("Gui/img/baseline_insert_drive_file_black_18dp.png");
                ima.setOpacity(0.5);
                root.getChildren().add(new TreeItem<>(new nodoVistaArbol(f.getName(),f.getPath()),ima ));
            }
        }
        return root;
    }
      
    public void println(String mensaje){
        System.out.println("[ideVistaArbol]"+mensaje);
    } 
}
