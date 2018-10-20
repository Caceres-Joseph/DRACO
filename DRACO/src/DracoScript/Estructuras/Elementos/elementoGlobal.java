/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Elementos;
 
import DracoScript.Estructuras.Tablas.tablaErrores; 
import Gui.Elementos.elementoDebug;
import Gui.Elementos.elementoMensaje;
import Gui.Listas.lstTabClase; 
import javafx.scene.control.TextArea; 


/**
 *
 * @author joseph
 */
public class elementoGlobal {
    /**
     * DRACO SCRIPT
     */
    
    public tablaErrores tablaErrores = new tablaErrores();
    public TextArea txtConsola;
     
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
    
    /**
     * Para el debug
     */
    
    public boolean modoDebug=false;
    
    
    /**
     * 
     * @param mensaje
     * @param listaTabsClases
     * @param txtConsola 
     */
    
    public elementoGlobal(elementoMensaje mensaje,lstTabClase listaTabsClases, TextArea txtConsola){
        this.txtConsola=txtConsola;
        this.mensaje=mensaje;
        this.listaTabsClases=listaTabsClases; 
        
//        this.hiloEjecucion=new elementoHilo(this); 

    }
    
    public void setConsola(String contenido){
        txtConsola.setText(txtConsola.getText()+contenido);
    }

     
}
