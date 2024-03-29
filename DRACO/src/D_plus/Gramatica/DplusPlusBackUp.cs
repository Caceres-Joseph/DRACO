package D_plus.Gramatica.Sintactico;

/* import Analizadores.elementoTablaSimbolos;
import Analizadores.tablaDeSimbolos;
import Analizadores.AST;
import Analizadores.nodo;
import Analizadores.listaValores; */



import java.util.List;
import java_cup.runtime.*;
import java.util.ArrayList;


import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;



import D_plus.Nodos.Arreglo.*;
import D_plus.Nodos.AsignarValor.*;
import D_plus.Nodos.CuerpoAbsoluto.*;
import D_plus.Nodos.CuerpoRelativo.*;
import D_plus.Nodos.DeclararVariable.*;
import D_plus.Nodos.Estructura.*; 
import D_plus.Nodos.FuncionMetodo.*;
import D_plus.Nodos.FuncionesNativas.*;
import D_plus.Nodos.IdVarFunc.*; 
import D_plus.Nodos.Inicio.*;
import D_plus.Nodos.Parametros.*;
import D_plus.Nodos.Sentencia.*; 
import D_plus.Nodos.Sentencia.Si.*;
import D_plus.Nodos.Sentencia.SiSimplificado.*;
import D_plus.Nodos.Sentencia.While.*; 
import D_plus.Nodos.SentenciaControl.*;
import D_plus.Nodos.Sentencia.For.*;
import D_plus.Nodos.Valor.*;  
import D_plus.Nodos.*;




//var: var++*34


parser code {: 
    /* public AST ast; 
    public tablaDeSimbolos tablaSimbolos; */
    public elementoGlobal simbolo;
    public String nombreArchivo="";
    public nodoModelo raiz;
    public void iniciar(elementoGlobal simbolo, String nombreArchivo){
        this.simbolo=simbolo;
        this.nombreArchivo= nombreArchivo;
    }

    public void syntax_error(Symbol te){
        try{
            
            //System.out.println("compiler has detected a syntax error at line:"+te.left+ "  columna:"+te.right+"token:"+te.value.toString());
            simbolo.tablaErrores.insertErrorSyntax(nombreArchivo,te.left, te.right, "No se esperaba token : "+te.value.toString());
        }catch(Exception p){
            System.out.println("[Sintactico.cup][syntax_error][ERROR]"+p.getMessage());
        }
        
    }
:};


/*
+------------------------------------------------+
|   Definición de terminales
+------------------------------------------------+
*/


terminal String sPuntoComa      , sDosPuntos,
                sComa           , sIgual,
                sIgualacion     , sDiferenciacion,
                sMenor          , sMenorIgual,
                sMayor          , sMayorIgual,
                sAnd            , sOr,
                sNot            , sPunto,
                
                sCierraInterrogante,  
                
                sAbreParent     ,       sCierraParent,
                sAbreCorchete   ,       sCierraCorchete,
                sAbreLlave     ,       sCierraLlave,
                sPot            ,       sModulo,
                sPor            ,       sMas,
                sDiv            ,       sMenos;


terminal String tImportar ,
                tEstructura,
                tPrincipal,
                tRetornar,
                tDetener,
                tContinuar,
                tSi,
                tMientras,
                tImprimir,
                tPunto,
                tCuadrado,
                tOvalo,
                tCadena,
                tLinea,
                tDecimal,
                tCaracter,
                tBooleano,
                tVacio,
                tEntero,
                tSino, 
                tPara,
                tNulo
                ;


terminal  String  valTrue         , valFalse, valChar,
                valId           , valEntero , valCadena , valDecimal;


/*
+------------------------------------------------+
|     Definición de No terminales
+------------------------------------------------+
*/

