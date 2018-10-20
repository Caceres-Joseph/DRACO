/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Nodos;

/**
 *
 * @author joseph
 */
public class nodoPuntoInterrupcion {
    
    public String nombreArchivo;
    public int linea;
    
    
    public nodoPuntoInterrupcion(String nombreArchivo, int linea )
    {
        this.nombreArchivo=nombreArchivo;
        this.linea=linea+1;
        
        
    }    
}
