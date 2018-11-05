/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
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
     * @return Retorna para revisión de break
     */
    public itemRetorno case_24(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }

        itemAtributo respuesta = listaAtributos.getAtributo(0);
        if (respuesta.valLower.equals("$point")) {
            return point(entorno);
        } else if (respuesta.valLower.equals("$quadrate")) {
            return quadrate(entorno);
        } else if (respuesta.valLower.equals("$oval")) {
            return oval(entorno);
        } else if (respuesta.valLower.equals("$line")) {
            return line(entorno);
        } else { 
            if(entorno.clase!=null){
                entorno.clase.listaMetodoFuncion.ejecutarFuncion(respuesta, entorno);
            }else{
                println("[case_24][ERROR]La clase que contiene las funciones es nula");
            } 
            return new itemRetorno();
        }
        
    }
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $point
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno 
     * @return  
     */
    public itemRetorno point(elementoEntorno entorno){
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;  
        
        //diametro
        Double diametro = entorno.Pilita.pop(atributo);
        //color
        Double color = entorno.Pilita.pop(atributo);
        //ṕosY
        Double posY = entorno.Pilita.pop(atributo);
        //posX
        Double posX = entorno.Pilita.pop(atributo);
        
        
        simbolo.ctrlLienzo.pintarPunto(posX.intValue(), posY.intValue(), getHexa(color), diametro.intValue());
        return retorno;
    }
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $quadrate
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno 
     * @return  
     */
    public itemRetorno quadrate(elementoEntorno entorno){
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;  
        
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
        return retorno;
    }
    
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $oval
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno 
     * @return  
     */
    public itemRetorno oval(elementoEntorno entorno){
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;  
        
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
        return retorno;
    }
    
    
    
    
    /** 
     * <br> +----------------
     * <br> | tCall $line
     * <br> +----------------
     * <br> | Recibe cuatro parametros
     * @param entorno 
     * @return  
     */
    public itemRetorno line(elementoEntorno entorno){
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) 
            return retorno;  
        
        
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
        return retorno;
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
