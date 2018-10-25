package D_plus.Gramatica.Sintactico;

/* import Analizadores.elementoTablaSimbolos;
import Analizadores.tablaDeSimbolos;
import Analizadores.AST;
import Analizadores.nodo;
import Analizadores.listaValores; */



import java.util.List;
import java_cup.runtime.*;
import java.util.ArrayList;


import DracoScript.Estructuras.Elementos.elementoGlobal;
import DracoScript.Estructuras.Items.itemAtributo;


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

non terminal            
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
 
S               ::= LST_IMPORT CP_DRACO
                |   CP_DRACO
                ;

LST_IMPORT      ::= LST_IMPORT IMPORT
                |   IMPORT
                ;

IMPORT          ::= tImportar sAbreParent E sCierraParent sPuntoComa
                ;

TIPO            ::= tEntero
                |   tDecimal
                |   tCaracter
                |   tBooleano 
                |   tVacio
                |   tCadena
                ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Parametros
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

LST_PARAMETROS      ::= LST_PARAMETROS sComa PARAMETRO
                    |   PARAMETRO
                    ;


PARAMETRO           ::=TIPO VAR_ARREGLO
                    ;

LST_VAL             ::= LST_VAL sComa VALOR
                    |   VALOR
                    ;




    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo Absoluto
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */
                       
CP_DRACO            ::= CP_DRACO CUERPO_DRACO
                    |   CUERPO_DRACO
                    ;


CUERPO_DRACO        ::= DECLARAR_VARIABLE sPuntoComa 
                    |   METODO
                    |   MAIN
                    |   ESTRUCTURA
                    ;
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Estructuras
    |-------------------------------------------------------------------------------------------------------------------
    | No se pueden iniciarlizar con valor  
    */       

ESTRUCTURA          ::= tEstructura valId sAbreLlave LST_DECLARAR_VAR sCierraLlave;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones/Metodos
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */ 

METODO              ::= TIPO VAR_ARREGLO sAbreParent LST_PARAMETROS sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    |   TIPO VAR_ARREGLO sAbreParent  sCierraParent sAbreLlave LST_CUERPO sCierraLlave
                    ;

MAIN                ::= TIPO tPrincipal sAbreParent  sCierraParent sAbreLlave  LST_CUERPO  sCierraLlave
                    |   tPrincipal sAbreParent  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave              
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Declarar variable
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

LST_DECLARAR_VAR    ::= LST_DECLARAR_VAR DECLARAR_VARIABLE sPuntoComa
                    |   DECLARAR_VARIABLE sPuntoComa
                    ;

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
                    |   DECLARAR_VARIABLE sComa VAR_ARREGLO
                    |   TIPO VAR_ARREGLO VAL
                    |   TIPO VAR_ARREGLO
                    ;

VAL                 ::=sIgual VALOR
                    |  sIgual LST_LLAVES_VAL 
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

 
 

LST_LLAVES_VAL      ::= LST_LLAVES_VAL sComa LLAVES_VAL_P
                    |   LLAVES_VAL_P
                    ;


LLAVES_VAL_P        ::=  sAbreLlave LST_LLAVES_VAL sCierraLlave
                    |   sAbreLlave LST_VAL sCierraLlave
                    ;

    /*
    |----------------------------------------------
    | Corchetes
    */

VAR_ARREGLO         ::= valId
                    |   valId  LST_CORCHETES_VAL
                    ;

LST_CORCHETES_VAL   ::= LST_CORCHETES_VAL PAR_CORCHETES_VAL
                    |   PAR_CORCHETES_VAL
                    ;

PAR_CORCHETES_VAL   ::= sAbreCorchete VALOR sCierraCorchete
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Para poder acceder a los metodos o variables
    |-------------------------------------------------------------------------------------------------------------------
    | Me va devolver un metodo () al final
    | Me va devolver un Id al final
    */

ID_VAR_FUNC         ::= ID_VAR_FUNC LST_PUNTOSP
                    |   valId
                    |   valId sAbreParent  LST_VAL  sCierraParent
                    |   valId sAbreParent           sCierraParent
                    //para hacer uso de corchetes
                    |   valId  LST_CORCHETES_VAL
                    |   valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
                    ;

LST_PUNTOSP         ::= sPunto  valId
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent
                    |   sPunto  valId  sAbreParent           sCierraParent

                    //Corchetes
                    |   sPunto  valId  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL
                    |   sPunto  valId  sAbreParent           sCierraParent  LST_CORCHETES_VAL
                    ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Asignar valor
    |-------------------------------------------------------------------------------------------------------------------
    | Hay que validar que reciba un id, y no un idFUNC
    */
 

