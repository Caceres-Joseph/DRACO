/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author joseph
 */
public class Interfaz_fxml implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private JFXTabPane tabProductos;

    @FXML
    private JFXTabPane tabBusqueda;

    @FXML
    private AnchorPane txtBuscarCodigo;

    @FXML
    private JFXTextField txtBuscarCode;

    @FXML
    private JFXTextField txtBuscarComercial;

    @FXML
    private JFXTextField txtBuscarGenerico;

    @FXML
    private JFXTextField txtBuscarDescripcion;

    @FXML
    private ComboBox<?> txtBuscarCategoria;

    @FXML
    private ComboBox<?> txtBuscarUbicacion;

    @FXML
    private TableView<?> tablaCuenta;

    @FXML
    private TableColumn<?, ?> clId;

    @FXML
    private TableColumn<?, ?> clCantidad;

    @FXML
    private TableColumn<?, ?> clComercial;

    @FXML
    private TableColumn<?, ?> clGenerico;

    @FXML
    private TableColumn<?, ?> clDescripcion;

    @FXML
    private TableColumn<?, ?> clDescuento;

    @FXML
    private TableColumn<?, ?> clPrecio;

    @FXML
    private TableColumn<?, ?> clTotal;

    @FXML
    void clickBuscarCodigo(MouseEvent event) {

    }

    @FXML
    void clickBuscarComercial(MouseEvent event) {

    }

    @FXML
    void clickBuscarDescripcion(MouseEvent event) {

    }

    @FXML
    void clickBuscarGenerico(MouseEvent event) {

    }

    @FXML
    void clickTabBuscar(MouseEvent event) {

    }

    @FXML
    void clickTablaCuenta(MouseEvent event) {

    }

    @FXML
    void enterBuscarCodigo(KeyEvent event) {

    }

    @FXML
    void llenarBuscarCategoria(MouseEvent event) {

    }

    @FXML
    void llenarBuscarUbicacion(MouseEvent event) {

    }

    @FXML
    void mouseBuscarCategoria(MouseEvent event) {

    }

    @FXML
    void onActionBuscarCategoria(ActionEvent event) {

    }

    @FXML
    void realseBuscarCategoria(MouseEvent event) {

    }

    @FXML
    void teclaBuscarComercial(KeyEvent event) {

    }

    @FXML
    void teclaBuscarDescripcion(KeyEvent event) {

    }

    @FXML
    void teclaBuscarGenerico(KeyEvent event) {

    }
}
