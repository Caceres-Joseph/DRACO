/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno; 
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class funcion extends extra {
    
    public funcion(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    
    /**
     * <br> +----------------
     * <br> | tCall valId
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe 
     */
    public void case_24(elementoEntorno entorno) {
        if (hayErrores()) {
            return;
        }

        itemAtributo respuesta = listaAtributos.getAtributo(0);
        if (respuesta.valLower.equals("$point")) {
            point(entorno);
        } else if (respuesta.valLower.equals("$quadrate")) {
            quadrate(entorno);
        } else if (respuesta.valLower.equals("$oval")) {
            oval(entorno);
        } else if (respuesta.valLower.equals("$line")) {
            line(entorno);
        } else {
            if (entorno.listaFunciones != null) {
                //guardando el puntero de codigo
                int punteroTemp = entorno.punteroCodigo;
                //pongo el puntero en cero
                entorno.punteroCodigo = 0;
                entorno.listaFunciones.ejecutarFuncion(respuesta, entorno);

                //regreso el valor del puntero de código
                entorno.punteroCodigo = punteroTemp;
            } else {
                println("[case_24][ERROR]La clase que contiene las funciones es nula");
            }
        }

    }
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $point
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno  
     */
    public void point(elementoEntorno entorno){ 
        if (hayErrores()) 
            return ;  
        
        //diametro
        Double diametro = entorno.Pilita.pop(atributo);
        //color
        Double color = entorno.Pilita.pop(atributo);
        //ṕosY
        Double posY = entorno.Pilita.pop(atributo);
        //posX
        Double posX = entorno.Pilita.pop(atributo);
        
        
        simbolo.ctrlLienzo.pintarPunto(posX.intValue(), posY.intValue(), getHexa(color), diametro.intValue());
        
    }
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $quadrate
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno  
     */
    public void quadrate(elementoEntorno entorno){ 
        if (hayErrores()) 
            return ;  
        
        //alto
        Double alto = entorno.Pilita.pop(atributo);
        //ancho
        Double ancho = entorno.Pilita.pop(atributo);
        //color
        Double color = entorno.Pilita.pop(atributo);
        //ṕosY
        Double posY = entorno.Pilita.pop(atributo);
        //posX
        Double posX = entorno.Pilita.pop(atributo);
        
        simbolo.ctrlLienzo.pintarRectangulo(posX.intValue(), posY.intValue(), getHexa(color),ancho.intValue(), alto.intValue()); 
       
    }
    
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $oval
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno  
     */
    public void oval(elementoEntorno entorno){ 
        if (hayErrores()) 
            return ;  
        
        //alto
        Double alto = entorno.Pilita.pop(atributo);
        //ancho
        Double ancho = entorno.Pilita.pop(atributo);
        //color
        Double color = entorno.Pilita.pop(atributo);
        //ṕosY
        Double posY = entorno.Pilita.pop(atributo);
        //posX
        Double posX = entorno.Pilita.pop(atributo); 
        
        simbolo.ctrlLienzo.pintarOvalo(posX.intValue(), posY.intValue(), getHexa(color),ancho.intValue(), alto.intValue()); 
         
    }
    
    
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $line
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno  
     */
    public void line(elementoEntorno entorno){ 
        if (hayErrores()) 
            return ;  
        
        
        //grosor
        Double grosor = entorno.Pilita.pop(atributo);
        //color
        Double color = entorno.Pilita.pop(atributo); 
        //ṕosYf
        Double posYf = entorno.Pilita.pop(atributo);
        //posXf
        Double posXf = entorno.Pilita.pop(atributo); 
        //ṕosYi
        Double posYi = entorno.Pilita.pop(atributo);
        //posXi
        Double posXi = entorno.Pilita.pop(atributo); 
        
        
        simbolo.ctrlLienzo.pintarLinea(posXi.intValue(), posYi.intValue(), posXf.intValue(),posYf.intValue(), getHexa(color), grosor.intValue());
    
    }
    
    
    

    
    
    /**
     * <br> | Retorna una cadena en hexadecimal
     * @param valor Valor hexadecimal representado en entero
     * @return 
     */
     public String getHexa(Double valor) {
         
        int hex = valor.intValue();
        String al = Integer.toHexString(hex);

        int diferencia = 6 - al.length();

        String cadena = "";
        if (diferencia != 0) {
            for (int i = 0; i < diferencia; i++) {
                cadena += "0";
            }
        }
        
        return "#" + cadena + al.toUpperCase(); 
    }
    
}
