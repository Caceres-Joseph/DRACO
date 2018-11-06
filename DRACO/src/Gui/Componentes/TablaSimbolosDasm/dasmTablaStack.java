/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes.TablaSimbolosDasm;
 
import Dasm.EstructurasDasm.Stack.nodoStack;
import Dasm.EstructurasDasm.Stack.stack;
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
public class dasmTablaStack {
    
    private ObservableList<elementoTabla> contenidoTabla = FXCollections.observableArrayList();
    private TableView<elementoTabla> tbStack; 
    
    private TableColumn tcNo; 
    private TableColumn tcStack;  

    public dasmTablaStack(TableView<elementoTabla> tbStack, TableColumn tcNo, TableColumn tcStack) {
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
     * @param Stack 
     */
    public void mostrar(stack Stack) {
        
        //limpiando tabla
        contenidoTabla.clear();
         
        //llenando la tabla 
        for (Integer key : Stack.listaNodoStack.keySet()) {
//            System.out.println("Clave: " + key + " -> Valor: " + Heap.listaNodoStack.get(key));
            nodoStack heap = Stack.listaNodoStack.get(key);
            elementoTabla nuevoItem = new elementoTabla(String.valueOf(key), String.valueOf(heap.valor));
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
