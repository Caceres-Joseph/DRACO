/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import DracoScript.Estructuras.Elementos.elementoError;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author joseph
 */
public class compTablaErrores {
    
    
    private ObservableList<elementoTabla> contenidoTabla = FXCollections.observableArrayList();
    private TableView<elementoTabla> tbErrores; 
    
    private TableColumn tcAmbito; 
    private TableColumn tcLinea; 
    private TableColumn tcColumna; 
    private TableColumn tcTipo; 
    private TableColumn tcDescripcion;

    public compTablaErrores(TableView<elementoTabla> tbErrores, TableColumn tcAmbito, TableColumn tcLinea, TableColumn tcColumna, TableColumn tcTipo, TableColumn tcDescripcion) {
        this.tbErrores = tbErrores;
        this.tcAmbito = tcAmbito;
        this.tcLinea = tcLinea;
        this.tcColumna = tcColumna;
        this.tcTipo = tcTipo;
        this.tcDescripcion = tcDescripcion;
        inicializarTabla();
    }
    
    
    public void inicializarColumnas(){
         
        tcAmbito.setCellValueFactory(
                new PropertyValueFactory<>("Ambito"));
         
        tcLinea.setCellValueFactory(
                new PropertyValueFactory<>("linea"));
 
        tcColumna.setCellValueFactory(
                new PropertyValueFactory<>("columna"));
 
        tcTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        
        tcDescripcion.setCellValueFactory(
                new PropertyValueFactory<>("descripcion"));
        
    }
    
    
    public void insertarError(elementoError error){ 
        elementoTabla nuevoItem=new elementoTabla(error.ambito, error.linea, error.columna, error.tipo, error.descripcion);
        contenidoTabla.add(nuevoItem);
        
    }
    
    public void inicializarTabla() { 
        inicializarColumnas();
        tbErrores.setItems(contenidoTabla);
//        contenidoTabla.add(new elementoTabla("archivo","12","34", "semantico", "Es una prueba"));
    }
    
    public void clean(){
        contenidoTabla.clear();
    }

    
    public class elementoTabla {

        public SimpleStringProperty ambito = new SimpleStringProperty();
        public SimpleStringProperty linea = new SimpleStringProperty();
        public SimpleStringProperty columna = new SimpleStringProperty();
        public SimpleStringProperty tipo = new SimpleStringProperty();
        public SimpleStringProperty descripcion = new SimpleStringProperty();

        public elementoTabla() {

        }

        public elementoTabla(String ambito,String linea, String columna, String tipo, String descripcion) {
            this.ambito=new SimpleStringProperty(ambito);
            this.linea = new SimpleStringProperty(linea);
            this.columna = new SimpleStringProperty(columna);
            this.tipo = new SimpleStringProperty(tipo);
            this.descripcion = new SimpleStringProperty(descripcion);
        }

        public String getAmbito() {
            return ambito.get();
        }

        public String getLinea() {
            return linea.get();
        }

        public String getColumna() {
            return columna.get();
        }

        public String getTipo() {
            return tipo.get();
        }

        public String getDescripcion() {
            return descripcion.get();
        }

    }
}
