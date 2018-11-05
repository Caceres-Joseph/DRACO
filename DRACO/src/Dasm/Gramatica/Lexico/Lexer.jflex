package Dasm.Gramatica.Lexico;

import Dasm.Gramatica.Sintactico.*;
import java_cup.runtime.*;
import Gui.Elementos.elementoGlobal;

%%

%class LexerDasm
%public


%unicode
%cup        //no se que es XD
%line       //contador de líneas        
%column     //contadore de columnas
%ignorecase //caseInsensitive

%{
    //Generando symbol para guardar el token encontrado

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    public elementoGlobal simbolo;
    public String nombreArchivo ="";
    public void iniciar(elementoGlobal simbolo, String nombreArchivo){
        this.simbolo=simbolo;
        this.nombreArchivo=nombreArchivo;
    }
%}

/*
*Expresiones regulares
*/
 
    LineTerminator = \r|\n|\r\n
    InputCharacter = [^\r\n]
    WhiteSpace     = {LineTerminator} | [ \t\f]
    TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
    EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
    Comment = {TraditionalComment} | {EndOfLineComment} /*| {DocumentationComment}*/
    Identifier = "$"[:jletter:] [:jletterdigit:]*
    DecIntegerLiteral = 0 | [1-9][0-9]*
    Double          =[0-9]+\.[0-9]+
  

%state STRING

%%

    /*Simbolos*/
   

    /*Palabras*/
    <YYINITIAL>{
        "add"                   {return symbol(sym.tAdd, yytext());}
        "diff"                  {return symbol(sym.tDiff, yytext());} 
        "mult"                  {return symbol(sym.tMult, yytext());} 
        "div"                   {return symbol(sym.tDiv, yytext());} 
        "mod"                   {return symbol(sym.tMod, yytext());}
        "pot"                   {return symbol(sym.tPot, yytext());}  
        "lt"                    {return symbol(sym.tLt, yytext());} 
        "gt"                    {return symbol(sym.tGt, yytext());}
        "lte"                   {return symbol(sym.tLte, yytext());} 
        "gte"                   {return symbol(sym.tGte, yytext());} 
        "not"                   {return symbol(sym.tNot, yytext());} 
        "and"                   {return symbol(sym.tAnd, yytext());} 
        "or"                    {return symbol(sym.tOr, yytext());}
        "br"                    {return symbol(sym.tBr, yytext());}
        "br_if"                 {return symbol(sym.tBrIf, yytext());}
        "get_local"             {return symbol(sym.tGet_local, yytext());} 
        "get_global"            {return symbol(sym.tGet_global, yytext());} 
        "set_local"             {return symbol(sym.tSet_local, yytext());}
        "set_global"            {return symbol(sym.tSet_global, yytext());} 
        "tee_local"             {return symbol(sym.tTee_local, yytext());}
        "tee_global"            {return symbol(sym.tTee_global, yytext());}
        "call"                  {return symbol(sym.tCall, yytext());}
        "eqz"                   {return symbol(sym.tEqz, yytext());}
        "function"              {return symbol(sym.tFuncion, yytext());}
        "end"                   {return symbol(sym.tEnd, yytext());}
        "print"                 {return symbol(sym.tPrint, yytext());}
       
    }


    <YYINITIAL>{
        {Identifier}                {return symbol(sym.valId,yytext());}
        \"                          { string.setLength(0); yybegin(STRING);}//tCAdena
        {DecIntegerLiteral}         { return symbol(sym.valEntero,yytext())   ;}
        {Double}                    { return symbol(sym.valDecimal,yytext());} 
    }


    <YYINITIAL> {

        /* comments */
        {Comment}                      { /* ignore */ }
     
        /* whitespace */
        {WhiteSpace}                   { /* ignore */ }

   }

    <STRING> {
      \"                             { yybegin(YYINITIAL); /*System.out.println("AbreComilla"+ yytext());*/
                                       return symbol(sym.valCadena, 
                                       string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); /*System.out.println("CierraComilla6"+ yytext());*/}
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
    }
    

    /* error fallback */
    [^]                              { 
                                        //System.out.println("Error Lexico|token:" + yytext()+"| linea :"+yyline+ "| columna:"+ yycolumn);
                                        simbolo.tablaErrores.insertErrorLexical(nombreArchivo,yyline+1, yycolumn+1, "no se reconoce el token : "+yytext());
                                    }
