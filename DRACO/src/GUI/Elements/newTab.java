/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Elements;
 
import Gui.Elementos.elementoGlobal;
import GUI.Principal;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask; 
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent; 
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane; 
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
//import javafx.stage.FileChooser;
//import javafx.stage.FileChooser;  

/**
 *
 * @author joseph
 */
public class newTab {

    public TextField barraNavegacion;

    public Button btnOpen;
    public Button btnGuardar;
    public Button btnLeer;
    public Button btnGenerar;

//    public tablaErrores tablaErrores;

    public TextArea entrada = new TextArea("");//tengo que abrir el archivo 

    public TextArea entradCodigo = new TextArea("");//tengo que abrir el archivo 

    Tab tab = new Tab("tab1");
    AnchorPane contenedor = new AnchorPane();//padre

    AnchorPane padreWeb = new AnchorPane();

    TabPane tabConsola = new TabPane();//donde se carga la consola

    Tab tabTerminal = new Tab();
    Tab tabErro = new Tab();
    Tab tabExcel = new Tab();

    public String nombreArchivo="";
    
    AnchorPane areaWeb = new AnchorPane();

    
    
    WebView webview = new WebView();
        
    public newTab() {

//        tablaErrores = new tablaErrores();

    }

    public Tab retornaTab() {

        crearSplit();

//        crearAreaWeb();
//        crearParteCosola();
        tab.setContent(contenedor);
//        setTabCJS("Consola Error");
        crearNavegacion();
        setTabErroes();
        //setTabTerminal();
        setTabExcel();
//        setTabCHMTL("hola.jpg");
        return tab;
    }

    public void setTabErroes() {
        tabErro = new Tab("Errores");
        AnchorPane paneConsolaError = new AnchorPane();
        tabErro.setContent(paneConsolaError);
        tabConsola.getTabs().add(tabErro);
    }

    public void setTabExcel() {
        tabExcel = new Tab("Consola");
        AnchorPane paneConsolaError = new AnchorPane();
        tabExcel.setContent(paneConsolaError);
        tabConsola.getTabs().add(tabExcel);
    }

    public void setTabTerminal() {
        tabTerminal = new Tab("Consola");
        AnchorPane paneConsolaError = new AnchorPane();
        tabTerminal.setContent(paneConsolaError);
        tabConsola.getTabs().add(tabTerminal);
    }

