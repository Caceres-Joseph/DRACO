/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Gramatica.Analizador;

import D_plus.Gramatica.Lexico.LexerDplusPlus;
import D_plus.Gramatica.Sintactico.parser;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal; 
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author joseph
 */
public class anlzDplusPlus {
    
    public String entrada = "";
    public String nombreArchivo;
    public elementoGlobal simbolo;
    
    public nodoModelo raiz;
    /**
     * 
     * @param cadena La cadena que se va analizar
     * @param nombreArchivo Es el nombre del archivo del que viene
     * @param simbolo Es la tabla que se va psando entre los demás nodos
     */
    
    public anlzDplusPlus(String cadena, String nombreArchivo, elementoGlobal simbolo) {
        this.entrada = cadena;
        this.simbolo=simbolo;
        this.nombreArchivo = nombreArchivo;
//        println("[anlzDplusPlus]"+nombreArchivo);
    }

    public void analizar() {

        //File file = new File("entradaChtml.cs");
//            FileReader fr = new FileReader(file);
//        println(this.entrada);
        Reader reader = new StringReader(this.entrada);
        LexerDplusPlus lex;
        
        lex = new LexerDplusPlus(reader);
        lex.iniciar(simbolo, nombreArchivo) ;
        parser p = new parser(lex);
        p.iniciar(simbolo, nombreArchivo);
        
//            System.out.println("+------------------------------------------------+");
        try {
            p.parse();
            raiz= p.raiz; 
            println("[DplusPlus]Build successful ");
            
            System.out.println("");
        } catch (Exception e) {
            println("Error :( ||"+e.getMessage());
            System.out.println("");
            raiz=null;
        } 
//            System.out.println("+------------------------------------------------+");
         
    }

    public void println(String mensaje) {
        System.out.println("[anlzDplusPlus]" + mensaje);
    }
}
