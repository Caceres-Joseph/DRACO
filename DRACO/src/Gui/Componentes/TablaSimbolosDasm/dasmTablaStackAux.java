/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes.TablaSimbolosDasm;

import Dasm.EstructurasDasm.Pilita.pilita;
import Dasm.EstructurasDasm.Stack.nodoStack;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author joseph
 */
public class dasmTablaStackAux {
    
    private ObservableList<elementoTabla> contenidoTabla = FXCollections.observableArrayList();
    private TableView<elementoTabla> tbStack; 
    
    private TableColumn tcNo; 
    private TableColumn tcStack;  

    public dasmTablaStackAux(TableView<elementoTabla> tbStack, TableColumn tcNo, TableColumn tcStack) {
        this.tbStack = tbStack;
        this.tcNo = tcNo;
        this.tcStack = tcStack; 
        inicializarTabla();
    }
    
    
    public void inicializarColumnas(){
         
        tcNo.setCellValueFactory(
                new PropertyValueFactory<>("No"));
         
        tcStack.setCellValueFactory(
                new PropertyValueFactory<>("Stack"));
  
        
    }
    
    
    /**
     * Muesta el contenido de Stack en la tabla
     * @param Pilita 
     */
    public void mostrar(pilita Pilita) {
        
        //limpiando tabla
        contenidoTabla.clear();
        
        //llenando la tabla 
        
        for (int i =Pilita.listaDoubles.size()-1; i >= 0; i--) {
            
            Double stack=Pilita.listaDoubles.get(i);
            elementoTabla nuevoItem = new elementoTabla(String.valueOf(i), String.valueOf(stack));
            contenidoTabla.add(nuevoItem);
        }
        
    }
     
    /**
     * Inicializa la tabla
     */
    public void inicializarTabla() { 
        inicializarColumnas();
        tbStack.setItems(contenidoTabla);
//        contenidoTabla.add(new elementoTabla("archivo","12","34", "semantico", "Es una prueba"));
    }
    
    public void clean(){
        contenidoTabla.clear();
    }

    
    public class elementoTabla {

        public SimpleStringProperty no = new SimpleStringProperty();
        public SimpleStringProperty stack = new SimpleStringProperty(); 

        public elementoTabla() {

        }

        public elementoTabla(String no,String stack) {
            this.no=new SimpleStringProperty(no);
            this.stack = new SimpleStringProperty(stack); 
        }

        public String getNo() {
            return no.get();
        }

        public String getStack() {
            return stack.get();
        } 
    }
}
