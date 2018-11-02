/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Gramatica.Analizador;

import Dasm.Gramatica.Lexico.LexerDasm; 
import Dasm.Gramatica.Sintactico.parser;
import Dasm.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author joseph
 */
public class anlzDasm {
    
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
    
    public anlzDasm(String cadena, String nombreArchivo, elementoGlobal simbolo) {
        this.entrada = cadena;
        this.simbolo=simbolo;
        this.nombreArchivo = nombreArchivo;
    }

    public void analizar() {
 
        Reader reader = new StringReader(this.entrada);
        LexerDasm lex;
        
        lex = new LexerDasm(reader);
        lex.iniciar(simbolo, nombreArchivo);
       
        try {
            parser p = new parser(lex);
            p.parse();
            raiz= p.raiz; 
            println("[Dasm]Build successful ");
        } catch (ExceptionInInitializerError e) {
            println("[ERROR][ExcInitiaa]"+e.getMessage());
        } catch( NoClassDefFoundError e){
            println("[ERROR][NoclassDef]"+e.getMessage()); 
        }catch( Exception e){
            println("[ERROR]"+e.getMessage()); 
            println("Error :(");
            raiz=null;
        } 
//            System.out.println("+------------------------------------------------+");
         
    }

    public void println(String mensaje) {
        System.out.println("[anlzDasm]" + mensaje);
    }
}