non terminal  nodoModelo          
        S,
        LST_IMPORT,
        IMPORT,
        LST_PARAMETROS,
        PARAMETRO,
        LST_VAL,
        CP_DRACO,
        CUERPO_DRACO,
        ESTRUCTURA,
        METODO,
        MAIN,
        LST_DECLARAR_VAR,
        DECLARAR_VARIABLE,
        VAL,
        LST_LLAVES_VAL,
        LLAVES_VAL_P,
        VAR_ARREGLO,
        LST_CORCHETES_VAL,
        PAR_CORCHETES_VAL,
        ID_VAR_FUNC,
        LST_PUNTOSP,
        ASIG_VALOR,
        LST_CUERPO,
        CUERPO,
        RETORNO,
        ROMPER,
        CONTINUAR,
        SENTENCIAS,
        SI,
        SINO_SI,
        SINO,
        SI_SIMPLIFICADO,
        WHILE,
        FOR,
        FUNCIONES_NATIVAS,
        IMPRIMIR,
        PUNTO,
        CUADRADO,
        OVALO,
        CADENA,
        LINEA,
        VALOR,
        E,
        TIPO,
        CONTROL

        ,LST_CUERPO2
 
        ;
        

/*
+------------------------------------------------+
|   PRECEDENCIA
+------------------------------------------------+
*/

precedence left sOr;
precedence left sAnd;


precedence left sIgualacion     ,
                sDiferenciacion ,
                sMenor          ,
                sMayor          ,
                sMenorIgual     ,
                sMayorIgual     ;

precedence left sMas, sMenos;
precedence left sPor, sDiv, sModulo;
precedence right sPot;

 
precedence left sNot;
precedence left sComa;  //Para resolver el conflicto con los  arreglos

/*
+------------------------------------------------+
|   Producciones
+------------------------------------------------+
*/
start with S;


/*
|-------------------------------------------------------------------------------------------------------------------
| INICIO
|-------------------------------------------------------------------------------------------------------------------
*/
 
