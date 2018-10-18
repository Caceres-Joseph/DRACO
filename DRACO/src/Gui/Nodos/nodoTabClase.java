/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Nodos;
 
import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Gramatica.Analizador.anlzDracoScript;
import DracoScript.Nodos.nodoModelo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

/**
 *
 * @author joseph
 */
public class nodoTabClase {
    
    public String ruta="";
    public String nombre="";
    public AnchorPane panelPadre = new AnchorPane();
    public Tab nuevaTab=new Tab();
    public WebView areaWeb;
    public elementoGlobal simbolo;
    
    public String extension="";
    public String contenidoArchivo="";
    
    public nodoModelo raiz;
    public nodoTabClase(String ruta, String nombre,String extension, elementoGlobal simbolo){
        this.ruta=ruta;
        this.simbolo=simbolo;
        this.nombre=nombre;
        this.extension=extension;
        nuevaTab = new Tab(nombre); 
        nuevaTab.setContent(panelPadre); 
        areaWeb=new WebView();
        areaWeb.getStylesheets().add("/Gui/Estilos/Metro-UI.css");
        
        leerArchivo();
        crearEditor();
        
    }
    
    public void leerArchivo() {
        try { 
            contenidoArchivo = new String(Files.readAllBytes(Paths.get(ruta)));
        } catch (IOException e) {
            simbolo.mensaje.informacion("Error al leer", "No se pudo leer el archivo");
            println("[leerArchivo]"+e.getMessage());
        }
    }
    
    
    /**
     * Metodo que crea el edito de texto 
     */
    public void crearEditor(){
        
        String editingCode = contenidoArchivo;
        String editingTemplate
                = "<!doctype html>"
                + "<html>"
                + "<head>"
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/lib/codemirror.css\">"
                + "  <script src=\"http://localhost:400/lib/codemirror.js\"></script>"
                + "  <script src=\"http://localhost:400/lib/jquery.js\"></script>"
                
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/theme/base16-light.css\">"
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/theme/idea.css\">"
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/theme/eclipse.css\">"
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/theme/tomorrow-night-eighties.css\">"
                + "  <link rel=\"stylesheet\" href=\"http://localhost:400/theme/darcula.css\">"
                
                
                + "  <script src=\"http://localhost:400/mode/clike/clike.js\"></script>"
                + "  <script src=\"http://localhost:400/mode/javascript/javascript.js\"></script>"
                + "  <script src=\"http://localhost:400/addon/selection/active-line.js\"></script>"
                + "  <script src=\"http://localhost:400/addon/edit/matchbrackets.js\"></script>"
                + "  <script src=\"http://localhost:400/addon/selection/mark-selection.js\"></script>"
                + "  <script src=\"http://localhost:400/addon/search/searchcursor.js\"></script>"
                + //    "  <script src=\"http://localhost:400/addon/edit/closetag.js\"></script>" +
                "  <script src=\"http://localhost:400/addon/selection/selection-pointer.js\"></script>"
                + "<style>\n"
//                + "      .CodeMirror {border-top: 1px solid black; border-bottom: 1px solid black;}\n"
//                + "      .CodeMirror-selected  { background-color: blue !important; }\n"
                + "      .CodeMirror-selectedtext { color: white; }\n"
//                + "      .styled-background { background-color: #ff7; }\n"
                + "      .breakpoints {width: .13em;}\n"
                + "      .breakpoint { color: #822; }\n"
                + "      .CodeMirror {border: 0px solid #aaa;height: auto;}"
                + "    </style>"
                + "<script>"
                + "var   i=1;"
                + "function mostrar() {\n"
                + "  i++;\n"
//                + "  editor.addLineClass(i, 'wrap', 'CodeMirror-activeline-error');"
                + "  alert(\"hola prros\");\n"
                + "  editor.markText({line: 3, ch: 2}, {line: 3, ch: 7}, {className: \"styled-background\"});"
                + "   return \"hola viejo\";"
                + //"   editor.setLineClass(2, 'background', 'line-error');"+
                "}"
                + "</script>"
                + "</head>"
                + "<body onload=\"mostrar();\">"
                + "<form><textarea id=\"code\" name=\"code\">\n"
                + "${code}"
                + "</textarea></form>"
                + "<script>"
                + "  var editor = CodeMirror.fromTextArea(document.getElementById(\"code\"), {"
                + "    lineNumbers: true,"
                + "    matchBrackets: true,"
                + "    viewportMargin: Infinity,"
                
//                + "    mode: \"text/x-java\","
                + "    mode: \"text/javascript\","
                + "    theme: \"eclipse\"," 
//                + "    theme: \"darcula\","
//                +    "    theme: \"base16-light\","
                //    "    theme: \"tomorrow-night-eighties\","+
                + "    indentWithTabs:true, "
                + "    lineWrapping: true, "
                
                + "    tabSize: 4, "
                + "    gutters: [\"CodeMirror-linenumbers\", \"breakpoints\"], "
                + "    styleSelectedText: true, "
                + "    styleActiveLine: true "
                + "  });"
                + "editor.on(\"gutterClick\", function(cm, n) {\n"
                + "  i++;\n"
                + "  var info = cm.lineInfo(n);\n"
                + "  cm.setGutterMarker(n, \"breakpoints\", info.gutterMarkers ? null : makeMarker());\n"
                + "});\n"
                + "\n"
                + "function makeMarker() {\n"
                + "  var marker = document.createElement(\"div\");\n"
                + "  marker.style.color = \"#822\";\n"
                + "  marker.innerHTML = \"●\";\n"
                + "  return marker;\n"
                + "}"
                + "</script>"
                + "</body>"
                + "</html>";
        
        editingTemplate=  editingTemplate.replace("${code}", editingCode);
        areaWeb.getEngine().loadContent(editingTemplate);
        
        
        AnchorPane.setBottomAnchor(areaWeb, 10.0);
        AnchorPane.setLeftAnchor(areaWeb, 10.0);
        AnchorPane.setRightAnchor(areaWeb, 10.0);
        AnchorPane.setTopAnchor(areaWeb, 10.0);
        panelPadre.getChildren().setAll(areaWeb);
        
    }

    public void ejecutar(){
        if(extension.equals("djs")){
            //ejecuto draco Script
            ejecutarDjs();
        }else{
            
        }
    }
    
    public void ejecutarDjs(){
        String salida = (String ) areaWeb.getEngine().executeScript("editor.getValue();");
        
        anlzDracoScript dra=new anlzDracoScript(salida, nombre, simbolo);
        dra.analizar();
        raiz=dra.raiz;
        
        elementoEntorno entornoGlobal=new elementoEntorno(null, "global", simbolo);
        
        if(raiz!=null){
            raiz.ejecutar(entornoGlobal);
        }else{
            println("Raiz nula");
        }
    }
    
    /**
     * Retorna la nueva tab
     * @return 
     */
    public Tab getNuevaTab() {
        return nuevaTab;
    }
     
    
    public void println(String mensaje){
        System.out.println("[nodoTabClase]"+mensaje);
    }
    
}
