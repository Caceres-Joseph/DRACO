/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import Gui.Componentes.TablaSimbolosDasm.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author joseph
 */
public class ideTablaSimbolosDasm extends ideTablaErrores{
    
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | STACK
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    public dasmTablaStack tablaSimbolosDasmStack;
     
    @FXML
    private TableView<dasmTablaStack.elementoTabla> tbDasmStack;

    

    @FXML
    private TableColumn tcDstackNo;

    @FXML
    private TableColumn tcDStackStack;
 
    private void inicializarTablaDasmStack(){
        tablaSimbolosDasmStack=new dasmTablaStack(tbDasmStack, tcDstackNo, tcDStackStack);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | HEAP
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    public dasmTablaHeap tablaSimbolosDasmHeap;
    @FXML
    private TableView<dasmTablaHeap.elementoTabla> tbDasmHeap;

    @FXML
    private TableColumn tcDheapNo;

    @FXML
    private TableColumn  tcDheap;
    
    
    private void inicializarTablaDasmHeap(){
        tablaSimbolosDasmHeap=new dasmTablaHeap(tbDasmHeap, tcDheapNo, tcDheap);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | AUX
    |-------------------------------------------------------------------------------------------------------------------
    |
    */ 
    
    
    public dasmTablaStackAux tablaSimbolosDasmPilita;
    
    
    @FXML
    private TableView<dasmTablaStackAux.elementoTabla> tbDasmAux;

    @FXML
    private TableColumn tcDauxNo;

    @FXML
    private TableColumn tcDaux;
     
    
    
    private void inicializarTablaDasmPilita(){
        tablaSimbolosDasmPilita=new dasmTablaStackAux(tbDasmAux, tcDauxNo, tcDaux);
    }
    
    
    
    
    
    /**
     * Inicializando tablas
     */
    public void inicializarTablaSimbolosDasm(){
        inicializarTablaDasmStack();
        inicializarTablaDasmHeap();
        inicializarTablaDasmPilita();
    }
}