S               ::= LST_IMPORT:h1 CP_DRACO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("S", parser.nombreArchivo, 0); 
                            _S padre =new _S(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                |   CP_DRACO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("S", parser.nombreArchivo, 1); 
                            _S padre =new _S(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                ;

LST_IMPORT      ::= LST_IMPORT:h1 IMPORT:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_IMPORT", parser.nombreArchivo, 0); 
                            _LST_IMPORT padre =new _LST_IMPORT(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                |   IMPORT:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_IMPORT", parser.nombreArchivo, 1); 
                            _LST_IMPORT padre =new _LST_IMPORT(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                ;

IMPORT          ::= tImportar sAbreParent E:h1 sCierraParent sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("IMPORT", parser.nombreArchivo, 0); 
                            _IMPORT padre =new _IMPORT(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                ;

TIPO            ::= tEntero
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 0); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                |   tDecimal
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 1); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             
                            RESULT= padre;
                        :}
                |   tCaracter
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 2); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                |   tBooleano 
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 3); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                |   tVacio
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 4); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                |   tCadena
                        {:
                            itemAtributo atrib1=new itemAtributo("TIPO", parser.nombreArchivo, 5); 
                            _TIPO padre =new _TIPO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Parametros
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

LST_PARAMETROS      ::= LST_PARAMETROS:h1 sComa PARAMETRO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PARAMETROS", parser.nombreArchivo, 0); 
                            _LST_PARAMETROS padre =new _LST_PARAMETROS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   PARAMETRO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("_LST_PARAMETROS", parser.nombreArchivo, 1); 
                            _LST_PARAMETROS padre =new _LST_PARAMETROS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;


PARAMETRO           ::=TIPO:h1 VAR_ARREGLO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("PARAMETRO", parser.nombreArchivo, 0); 
                            _PARAMETRO padre =new _PARAMETRO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    ;

LST_VAL             ::= LST_VAL:h1 sComa VALOR:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_VAL", parser.nombreArchivo, 0); 
                            _LST_VAL padre =new _LST_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   VALOR:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_VAL", parser.nombreArchivo, 1); 
                            _LST_VAL padre =new _LST_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;




    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo Absoluto
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */
                       
CP_DRACO            ::= CP_DRACO:h1 CUERPO_DRACO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("CP_DRACO", parser.nombreArchivo, 0); 
                            _CP_DRACO padre =new _CP_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   CUERPO_DRACO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CP_DRACO", parser.nombreArchivo, 1); 
                            _CP_DRACO padre =new _CP_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;


CUERPO_DRACO        ::= DECLARAR_VARIABLE:h1 sPuntoComa 
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO_DRACO", parser.nombreArchivo, 0); 
                            _CUERPO_DRACO padre =new _CUERPO_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   METODO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO_DRACO", parser.nombreArchivo, 1); 
                            _CUERPO_DRACO padre =new _CUERPO_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   MAIN:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO_DRACO", parser.nombreArchivo, 2); 
                            _CUERPO_DRACO padre =new _CUERPO_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   ESTRUCTURA:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO_DRACO", parser.nombreArchivo, 3); 
                            _CUERPO_DRACO padre =new _CUERPO_DRACO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Estructuras
    |-------------------------------------------------------------------------------------------------------------------
    | No se pueden iniciarlizar con valor  
    */       

ESTRUCTURA          ::= tEstructura valId sAbreLlave LST_DECLARAR_VAR:h1 sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("ESTRUCTURA", parser.nombreArchivo, 0); 
                            _ESTRUCTURA padre =new _ESTRUCTURA(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :};

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones/Metodos
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */ 

METODO              ::= TIPO:h1 VAR_ARREGLO:h2 sAbreParent LST_PARAMETROS:h3 sCierraParent sAbreLlave LST_CUERPO:h4 sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("METODO", parser.nombreArchivo, 0); 
                            _METODO padre =new _METODO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);
                                padre.listaHijos.insertar(h4,h4left, h4right);

                            RESULT= padre;
                        :}
                    |   TIPO:h1 VAR_ARREGLO:h2 sAbreParent  sCierraParent sAbreLlave LST_CUERPO:h3 sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("METODO", parser.nombreArchivo, 1); 
                            _METODO padre =new _METODO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
                    ;

