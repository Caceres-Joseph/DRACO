package  Analizadores.A_cjs;

import java_cup.runtime.*;
import java.io.*;

%%

%class LexerCjs


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
%}

/*
*Expresiones regulares
*/
 
    LineTerminator = \r|\n|\r\n
    InputCharacter = [^\r\n]
    WhiteSpace     = {LineTerminator} | [ \t\f]
    TraditionalComment   = "'/" [^*] ~"/'" | "'/" "/"+ "'"
    EndOfLineComment     = "'" {InputCharacter}* {LineTerminator}?
    Comment = {TraditionalComment} | {EndOfLineComment} /*| {DocumentationComment}*/
    Identifier = [:jletter:] [:jletterdigit:]*
    DecIntegerLiteral = 0 | [1-9][0-9]*
    Double          =[0-9]+\.[0-9]+

    
%state STRING
%state TITULO

%%

    /*Simbolos*/
    <YYINITIAL> {
 

        ";"                         {return symbol(sym.tPuntoComa, yytext());}
        ":"                         {return symbol(sym.tDosPuntos, yytext());}
        
        "."                         {return symbol(sym.tPunto,yytext());} 
        ","                         {return symbol(sym.tComa,yytext());}  
        "="                         {return symbol(sym.tIgual,yytext());}  

        "=="                        {return symbol(sym.tIgualacion,yytext());}  
        "!="                        {return symbol(sym.tDiferenciacion,yytext());}  
        "<"                         {return symbol(sym.tMenor,yytext());}  
        "<="                        {return symbol(sym.tMenorIgual,yytext());}  
        ">"                         {return symbol(sym.tMayor,yytext());}  
        ">="                        {return symbol(sym.tMayorIgual,yytext());}  

        "&&"                        {return symbol(sym.tAnd,yytext());}  
        "||"                        {return symbol(sym.tOr,yytext());}  
        "!"                         {return symbol(sym.tNot,yytext());}  
       
       
        
        "("                         {return symbol(sym.tAbreParent, yytext());}
        ")"                         {return symbol(sym.tCierraParent, yytext());}
        "["                         {return symbol(sym.tAbreCorchete, yytext());}
        "]"                         {return symbol(sym.tCierraCorchete, yytext());}
        "{"                         {return symbol(sym.tAbreLlaves, yytext());}
        "}"                         {return symbol(sym.tCierraLlaves, yytext());}
        

        "^"                         {return symbol(sym.tPot, yytext());}
        "%"                         {return symbol(sym.tModulo, yytext());}
            
        "*"                         {return symbol(sym.tPor, yytext());}
        "+"                         {return symbol(sym.tMas, yytext());}
        "/"                         {return symbol(sym.tDiv, yytext());}
        "-"                         {return symbol(sym.tMenos, yytext());}

        "++"                         {return symbol(sym.tDobleMas, yytext()); }
        "--"                         {return symbol(sym.tDobleMenos, yytext());}

    }

    /*Palabras*/
    <YYINITIAL>{
        "dimV"                      {return symbol(sym.tDimV, yytext());}
        
        "funcion"                   {return symbol(sym.tFuncion, yytext());}

        "retornar"                  {return symbol(sym.tRetornar, yytext());}
        "detener"                   {return symbol(sym.tDetener, yytext());}
        
        "mensaje"                   {return symbol(sym.tMensaje, yytext());}
        "imprimir"                  {return symbol(sym.tImprimir, yytext());}

        "mientras"                  {return symbol(sym.tMientras, yytext());}
        "Para"                      {return symbol(sym.tPara, yytext());}

        "defecto"                   {return symbol(sym.tDefecto, yytext());}
        "caso"                      {return symbol(sym.tCaso, yytext());}
        "selecciona"                {return symbol(sym.tSelecciona, yytext());}
        "sino"                      {return symbol(sym.tSino, yytext());}
        "si"                        {return symbol(sym.tSi, yytext());}
        
        "documento"                 {return symbol(sym.tDocumento, yytext());}
        "obtener"                   {return symbol(sym.tObetener, yytext());}
        "observador"                {return symbol(sym.tObservador, yytext());}
        "setElemento"               {return symbol(sym.tSetElemento, yytext());}
        
        "conteo"                    {return symbol(sym.tConteo, yytext());}
        "aTexto"                    {return symbol(sym.tATexto, yytext());}
        
        "true"                      {return symbol(sym.tTrue, yytext());}
        "false"                     {return symbol(sym.tFalse, yytext());}
    }


    <YYINITIAL>{
        {Identifier}                {return symbol(sym.tIdentificador,yytext());}
        \"                          { string.setLength(0); yybegin(STRING);}//tCAdena
        {DecIntegerLiteral}         { return symbol(sym.tEntero,yytext())   ;}
        {Double}                    { return symbol(sym.tDecimal,yytext());}
    }


    <YYINITIAL> {

        /* comments */
        {Comment}                      { /* ignore */ }
     
        /* whitespace */
        {WhiteSpace}                   { /* ignore */ }

   }

    <STRING> {
      \"                             { yybegin(YYINITIAL); /*System.out.println("AbreComilla"+ yytext());*/
                                       return symbol(sym.tCadena, 
                                       string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); /*System.out.println("CierraComilla6"+ yytext());*/}
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
    }
    

    /* error fallback */
    [^]                              { System.out.println("Error |token:" + yytext()+"| linea :"+yyline+ "| columna:"+ yycolumn);}
