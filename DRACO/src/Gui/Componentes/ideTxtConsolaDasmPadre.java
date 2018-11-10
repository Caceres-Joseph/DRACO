/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

/**
 *
 * @author joseph
 */
public class ideTxtConsolaDasmPadre {
    TextArea txtDasm; 
    WebView wbSalidaDasm;
    
    
    public ideTxtConsolaDasmPadre(TextArea txtDasm, WebView wbSalidaDasm){
        this.txtDasm=txtDasm;
        this.wbSalidaDasm=wbSalidaDasm;
        String editingTemplate="";
        try {            
            editingTemplate = new String(Files.readAllBytes(Paths.get("src/Gui/Nodos/nodoEditorDasm.html")));
        } catch (IOException ex) {
            println("[crearEditor][Error]"+ex.getMessage());
        }
        
//        editingTemplate=  editingTemplate.replace("${code}", editingCode);
        wbSalidaDasm.getEngine().loadContent(editingTemplate);
        
    }
    
    /**
     * Escribe en la consola dasm
     * @param salida 
     */
//    public void setText(String salida){
//        
//    }
    
    
    
    
    
    public void comentarioGrande(String salida){
        String escribir="\n"+
                    "/*\n" +
                    "|-------------------------------------------------------------------------------------------------------------------\n" +
                    "| " + salida+"\n"+
                    "|-------------------------------------------------------------------------------------------------------------------\n" +
                    "|  \n" +
                    "*/"; 
        writeAdd(escribir);
    }
    
    public void comentarioMediano(String salida){
        
        String escribir="\n"+
                    "/*\n" +
                    "|-------------------------------------------------\n" +
                    "| " + salida+"\n"+
                    "*/"; 
        writeAdd(escribir);
    }
    
    public void comentarioPequeño(String lineaSuperior, String lineaInferior, int nivel){
        String tabs="";
        for (int i = 0; i < nivel; i++) {
            tabs=tabs+"\t";
        }
        String escribir="\n"+
                    tabs+"/*\n" +
                    tabs+"+----------------------\n" +
                    tabs+"| " + lineaSuperior+"\n"+
                    tabs+"+----------------------\n"+
                    tabs+"| " + lineaInferior+"\n"+
                    tabs+"*/"; 
        writeAdd(escribir);
        
    }
    
    public void lineaComentada(String linea, String comentario, int nivel){
        String tabs="";
        for (int i = 0; i < nivel; i++) {
            tabs=tabs+"\t";
        }
        String escribir="\n"+tabs+"//"+comentario+"\n"+tabs+linea;
        writeAdd(escribir);
    }
    public void comentario( String comentario, int nivel){
        String tabs="";
        for (int i = 0; i < nivel; i++) {
            tabs=tabs+"\t";
        }
        String escribir="\n"+tabs+"//"+comentario;
        writeAdd(escribir);
    }
    
    public void linea(String linea, int nivel){
        String tabs="";
        for (int i = 0; i < nivel; i++) {
            tabs=tabs+"\t";
        }
        String escribir="\n"+tabs+linea;
        writeAdd(escribir);
    }
    
     
    
    public void println(String mensaje){
        System.out.println("[ideTxtConsolaDasm]"+mensaje);
    }
    
    
/*
+------------------------------------------------+
|   Text Area
+------------------------------------------------+
*/
    public void writeAdd(String mensaje){
        
        Platform.runLater(() -> { 
            txtDasm.setText(txtDasm.getText() + mensaje);
            String tal= txtDasm.getText();
//            writeAddWeb(tal);

            //enviando el scroll hast abajo
//            txtDasm.selectPositionCaret(txtDasm.getLength()); 
//            txtDasm.deselect();
                  
        }); 
    }
    /**
     * Limpia la consola
     */
    public void clear(){
        Platform.runLater(() -> { 
            txtDasm.setText(""); 
        });
//        clearWeb();
    }
     
/*
+------------------------------------------------+
|   Web View
+------------------------------------------------+
*/
    
    public void writeAddWeb(String mensaje){ 
             try {
                 
                wbSalidaDasm.getEngine().executeScript("editor.setValue(\""+mensaje+"\");"); 
             } catch (Exception e) {
                 println("[writeAddWeb][ERROR]"+e.getMessage());
             } 
    }
    
    public void clearWeb(){
         Platform.runLater(() -> {   
             try { 
               wbSalidaDasm.getEngine().executeScript("editor.setValue();");
             } catch (Exception e) {
                 println("[writeAddWeb][ERROR]"+e.getMessage());
             }
            
        }); 
    }
    
       /*
        +------------------------------------------------+
        | COMANDOS DASM
        +------------------------------------------------+
        */
//    String get_local = "get_local";
//    String set_local = "set_local";
//    String calc = "$calc";
//    String add = "ADD";

//    public void get_local(int pos, int nivel) {
//        lineaComentada(get_local + " " + String.valueOf(pos), "Puntero de ambito actual", nivel);
//    }
//
//    public void set_local_calc(int nivel) {
//
//        lineaComentada(set_local + " " + calc, "Guardando", nivel);
//    }
//
//    public void add(String comentario, int nivel) {
//
//        lineaComentada(add, comentario, nivel);
//    }

}