MAIN                ::= TIPO:h1 tPrincipal sAbreParent  sCierraParent sAbreLlave  LST_CUERPO:h2  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("MAIN", parser.nombreArchivo, 0); 
                            _MAIN padre =new _MAIN(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   tPrincipal sAbreParent  sCierraParent  sAbreLlave  LST_CUERPO:h1  sCierraLlave 
                        {:
                            itemAtributo atrib1=new itemAtributo("MAIN", parser.nombreArchivo, 1); 
                            _MAIN padre =new _MAIN(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                

                            RESULT= padre;
                        :}             
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Declarar variable
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

LST_DECLARAR_VAR    ::= LST_DECLARAR_VAR:h1 DECLARAR_VARIABLE:h2 sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_DECLARAR_VAR", parser.nombreArchivo, 0); 
                            _LST_DECLARAR_VAR padre =new _LST_DECLARAR_VAR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   DECLARAR_VARIABLE:h1 sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_DECLARAR_VAR", parser.nombreArchivo, 1); 
                            _LST_DECLARAR_VAR padre =new _LST_DECLARAR_VAR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE:h1 sComa VAR_ARREGLO:h2  VAL:h3 
                        {:
                            itemAtributo atrib1=new itemAtributo("DECLARAR_VARIABLE", parser.nombreArchivo, 0); 
                            _DECLARAR_VARIABLE padre =new _DECLARAR_VARIABLE(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
                    |   DECLARAR_VARIABLE:h1 sComa VAR_ARREGLO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("DECLARAR_VARIABLE", parser.nombreArchivo, 1); 
                            _DECLARAR_VARIABLE padre =new _DECLARAR_VARIABLE(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   TIPO:h1 VAR_ARREGLO:h2 VAL:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("DECLARAR_VARIABLE", parser.nombreArchivo, 2); 
                            _DECLARAR_VARIABLE padre =new _DECLARAR_VARIABLE(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
                    |   TIPO:h1 VAR_ARREGLO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("DECLARAR_VARIABLE", parser.nombreArchivo, 3); 
                            _DECLARAR_VARIABLE padre =new _DECLARAR_VARIABLE(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    ;

VAL                 ::=sIgual VALOR:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("VAL", parser.nombreArchivo, 0); 
                            _VAL padre =new _VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |  sIgual LST_LLAVES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("VAL", parser.nombreArchivo, 1); 
                            _VAL padre =new _VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

  /*
    |-------------------------------------------------------------------------------------------------------------------
    | Arreglos
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    /*
    |----------------------------------------------
    | Llaves
    */

 
 

LST_LLAVES_VAL      ::= LST_LLAVES_VAL:h1 sComa LLAVES_VAL_P:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_LLAVES_VAL", parser.nombreArchivo, 0); 
                            _LST_LLAVES_VAL padre =new _LST_LLAVES_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   LLAVES_VAL_P:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_LLAVES_VAL", parser.nombreArchivo, 1); 
                            _LST_LLAVES_VAL padre =new _LST_LLAVES_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;


LLAVES_VAL_P        ::=  sAbreLlave LST_LLAVES_VAL:h1 sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("LLAVES_VAL_P", parser.nombreArchivo, 0); 
                            _LLAVES_VAL_P padre =new _LLAVES_VAL_P(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   sAbreLlave LST_VAL:h1 sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("LLAVES_VAL_P", parser.nombreArchivo, 1); 
                            _LLAVES_VAL_P padre =new _LLAVES_VAL_P(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

    /*
    |----------------------------------------------
    | Corchetes
    */

VAR_ARREGLO         ::= valId
                        {:
                            itemAtributo atrib1=new itemAtributo("VAR_ARREGLO", parser.nombreArchivo, 0); 
                            _VAR_ARREGLO padre =new _VAR_ARREGLO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   valId  LST_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("VAR_ARREGLO", parser.nombreArchivo, 1); 
                            _VAR_ARREGLO padre =new _VAR_ARREGLO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

LST_CORCHETES_VAL   ::= LST_CORCHETES_VAL:h1 PAR_CORCHETES_VAL:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_CORCHETES_VAL", parser.nombreArchivo, 0); 
                            _LST_CORCHETES_VAL padre =new _LST_CORCHETES_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   PAR_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_CORCHETES_VAL", parser.nombreArchivo, 1); 
                            _LST_CORCHETES_VAL padre =new _LST_CORCHETES_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

PAR_CORCHETES_VAL   ::= sAbreCorchete VALOR:h1 sCierraCorchete
                        {:
                            itemAtributo atrib1=new itemAtributo("PAR_CORCHETES_VAL", parser.nombreArchivo, 0); 
                            _PAR_CORCHETES_VAL padre =new _PAR_CORCHETES_VAL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Para poder acceder a los metodos o variables
    |-------------------------------------------------------------------------------------------------------------------
    | Me va devolver un metodo () al final
    | Me va devolver un Id al final
    */

ID_VAR_FUNC         ::= ID_VAR_FUNC:h1 LST_PUNTOSP:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 0); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   valId
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 1); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   valId sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 2); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   valId sAbreParent           sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 3); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    //para hacer uso de corchetes
                    |   valId  LST_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 4); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   valId  sAbreParent  LST_VAL:h1  sCierraParent  LST_CORCHETES_VAL:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 5); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("ID_VAR_FUNC", parser.nombreArchivo, 6); 
                            _ID_VAR_FUNC padre =new _ID_VAR_FUNC(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

LST_PUNTOSP         ::= sPunto  valId
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 0); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   sPunto  valId  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 1); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   sPunto  valId  sAbreParent           sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 2); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}

                    //Corchetes
                    |   sPunto  valId  LST_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 3); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   sPunto  valId  sAbreParent  LST_VAL:h1  sCierraParent  LST_CORCHETES_VAL:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 4); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   sPunto  valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_PUNTOSP", parser.nombreArchivo, 5); 
                            _LST_PUNTOSP padre =new _LST_PUNTOSP(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Asignar valor
    |-------------------------------------------------------------------------------------------------------------------
    | Hay que validar que reciba un id, y no un idFUNC
    */
 

ASIG_VALOR          ::= ID_VAR_FUNC:h1  VAL
                        {:
                            itemAtributo atrib1=new itemAtributo("ASIG_VALOR", parser.nombreArchivo, 0); 
                            _ASIG_VALOR padre =new _ASIG_VALOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   ID_VAR_FUNC:h1  sMas  sMas
                        {:
                            itemAtributo atrib1=new itemAtributo("ASIG_VALOR", parser.nombreArchivo, 1); 
                            _ASIG_VALOR padre =new _ASIG_VALOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   ID_VAR_FUNC:h1  sMenos  sMenos
                        {:
                            itemAtributo atrib1=new itemAtributo("ASIG_VALOR", parser.nombreArchivo, 2); 
                            _ASIG_VALOR padre =new _ASIG_VALOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo Relativo
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */


LST_CUERPO          ::= LST_CUERPO2:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_CUERPO", parser.nombreArchivo, 0); 
                            _LST_CUERPO padre =new _LST_CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   /* epsilon */
                    {:
                        System.out.println("vacio");
                    :}
                    ;

 

LST_CUERPO2          ::= LST_CUERPO2:h1 CUERPO:h2
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_CUERPO2", parser.nombreArchivo, 0); 
                            _LST_CUERPO2 padre =new _LST_CUERPO2(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
                    |   CUERPO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("LST_CUERPO2", parser.nombreArchivo, 1); 
                            _LST_CUERPO2 padre =new _LST_CUERPO2(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

CUERPO              ::= DECLARAR_VARIABLE:h1 sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 0); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   ID_VAR_FUNC:h1  sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 1); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   ASIG_VALOR:h1 sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 2); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   FUNCIONES_NATIVAS:h1  sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 3); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   SENTENCIAS:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 4); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                     
                    |   CONTROL:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CUERPO", parser.nombreArchivo, 5); 
                            _CUERPO padre =new _CUERPO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias de cotrol
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

CONTROL             ::= ROMPER:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CONTROL", parser.nombreArchivo, 0); 
                            _CONTROL padre =new _CONTROL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   CONTINUAR:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CONTROL", parser.nombreArchivo, 1); 
                            _CONTROL padre =new _CONTROL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   RETORNO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("CONTROL", parser.nombreArchivo, 2); 
                            _CONTROL padre =new _CONTROL(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

RETORNO             ::= tRetornar  sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("RETORNO", parser.nombreArchivo, 0); 
                            _RETORNO padre =new _RETORNO(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    |   tRetornar  VALOR:h1 sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("RETORNO", parser.nombreArchivo, 1); 
                            _RETORNO padre =new _RETORNO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

ROMPER              ::= tDetener  sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("ROMPER", parser.nombreArchivo, 0); 
                            _ROMPER padre =new _ROMPER(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    ;

CONTINUAR           ::=tContinuar  sPuntoComa
                        {:
                            itemAtributo atrib1=new itemAtributo("CONTINUAR", parser.nombreArchivo, 0); 
                            _CONTINUAR padre =new _CONTINUAR(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                    ;   

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias 
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

SENTENCIAS          ::= SI:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("SENTENCIAS", parser.nombreArchivo, 0); 
                            _SENTENCIAS padre =new _SENTENCIAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   WHILE:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("SENTENCIAS", parser.nombreArchivo, 1); 
                            _SENTENCIAS padre =new _SENTENCIAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   FOR :h1
                        {:
                            itemAtributo atrib1=new itemAtributo("SENTENCIAS", parser.nombreArchivo, 2); 
                            _SENTENCIAS padre =new _SENTENCIAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    ;

    /*
    ------------------------------------------
    * SI 
    ------------------------------------------
    *  
    */



SI      ::= tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("SI", parser.nombreArchivo, 0); 
                            _SI padre =new _SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
        |   tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave  SINO_SI:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("SI", parser.nombreArchivo, 1); 
                            _SI padre =new _SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
        |   tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave  SINO:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("SI", parser.nombreArchivo, 2); 
                            _SI padre =new _SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
        ;

SINO_SI ::= tSino  tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("SINO_SI", parser.nombreArchivo, 0); 
                            _SINO_SI padre =new _SINO_SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
        |   tSino  tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave  SINO_SI:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("SINO_SI", parser.nombreArchivo, 1); 
                            _SINO_SI padre =new _SINO_SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
        |   tSino  tSi  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave  SINO:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("SINO_SI", parser.nombreArchivo, 2); 
                            _SINO_SI padre =new _SINO_SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
        ;

SINO    ::= tSino  sAbreLlave  LST_CUERPO:h1  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("SINO_SI", parser.nombreArchivo, 0); 
                            _SINO_SI padre =new _SINO_SI(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
        ;

    /*
    ------------------------------------------
    * SI SIMPLIFICADO
    ------------------------------------------
    */

SI_SIMPLIFICADO     ::= VALOR:h1  sCierraInterrogante  E:h2  sDosPuntos  E:h3
                        {:
                            itemAtributo atrib1=new itemAtributo("SI_SIMPLIFICADO", parser.nombreArchivo, 0); 
                            _SI_SIMPLIFICADO padre =new _SI_SIMPLIFICADO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);

                            RESULT= padre;
                        :}
                    ;
 

    /*
    ------------------------------------------
    * WHILE
    ------------------------------------------
    */


WHILE       ::=tMientras  sAbreParent  E:h1  sCierraParent  sAbreLlave  LST_CUERPO:h2  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("WHILE", parser.nombreArchivo, 0); 
                            _WHILE padre =new _WHILE(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);

                            RESULT= padre;
                        :}
            ;



    /*
    ------------------------------------------
    * FOR
    ------------------------------------------
    */

FOR     ::= tPara  sAbreParent  DECLARAR_VARIABLE:h1  sPuntoComa  E:h2  sPuntoComa  ASIG_VALOR:h3  sCierraParent  sAbreLlave  LST_CUERPO:h4  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("FOR", parser.nombreArchivo, 0); 
                            _FOR padre =new _FOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);
                                padre.listaHijos.insertar(h4,h2left, h4right);

                            RESULT= padre;
                        :}
        |   tPara  sAbreParent  ASIG_VALOR:h1  sPuntoComa  E:h2  sPuntoComa  ASIG_VALOR:h3  sCierraParent  sAbreLlave  LST_CUERPO:h4  sCierraLlave
                        {:
                            itemAtributo atrib1=new itemAtributo("FOR", parser.nombreArchivo, 1); 
                            _FOR padre =new _FOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right);
                                padre.listaHijos.insertar(h2,h2left, h2right);
                                padre.listaHijos.insertar(h3,h3left, h3right);
                                padre.listaHijos.insertar(h4,h2left, h4right);

                            RESULT= padre;
                        :}
        ;



    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones Nativas
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

FUNCIONES_NATIVAS       ::= IMPRIMIR :h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 0); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   PUNTO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 1); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   CUADRADO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 2); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   OVALO :h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 3); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   CADENA:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 4); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   LINEA:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("FUNCIONES_NATIVAS", parser.nombreArchivo, 5); 
                            _FUNCIONES_NATIVAS padre =new _FUNCIONES_NATIVAS(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;



IMPRIMIR                ::= tImprimir  sAbreParent  VALOR:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("IMPRIMIR", parser.nombreArchivo, 0); 
                            _IMPRIMIR padre =new _IMPRIMIR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        |   tImprimir  sAbreParent  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("IMPRIMIR", parser.nombreArchivo, 1); 
                            _IMPRIMIR padre =new _IMPRIMIR(atrib1 , parser.simbolo);
                             

                            RESULT= padre;
                        :}
                        ;