ASIG_VALOR          ::= ID_VAR_FUNC  VAL
                    |   ID_VAR_FUNC  sMas  sMas
                    |   ID_VAR_FUNC  sMenos  sMenos
                    ;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo Relativo
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */


LST_CUERPO          ::= LST_CUERPO2
                    |   /* epsilon */
                    {:
                        System.out.println("vacio");
                    :}
                    ;

 

LST_CUERPO2          ::= LST_CUERPO2 CUERPO
                    |   CUERPO
                    ;

CUERPO              ::= DECLARAR_VARIABLE sPuntoComa
                    |   ID_VAR_FUNC  sPuntoComa
                    |   ASIG_VALOR  sPuntoComa
                    |   FUNCIONES_NATIVAS  sPuntoComa
                    |   SENTENCIAS
                     
                    |   CONTROL
                    ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias de cotrol
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

CONTROL             ::= ROMPER
                    |   CONTINUAR
                    |   RETORNO
                    ;

RETORNO             ::= tRetornar  sPuntoComa
                    |   tRetornar  VALOR  sPuntoComa
                    ;

ROMPER              ::= tDetener  sPuntoComa
                    ;

CONTINUAR           ::=tContinuar  sPuntoComa
                    ;   

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias 
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

SENTENCIAS          ::= SI
                    |   WHILE
                    |   FOR 
                    ;

    /*
    ------------------------------------------
    * SI 
    ------------------------------------------
    *  
    */



SI      ::= tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO_SI
        |   tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO
        ;

SINO_SI ::= tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO_SI
        |   tSino  tSi  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave  SINO
        ;

SINO    ::= tSino  sAbreLlave  LST_CUERPO  sCierraLlave
        ;

    /*
    ------------------------------------------
    * SI SIMPLIFICADO
    ------------------------------------------
    */

SI_SIMPLIFICADO     ::= VALOR  sCierraInterrogante  E  sDosPuntos  E
                    ;
 

    /*
    ------------------------------------------
    * WHILE
    ------------------------------------------
    */


WHILE       ::=tMientras  sAbreParent  E  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
            ;



    /*
    ------------------------------------------
    * FOR
    ------------------------------------------
    */

FOR     ::= tPara  sAbreParent  DECLARAR_VARIABLE  sPuntoComa  E  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        |   tPara  sAbreParent  ASIG_VALOR  sPuntoComa  E  sPuntoComa  ASIG_VALOR  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
        ;



    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones Nativas
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

FUNCIONES_NATIVAS       ::= IMPRIMIR 
                        |   PUNTO
                        |   CUADRADO
                        |   OVALO 
                        |   CADENA
                        |   LINEA
                        ;



IMPRIMIR                ::= tImprimir  sAbreParent  VALOR  sCierraParent
                        |   tImprimir  sAbreParent  sCierraParent
                        ;

PUNTO                   ::= tPunto  sAbreParent  LST_VAL  sCierraParent
                        ;

CUADRADO                ::= tCuadrado  sAbreParent  LST_VAL  sCierraParent
                        ;

OVALO                   ::= tOvalo  sAbreParent  LST_VAL  sCierraParent
                        ;


CADENA                  ::= tCadena  sAbreParent  LST_VAL  sCierraParent
                        ;

LINEA                   ::= tLinea  sAbreParent  LST_VAL  sCierraParent
                        ;


            /*
            |-------------------------------------------------------------------------------------------------------------------
            | Valor
            |-------------------------------------------------------------------------------------------------------------------
            |  
            */



VALOR              ::=   SI_SIMPLIFICADO
                    |   E;




E                       ::=sMenos  E
                        //Aritemeticas
                        | E  sPot  E
                        | E  sDiv  E
                        | E  sPor  E
                        | E  sMas  E
                        | E  sMenos  E
                        | E  sModulo  E

                        //Relacional

                        | E  sIgualacion  E
                        | E  sDiferenciacion  E
                        | E  sMenor  E
                        | E  sMenorIgual  E
                        | E  sMayor  E
                        | E  sMayorIgual  E

                        //logicos

                        | E  sAnd  E
                        | E  sOr  E
                        | sNot  E

                        | sAbreParent  E  sCierraParent

                        | ID_VAR_FUNC  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                        | valFalse
                        | valTrue
                        | valCadena
                        | valChar
                        | valDecimal
                        | valEntero
                        | tNulo  
                        ;
        