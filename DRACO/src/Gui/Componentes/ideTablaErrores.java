/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;
  
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView; 

/**
 *
 * @author joseph
 */
public class ideTablaErrores extends ideVistaArbol{
     
    
    
    public compTablaErrores tablaErrores;
    
    @FXML
    private TableView<compTablaErrores.elementoTabla> tbErrores;
    

    @FXML
    private TableColumn tcAmbito;

    @FXML
    private TableColumn tcLinea;

    @FXML
    private TableColumn tcColumna;

    @FXML
    private TableColumn tcTipo;

    @FXML
    private TableColumn tcDescripcion;
    
    
    
    
    public void inicializarTabla(){
        tablaErrores=new compTablaErrores(tbErrores, tcAmbito, tcLinea, tcColumna, tcTipo, tcDescripcion);
    }
    
    
 
    
}
