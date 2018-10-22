/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Elementos;
 
import DracoScript.Estructuras.Tablas.tablaErrores; 
import Gui.Componentes.compTablaErrores;
import Gui.Elementos.elementoDebug;
import Gui.Elementos.elementoMensaje;
import Gui.Lienzo.Lienzo;
import Gui.Listas.lstTabClase; 
import com.jfoenix.controls.JFXTabPane; 
import javafx.application.Platform;
import javafx.scene.control.TextArea; 


/**
 *
 * @author joseph
 */
public class elementoGlobal {
    /**
     * DRACO SCRIPT
     */
    
    public tablaErrores tablaErrores = new tablaErrores(this);
    TextArea txtConsola;
     
//    public elementoGlobal(){
//        
//    }
    
    /**
     * GUI
     * 
     */
    
    public elementoMensaje mensaje;
    public lstTabClase listaTabsClases; 
    public elementoDebug debug;
    public compTablaErrores tbErrores;
    public JFXTabPane tabInferior;
    
    /**
     * Para el debug
     */
    
    public boolean modoDebug=false;
    public Lienzo ctrlLienzo;
    
    
    /**
     * 
     * @param mensaje
     * @param listaTabsClases
     * @param txtConsola 
     * @param tbErrores 
     * @param ctrlLienzo  Lienzo en donde se va pintar
     */
    
    public elementoGlobal(
            elementoMensaje mensaje,
            lstTabClase listaTabsClases, 
            TextArea txtConsola, 
            compTablaErrores tbErrores, 
            Lienzo ctrlLienzo
            ){
        
        this.ctrlLienzo=ctrlLienzo;
        this.txtConsola=txtConsola;
        this.tbErrores=tbErrores;
        this.mensaje=mensaje;
//        this.tabInferior=tabInferior;
        this.listaTabsClases=listaTabsClases; 
        
//        this.hiloEjecucion=new elementoHilo(this); 
        this.ctrlLienzo = ctrlLienzo;

    }
    
    public void setConsola(String contenido){
        
        Platform.runLater(() -> {
            txtConsola.setText(txtConsola.getText() + contenido);
        });
    }
    public void clearConsola(){
        
        Platform.runLater(() -> {
            txtConsola.setText("");
        });
    } 
}
