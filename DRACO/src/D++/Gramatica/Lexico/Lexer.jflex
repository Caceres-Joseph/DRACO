package  DracoScript.Gramatica.Lexico;

import DracoScript.Gramatica.Sintactico.*;
import java_cup.runtime.*;
import DracoScript.Estructuras.Elementos.elementoGlobal;

%%

%class LexerDracoScript 
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
    TraditionalComment   = "$*" [^*] ~"*$" | "$*" "*"+ "$"
    EndOfLineComment     = "$$" {InputCharacter}* {LineTerminator}?
    Comment = {TraditionalComment} | {EndOfLineComment} /*| {DocumentationComment}*/
    Identifier = [:jletter:] [:jletterdigit:]*
    DecIntegerLiteral = 0 | [1-9][0-9]*
    Double          =[0-9]+\.[0-9]+

    If2 ="if" {WhiteSpace}+ "not" 

    Char = "'"[^]"'"

%state STRING
%state TITULO

%%

    /*Simbolos*/
    <YYINITIAL> {
        {If2}                       {return symbol(sym.tIf2, yytext());}

        ";"                         {return symbol(sym.sPuntoComa, yytext());}
        ":"                         {return symbol(sym.sDosPuntos, yytext());}
        
        "."                         {return symbol(sym.sPunto,yytext());} 
        ","                         {return symbol(sym.sComa,yytext());}  
        ":=:"                       {return symbol(sym.sIgual,yytext());}  

        "=="                        {return symbol(sym.sIgualacion,yytext());}  
        "!="                        {return symbol(sym.sDiferenciacion,yytext());}  
        "<"                         {return symbol(sym.sMenor,yytext());}  
        "<="                        {return symbol(sym.sMenorIgual,yytext());}  
        ">"                         {return symbol(sym.sMayor,yytext());}  
        ">="                        {return symbol(sym.sMayorIgual,yytext());}  

        "&&"                        {return symbol(sym.sAnd,yytext());}  
        "||"                        {return symbol(sym.sOr,yytext());}  
        "!"                         {return symbol(sym.sNot,yytext());}  
       
       
        
        "("                         {return symbol(sym.sAbreParent, yytext());}
        ")"                         {return symbol(sym.sCierraParent, yytext());}
        "["                         {return symbol(sym.sAbreCorchete, yytext());}
        "]"                         {return symbol(sym.sCierraCorchete, yytext());}
        "{"                         {return symbol(sym.sAbreLlaves, yytext());}
        "}"                         {return symbol(sym.sCierraLlaves, yytext());}
        

        "^"                         {return symbol(sym.sPot, yytext());}
        "%"                         {return symbol(sym.sModulo, yytext());}
            
        "*"                         {return symbol(sym.sPor, yytext());}
        "+"                         {return symbol(sym.sMas, yytext());}
        "/"                         {return symbol(sym.sDiv, yytext());}
        "-"                         {return symbol(sym.sMenos, yytext());}

        "++"                         {return symbol(sym.sDobleMas, yytext()); }
        "--"                         {return symbol(sym.sDobleMenos, yytext());}

    }

    /*Palabras*/
    <YYINITIAL>{
        "var"                       {return symbol(sym.tVar, yytext());}
        
        "smash"                     {return symbol(sym.tSmash, yytext());}

        "if"                        {return symbol(sym.tIf, yytext());}
        "elif"                      {return symbol(sym.tElif, yytext());}
        

        //"not"                       {return symbol(sym.tNot, yytext());}
        "while"                     {return symbol(sym.tWhile, yytext());}

        "for"                       {return symbol(sym.tFor, yytext());}
        "print"                     {return symbol(sym.tPrint, yytext());}

        "runmultdasm"               {return symbol(sym.tRunMultDasm, yytext());}

        "rundasm"                   {return symbol(sym.tRunDasm, yytext());}
        
        "point"                     {return symbol(sym.tPoint, yytext());}
        "quadrate"                  {return symbol(sym.tQuadrate, yytext());}
        "oval"                      {return symbol(sym.tOval, yytext());}
        "string"                    {return symbol(sym.tString, yytext());}
        
        "line"                      {return symbol(sym.tLine, yytext());}
        
        "true"                      {return symbol(sym.valTrue, yytext());}
        "false"                     {return symbol(sym.valFalse, yytext());}
    }


    <YYINITIAL>{
        {Identifier}                {return symbol(sym.valId,yytext());}
        \"                          { string.setLength(0); yybegin(STRING);}//tCAdena
        {DecIntegerLiteral}         { return symbol(sym.valEntero,yytext())   ;}
        {Double}                    { return symbol(sym.valDecimal,yytext());}
        {Char}                      { return symbol(sym.valChar,yytext());}
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