PUNTO                   ::= tPunto  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("PUNTO", parser.nombreArchivo, 0); 
                            _PUNTO padre =new _PUNTO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;

CUADRADO                ::= tCuadrado  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("CUADRADO", parser.nombreArchivo, 0); 
                            _CUADRADO padre =new _CUADRADO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;

OVALO                   ::= tOvalo  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("OVALO", parser.nombreArchivo, 0); 
                            _OVALO padre =new _OVALO(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;


CADENA                  ::= tCadena  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("CADENA", parser.nombreArchivo, 0); 
                            _CADENA padre =new _CADENA(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;

LINEA                   ::= tLinea  sAbreParent  LST_VAL:h1  sCierraParent
                        {:
                            itemAtributo atrib1=new itemAtributo("LINEA", parser.nombreArchivo, 0); 
                            _LINEA padre =new _LINEA(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                        ;


            /*
            |-------------------------------------------------------------------------------------------------------------------
            | Valor
            |-------------------------------------------------------------------------------------------------------------------
            |  
            */



VALOR              ::=   SI_SIMPLIFICADO:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("VALOR", parser.nombreArchivo, 0); 
                            _VALOR padre =new _VALOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :}
                    |   E:h1
                        {:
                            itemAtributo atrib1=new itemAtributo("VALOR", parser.nombreArchivo, 1); 
                            _VALOR padre =new _VALOR(atrib1 , parser.simbolo);
                            
                                padre.listaHijos.insertar(h1,h1left, h1right); 

                            RESULT= padre;
                        :};




E                       ::=sMenos  E:h1
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 0); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right); 

                                RESULT= padre;
                            :}
                        | E:h1  sPot  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 1); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sDiv  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 2); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sPor  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 3); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMas  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 4); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMenos  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 5); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sModulo  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 6); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}

                        //Relacional

                        | E:h1  sIgualacion  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 7); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sDiferenciacion  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 8); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMenor  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 9); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMenorIgual  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 10); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMayor  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 11); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sMayorIgual  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 12); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}

                        //logicos

                        | E:h1  sAnd  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 13); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | E:h1  sOr  E:h2
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 14); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right);
                                    padre.listaHijos.insertar(h2,h2left, h2right);

                                RESULT= padre;
                            :}
                        | sNot  E:h1
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 15); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right); 

                                RESULT= padre;
                            :}

                        | sAbreParent  E:h1  sCierraParent
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 16); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right); 

                                RESULT= padre;
                            :}

                        | ID_VAR_FUNC:h1  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 17); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    padre.listaHijos.insertar(h1,h1left, h1right); 

                                RESULT= padre;
                            :}
                        | valFalse
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 18); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                 

                                RESULT= padre;
                            :}
                        | valTrue
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 19); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                 

                                RESULT= padre;
                            :}
                        | valCadena
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 20); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                 

                                RESULT= padre;
                            :}
                        | valChar
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 21); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                 

                                RESULT= padre;
                            :}
                        | valDecimal
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 22); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    

                                RESULT= padre;
                            :}
                        | valEntero
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 23); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                    

                                RESULT= padre;
                            :}
                        | tNulo  
                            {:
                                itemAtributo atrib1=new itemAtributo("E", parser.nombreArchivo, 24); 
                                _E padre =new _E(atrib1 , parser.simbolo);
                                
                                  

                                RESULT= padre;
                            :}
                        ;
        