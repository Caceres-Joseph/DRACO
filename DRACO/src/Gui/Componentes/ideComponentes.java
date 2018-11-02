/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;
 
import Gui.Elementos.elementoGlobal;
import Gui.Elementos.elementoMensaje;
import Gui.Listas.lstTabClase;
import Gui.Nodos.nodoVistaArbol;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author joseph
 */
public class ideComponentes implements Initializable  {

    public elementoGlobal simbolo;
    
    @FXML
    public StackPane stackPadre;
    public elementoMensaje mensaje;
    
    /**
     * Salida de la consola
     */
    @FXML
    public TextArea txtConsola;
    
    /**
     * La salida de la pestaña dasm
     */
    @FXML
    public TextArea txtDasm;
    
    @FXML
    public WebView wbSalidaDasm;
     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Vista árbol     
        
    }  
}