    public void crearNavegacion() {
        btnOpen = new Button("Abrir");

        btnGuardar = new Button("Gudardar");
        btnLeer = new Button("Leer");
        btnGenerar = new Button("Generar");

        barraNavegacion = new TextField("");

        //accionBtnIr(btnLeer, barraNavegacion);
        AnchorPane.setLeftAnchor(btnOpen, 2.0);
        AnchorPane.setLeftAnchor(btnGuardar, 70.0);
        AnchorPane.setLeftAnchor(barraNavegacion, 205.0);

        AnchorPane.setRightAnchor(barraNavegacion, 130.0);
        AnchorPane.setRightAnchor(btnLeer, 90.0);
        AnchorPane.setRightAnchor(btnGenerar, 10.0);

        AnchorPane.setTopAnchor(btnOpen, 10.0);
        AnchorPane.setTopAnchor(btnGuardar, 10.0);
        AnchorPane.setTopAnchor(btnLeer, 10.0);
        AnchorPane.setTopAnchor(btnGenerar, 10.0);
        AnchorPane.setTopAnchor(barraNavegacion, 10.0);

        contenedor.getChildren().add(btnOpen);
        contenedor.getChildren().add(btnGuardar);
        contenedor.getChildren().add(btnLeer);
        contenedor.getChildren().add(btnGenerar);
        contenedor.getChildren().add(barraNavegacion);

        btnOpen.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(Principal.sta);
            
            if (file != null) {
                try {
                    nombreArchivo=file.getName();
                    
                    String fileAsString = file.toString();
                    barraNavegacion.setText(fileAsString);
                    FileReader fileReader;

                    fileReader = new FileReader(fileAsString);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String salida="";
                    String line = null;
                    while((line = bufferedReader.readLine()) != null) {
                        //System.out.println(line);
                        salida+="\n"+line;
                    }   
                    
                    this.setTextCode(salida);
 
                } catch (FileNotFoundException ex) {
                    println(ex.getMessage());
                } catch (IOException ex) {
                    println(ex.getMessage());
                }
            }

        });

        this.accBtnGenerar();
        this.accBtnLeer();
        this.accBtnGuardar();

    }

    public void crearSplit() {
        SplitPane split = new SplitPane();
        split.setOrientation(Orientation.VERTICAL);

        split.setDividerPositions(0.9);
        AnchorPane.setBottomAnchor(split, 2.0);
        AnchorPane.setLeftAnchor(split, 2.0);
        AnchorPane.setRightAnchor(split, 2.0);
        AnchorPane.setTopAnchor(split, 40.0);

        crearAreaWeb(split);
        crearParteCosola(split);
        contenedor.getChildren().add(split);

    }

    public void crearAreaWeb(SplitPane split) {
        areaWeb = new AnchorPane();

        TextField textField = new TextField("adfdasf");

        areaWeb.getChildren().add(textField);

        ScrollPane scroll = new ScrollPane();

        AnchorPane.setBottomAnchor(scroll, 0.0);
        AnchorPane.setLeftAnchor(scroll, 0.0);
        AnchorPane.setRightAnchor(scroll, 0.0);
        AnchorPane.setTopAnchor(scroll, 0.0);

        AnchorPane.setBottomAnchor(areaWeb, 10.0);
        AnchorPane.setLeftAnchor(areaWeb, 40.0);
        AnchorPane.setRightAnchor(areaWeb, 10.0);
        AnchorPane.setTopAnchor(areaWeb, 10.0);

//        AnchorPane panAreaWeb=new AnchorPane();
//        //scroll.get
//        panAreaWeb.setStyle("-fx-background-color: blue;");
//        
//        panAreaWeb.setPrefSize(400, 300);
//        scroll.setContent(panAreaWeb);
//        VBox panAreaWeb = new VBox();
//        padreWeb.setStyle("-fx-background-color: red;");
        padreWeb.setPrefWidth(400);

//        padreWeb.setPrefHeight(400);
//        Label la=new Label("hola");
//        padreWeb.getChildren().add(la);
//        padreWeb.setPrefSize(400, 300);
        redimensionar(scroll, padreWeb);

        scroll.setContent(padreWeb);

        areaWeb.getChildren().add(scroll);
        split.getItems().add(areaWeb);
    }

    public void crearParteCosola(SplitPane split) {
        AnchorPane areaConsola = new AnchorPane();

        tabConsola = new TabPane();
        tabConsola.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
        AnchorPane.setBottomAnchor(tabConsola, 0.0);
        AnchorPane.setLeftAnchor(tabConsola, 0.0);
        AnchorPane.setRightAnchor(tabConsola, 0.0);
        AnchorPane.setTopAnchor(tabConsola, 0.0);
        areaConsola.setPrefSize(400, 300);
        areaConsola.getChildren().add(tabConsola);

        split.getItems().add(areaConsola);
    }

    public void redimensionar(ScrollPane scro, AnchorPane pan) {
        final ChangeListener<Number> listener = new ChangeListener<Number>() {
            final Timer timer = new Timer(); // uses a timer to call your resize method
            TimerTask task = null; // task to execute after defined delay
            final long delayTime = 200; // delay that has to pass in order to consider an operation done

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {

                pan.setPrefWidth(scro.getWidth() - 10);
//                 pe.setPrefSize(sta.getWidth(), sta.getHeight());
            }
        };
        scro.widthProperty().addListener(listener);

//         sta.heightProperty().addListener(listener);
    }

    /*
    |--------------------------------------------------------------------------
    | acciones de los botones
    |-------------------------------------------------------------------------- 
     */
    public void accBtnGuardar() {
        this.btnGuardar.setOnAction((ActionEvent event) -> {
            this.accGuardar();
        });
    }

    public void accBtnLeer() {
        this.btnLeer.setOnAction((ActionEvent event) -> {
            this.accLeer();
        });
    }

    public void accBtnGenerar() {
        this.btnGenerar.setOnAction((ActionEvent event) -> {
            this.accGenerar();

        });
    }

    /*
    |--------------------------------------------------------------------------
    | acciones de los botones
    |-------------------------------------------------------------------------- 
     */
    public void accGuardar() {

    }

    public void accLeer() {

    }

    public void accGenerar() {

    }

    /*
    |--------------------------------------------------------------------------
    | Getter and Setters
    |-------------------------------------------------------------------------- 
     */
    public TextField getBarraNavegacion() {
        return barraNavegacion;
    }

    public void setBarraNavegacion(TextField barraNavegacion) {
        this.barraNavegacion = barraNavegacion;
    }


    /*
    |--------------------------------------------------------------------------
    | Getter and Setters
    |-------------------------------------------------------------------------- 
     */
    public void setTextTabExcel(String texto) {

        entrada.setText(texto);
      
        entrada.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;"); 
//        TextArea lineas2 = new TextArea();
        String numeros = "";
        for (int i = 0; i < 999; i++) {
            numeros += String.valueOf(i) + "\n";
        }
//        lineas.setText(numeros);
//        entrada.scrollTopProperty().addListener((obs, oldVal, newVal) -> {
//            lineas.setScrollTop((double) newVal);
//        });

//        lineas.setEditable(false);
//        lineas.setDisable(true);
        AnchorPane ctn = new AnchorPane();

//        contenido.setStyle("-fx-background-color: green;");
        AnchorPane.setBottomAnchor(entrada, 10.0);
        AnchorPane.setLeftAnchor(entrada, 40.0);
        AnchorPane.setRightAnchor(entrada, 10.0);
        AnchorPane.setTopAnchor(entrada, 10.0);

//        AnchorPane.setBottomAnchor(lineas, 10.0);
//        AnchorPane.setLeftAnchor(lineas, 0.0);
//        AnchorPane.setTopAnchor(lineas, 10.0);
//        ctn.getChildren().setAll(lineas, entrada);
        ctn.getChildren().setAll(entrada);

        tabExcel.setContent(ctn);

    }

    /*
    |--------------------------------------------------------------------------
    | Code editor
    |-------------------------------------------------------------------------- 
     */
    public void setTextCode(String texto) {

        String editingCode = texto;
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
        webview.getEngine().loadContent(editingTemplate);
        
        
        AnchorPane.setBottomAnchor(webview, 10.0);
        AnchorPane.setLeftAnchor(webview, 10.0);
        AnchorPane.setRightAnchor(webview, 10.0);
        AnchorPane.setTopAnchor(webview, 10.0);
        areaWeb.getChildren().setAll(webview);
        
 
    }

    public void setTextCode2(String texto) {

        entradCodigo.setText(texto);
        TextArea lineas2 = new TextArea();
        String numeros = "";
        for (int i = 0; i < 999; i++) {
            numeros += String.valueOf(i) + "\n";
        }
        lineas2.setText(numeros);
        entradCodigo.scrollTopProperty().addListener((obs, oldVal, newVal) -> {
            lineas2.setScrollTop((double) newVal);
        });

        lineas2.setEditable(false);
        lineas2.setDisable(true);

//        contenido.setStyle("-fx-background-color: green;");
        AnchorPane.setBottomAnchor(entradCodigo, 10.0);
        AnchorPane.setLeftAnchor(entradCodigo, 40.0);
        AnchorPane.setRightAnchor(entradCodigo, 10.0);
        AnchorPane.setTopAnchor(entradCodigo, 10.0);

        AnchorPane.setBottomAnchor(lineas2, 10.0);
        AnchorPane.setLeftAnchor(lineas2, 0.0);
        AnchorPane.setTopAnchor(lineas2, 10.0);
        areaWeb.getChildren().setAll(lineas2, entradCodigo);
        // areaWeb.getChildren().setAll(entradCodigo);

    }

//    public tablaErrores getTablaErrores() {
////        return tablaErrores;
//    }

    /*
    |--------------------------------------------------------------------------
    | Pintar la tabla de errores prro
    |-------------------------------------------------------------------------- 
     */
    public void showTableErrors(elementoGlobal simbolo) {
        //this.tablaErrores.imprimir();
        cError consolaErr = new cError(simbolo);
        tabErro.setContent(consolaErr.retornarTabla());

    }
    
    
    
    /*
    |--------------------------------------------------------------------------
    | Imprimir
    |-------------------------------------------------------------------------- 
     */
    
    
    public void println(String mesaje){
        System.out.println("[newTab]"+mesaje);
    }
    
    
}
