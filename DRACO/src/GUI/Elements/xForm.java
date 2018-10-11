/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Elements;
 
import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Gramatica.Analizador.anlzDracoScript;
import DracoScript.Nodos.nodoModelo;
import GUI.Principal; 
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException; 
import javafx.stage.FileChooser; 

/**
 *
 * @author joseph
 */
public class xForm extends newTab {
 
    public nodoModelo raiz;

    public xForm() {

    }

    @Override
    public void accGuardar() {
        guardarArchivo();
    }

    private void guardarArchivo() {
        try {
            //String nombre = "";
            //FileChooser file = new FileChooser();
            //file.showSaveDialog("");
            //File guarda = file.getSelectedFile();
            FileChooser fileChooser = new FileChooser();
            File guarda = fileChooser.showSaveDialog(Principal.sta);
            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
    *           si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + ".xform");
//                save.write(tree.salida);
                save.close();
                System.out.println("Guardado exitosamente");
            }
        } catch (IOException ex) {
            System.out.println("no se guardo");
        }
    }

    @Override
    public void accLeer() {

        elementoGlobal elmento=new elementoGlobal();
        
        String salida = (String ) webview.getEngine().executeScript("editor.getValue();");
        //System.out.println(salida);
        anlzDracoScript dra=new anlzDracoScript(salida, nombreArchivo, elmento);
        dra.analizar();
        raiz=dra.raiz;
        
        elementoEntorno entornoGlobal=new elementoEntorno(null, "global", elmento);
        
        if(raiz!=null){
            raiz.ejecutar(entornoGlobal);
        }else{
            println("Raiz nula");
        }
        
        this.setTextTabExcel(elmento.txtConsola);
        this.showTableErrors(elmento);
        
        
        
        
//        InputStream stream = new ByteArrayInputStream(this.entrada.getText().getBytes(StandardCharsets.UTF_8));
//        parser par = new parser();
//        par.arbol.tablaSimbolos.tablaErrores = this.tablaErrores;
//        par.inicializar(stream);
//
//        //this.tablaErrores.concat(par.raiz.tablaSimbolos.tablaErrores);
//        this.showTableErrors();
//        this.arbol = par.arbol;
    }

    @Override
    public void accGenerar() {
//        tree.resetVariables();
//        arbol.raiz.execute();
////        this.showTableErrors();
//        this.setTextCode(tree.salida);
//        
//        tree.imprimirListas();
       
        
        //tree.imprimirVariables();
    }
    @Override
     public void println(String mensaje){
         System.out.println("[xForm]"+mensaje);
     }
    
}
