/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Elementos;
 
import D_plus.Estructuras.Elementos.elementoClase;
import Gui.Componentes.TablaSimbolosDasm.dasmTablasSimbolos;
import Gui.Tablas.tablaErrores; 
import Gui.Componentes.compTablaErrores; 
import Gui.Componentes.ideTxtConsolaDasm;
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
     * DASM
     */
    public Dasm.Estructuras.Elementos.elementoEntorno entornoDasm;
    public dasmTablasSimbolos tablaSimbolosDasm;
    /**
     * DRACO SCRIPT
     */
    
    public tablaErrores tablaErrores = new tablaErrores(this);
    
    
    /**
     * D++
     */
    TextArea txtConsola;
    public ideTxtConsolaDasm salidaDasm;
    elementoClase clase;
    
    
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
     * @param salidaDasm 
     * @param tbErrores 
     * @param ctrlLienzo  Lienzo en donde se va pintar
     * @param tablaSimbolosDasm
     */
    
    public elementoGlobal(
            elementoMensaje mensaje,
            lstTabClase listaTabsClases, 
            TextArea txtConsola, 
            ideTxtConsolaDasm salidaDasm,
            compTablaErrores tbErrores, 
            Lienzo ctrlLienzo,
            dasmTablasSimbolos tablaSimbolosDasm
            ){
        
        this.salidaDasm =salidaDasm;
        this.ctrlLienzo=ctrlLienzo;
        this.txtConsola=txtConsola;
        this.tbErrores=tbErrores;
        this.mensaje=mensaje;
//        this.tabInferior=tabInferior;
        this.listaTabsClases=listaTabsClases; 
        
//        this.hiloEjecucion=new elementoHilo(this); 
        this.ctrlLienzo = ctrlLienzo;
        
        //dasm
        this.tablaSimbolosDasm=tablaSimbolosDasm;

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
        salidaDasm.clear();
    } 
    
    
}
