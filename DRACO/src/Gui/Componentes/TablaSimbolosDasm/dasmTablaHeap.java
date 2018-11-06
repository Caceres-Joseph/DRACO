/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes.TablaSimbolosDasm;

import Dasm.EstructurasDasm.Heap.heap;
import Dasm.EstructurasDasm.Stack.nodoStack;
import java.util.Iterator;
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
public class dasmTablaHeap {
    
    private ObservableList<elementoTabla> contenidoTabla = FXCollections.observableArrayList();
    private TableView<elementoTabla> tbHeap; 
    
    private TableColumn tcNo; 
    private TableColumn tcHeap;  

    public dasmTablaHeap(TableView<elementoTabla> tbHeap, TableColumn tcNo, TableColumn tcHeap) {
        this.tbHeap = tbHeap;
        this.tcNo = tcNo;
        this.tcHeap = tcHeap; 
        inicializarTabla();
    }
    
    
    public void inicializarColumnas(){
         
        tcNo.setCellValueFactory(
                new PropertyValueFactory<>("No"));
         
        tcHeap.setCellValueFactory(
                new PropertyValueFactory<>("Heap"));
  
        
    }
    
    
    /**
     * Muesta el contenido de Stack en la tabla
     * @param Heap 
     */
    public void mostrar(heap Heap) {
        
        //limpiando tabla
        contenidoTabla.clear();
        
        //llenando la tabla 
        for (Integer key : Heap.listaNodoStack.keySet()) {
//            System.out.println("Clave: " + key + " -> Valor: " + Heap.listaNodoStack.get(key));
            nodoStack heap = Heap.listaNodoStack.get(key);
            elementoTabla nuevoItem = new elementoTabla(String.valueOf(key), String.valueOf(heap.valor));
            contenidoTabla.add(nuevoItem);
        }

    }
     
    /**
     * Inicializa la tabla
     */
    public void inicializarTabla() { 
        inicializarColumnas();
        tbHeap.setItems(contenidoTabla);
//        contenidoTabla.add(new elementoTabla("archivo","12","34", "semantico", "Es una prueba"));
    }
    
    public void clean(){
        contenidoTabla.clear();
    }

    
    public class elementoTabla {

        public SimpleStringProperty no = new SimpleStringProperty();
        public SimpleStringProperty heap = new SimpleStringProperty(); 

        public elementoTabla() {

        }

        public elementoTabla(String no,String heap) {
            this.no=new SimpleStringProperty(no);
            this.heap = new SimpleStringProperty(heap); 
        }

        public String getNo() {
            return no.get();
        }

        public String getHeap() {
            return heap.get();
        } 
    }
}
