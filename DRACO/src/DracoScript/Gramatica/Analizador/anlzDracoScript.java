/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Gramatica.Analizador;

import DracoScript.Estructuras.Elementos.elementoGlobal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import DracoScript.Gramatica.Lexico.*;
import DracoScript.Gramatica.Sintactico.parser;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author joseph
 */
public class anlzDracoScript {

    public String entrada = "";
    public String nombreArchivo;
    public elementoGlobal simbolo;
    
    /**
     * 
     * @param cadena La cadena que se va analizar
     * @param nombreArchivo Es el nombre del archivo del que viene
     * @param simbolo Es la tabla que se va psando entre los demás nodos
     */
    
    public anlzDracoScript(String cadena, String nombreArchivo, elementoGlobal simbolo) {
        this.entrada = cadena;
        this.simbolo=simbolo;
        this.nombreArchivo = nombreArchivo;
    }

    public void analizar() {

        //File file = new File("entradaChtml.cs");
//            FileReader fr = new FileReader(file);
        Reader reader = new StringReader(this.entrada);
        LexerDracoScript lex;
        lex = new LexerDracoScript(reader);
        parser p = new parser(lex);
        p.iniciar(simbolo, entrada);
        try {
            p.parse();
            println("[DracoScript]Build successful");
        } catch (Exception e) {
            println("Error :(");
        }

    }

    public void println(String mensaje) {
        System.out.println("[anlzDracoScript]" + mensaje);
    }
}