/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Lienzo;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;

/**
 * FXML Controller class
 *
 * @author joseph
 */
public class Lienzo implements Initializable {

    
    
    @FXML
    public Label lblDraco;
    
    
    @FXML
    public AnchorPane apLienzo;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        pintarPunto(2, 20, "", 90);
//            pintarRectangulo(20, 50, "blue", 10, 40);
    }    
    
    public void limpiarLienzo(){
        
        Platform.runLater(() -> {
            apLienzo.getChildren().clear();
        });
    }
    
    
    /**<br>+----------------------------------------------------
     * <br>| Metodo para ir pintando en el lienzo
     * <br>+---------------------------------------------------- 
     * <br>|
     */   
    
    
    /**
     * Pinta un circulo en el lienzo
     * @param posx Posicion central en x
     * @param posY Posicion central en Y
     * @param color Color del cirulo
     * @param diametro  Diametro del cirulo
     */
    public void pintarPunto(int posx, int posY, String color, int diametro) {
        Platform.runLater(() -> {

            Circle punto = new Circle();

            punto.setCenterX(posY);
            punto.setCenterY(posY);
            punto.setRadius(diametro / 2);

            punto.setStyle("-fx-fill: " + color + "; -fx-stroke:" + color + ";");
            apLienzo.getChildren().add(punto);
        });

    }
    
    /**
     * Pinta un rectángulo en el linezo
     * @param posX Posicion inicial en X 
     * @param posY Posicion inicial en Y
     * @param color Color del rectangulo
     * @param ancho Ancho del rectangulo
     * @param alto  Algo del rectangulo
     */
    public void pintarRectangulo(int posX, int posY, String color, int ancho, int alto) {
        Platform.runLater(() -> {
            Rectangle rectangulo = new Rectangle();
            rectangulo.setHeight(alto);
            rectangulo.setWidth(ancho);

            rectangulo.setX(posX);
            rectangulo.setY(posY);

            rectangulo.setStyle("-fx-fill: " + color + "; -fx-stroke:" + color + ";");
            apLienzo.getChildren().add(rectangulo);
        });

    }
    
    /**
     * Pinta un ovalo
     * @param posX Posición x 
     * @param posY Posición y donde se quiere pintar el ovalo
     * @param color Color del ovalo
     * @param ancho Ancho del ovalo
     * @param alto  Alto del óvalo
     */
    public void pintarOvalo(int posX, int posY, String color, int ancho, int alto) {
        Platform.runLater(() -> {
            Ellipse elipse = new Ellipse();
            elipse.setCenterX(posX + (ancho / 2));
            elipse.setCenterY(posY + (alto / 2));
            elipse.setRadiusX(ancho / 2);
            elipse.setRadiusY(alto / 2);

            elipse.setStyle("-fx-fill: " + color + "; -fx-stroke:" + color + ";");
            apLienzo.getChildren().add(elipse);
        });

    }
    
    /**
     * Pinta una cadena en el lienzo
     * @param posX Posición inicial donde se quiere colocar el texto
     * @param posY Posicion en y donde se quiere colocar el texto
     * @param color Color del texto
     * @param cadena  Texto que se desea mostrar
     */
    public void pintarString(int posX, int posY, String color, String cadena) {
        Platform.runLater(() -> {
            Label lab = new Label(cadena);
            lab.setLayoutX(posX);
            lab.setLayoutY(posY);
            lab.setStyle("-fx-text-fill: " + color + "; -fx-font-size:20;-fx-font-weight:bold;");
            apLienzo.getChildren().add(lab);
        });

    }
    
    /**
     * Pinta una linea
     * @param posXi Posicion en x inicial
     * @param posYi Posicion en y inicial
     * @param posXf Posición en X final
     * @param posYf Posición en Y final
     * @param color Color de la línea
     * @param grosor El grosor de la linea
     */
    public void pintarLinea(int posXi, int posYi, int posXf, int posYf, String color, int grosor) {
        Platform.runLater(() -> {
            Line linea = new Line();
            linea.setStartX(posXi);
            linea.setStartY(posYi);
            linea.setEndX(posXf);
            linea.setEndY(posYf);
            linea.setStrokeWidth(grosor);
            linea.setStyle("-fx-stroke: " + color + ";");
            apLienzo.getChildren().add(linea);
        });
    }

    
}
