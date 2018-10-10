
    S                       -> LST_CUERPO;



    LST_CUERPO              ->LST_CUERPO  CUERPO
                            | CUERPO;


    CUERPO                  -> DECLARAR_VAR + ";"
                            |  ASIGNAR_VAL + ";"
                            |  SENTENCIAS
                            |  ROMPER
                            |  FUNCIONES_NATIVAS + ";"
                            |  empty;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Asignar valor
    |-------------------------------------------------------------------------------------------------------------------
    | Hay que validar que reciba un id, y no un idFUNC
    */

    ASIGNAR_VAL             ->  ASGIN_VAR 
                            |   valId ++
                            |   valId --;


    DECLARAR_VAR            -> "var " + LST_DECLARAR_VAR ;
 


    LST_DECLARAR_VAR        ->  LST_DECLARAR_VAR ","  valId
                            |   LST_DECLARAR_VAR ","  ASGIN_VAR
                            |   valId;
                            |   ASGIN_VAR; 
 

    ASGIN_VAR.Rule          -> valId sIgual + VALOR;

    LST_VALOR               ->  LST_VALOR + ", " + VALOR
                            |   VALOR;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias 
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    SENTENCIAS.Rule = IF
        // | SI_SIMPLIFICADO
        

        //CICLOS
        | WHILE
        | FOR ;

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias de cotrol
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */
 
    ROMPER.Rule = tSmash + sPuntoComa;
 
    

    /*
    ------------------------------------------
    * IF
    ------------------------------------------
    *  
    */

    IF.Rule                 ->  tIf + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave
                            |   tIf + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO_SI
                            |   tIf + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO;

    ELIF                    ->  tElif + tSi + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + ELIF
                            |   tElif + tSi + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + IF_NOT
                            |   tElif + tSi + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave;

    IF_NOT                  ->  tIfNot + sAbreLlave + LST_CUERPO + sCierraLlave;


    
    /*
    ------------------------------------------
    * WHILE
    ------------------------------------------
    */

    WHILE.Rule = tWhile + sAbreParent + VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave;



    /*
    ------------------------------------------
    * FOR
    ------------------------------------------
    */

    FOR.Rule =  tFor + sAbreParent + DECLARAR_VAR + sPuntoComa + VALOR + sPuntoComa + ASIGNAR_VAL + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave
        |       tFor + sAbreParent + ASIGNAR_VAL + sPuntoComa + VALOR + sPuntoComa + ASIGNAR_VAL + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones Nativas
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */


    FUNCIONES_NATIVAS.Rule = PRINT
        | RUNMULTDASM

        | POINT
        | QUADRATE
        | OVAL
        
        | STRING
        | LINE
        ;

    PRINT.Rule = tPrint + sAbreParent + VALOR + sCierraParent
        | tPrint + sAbreParent + sCierraParent;

    RUNMULTDASM.Rule = tRun + sAbreParent + LST_VALOR + sCierraParent
        | tRun + sAbreParent + sCierraParent;


    POINT.Rule = tPoint + sAbreParent + LST_VALOR + sCierraParent;
 
    QUADRATE.Rule = tQiadrate + sAbreParent + LST_VALOR + sCierraParent;
 
    OVAL.Rule = tOval + sAbreParent + LST_VALOR + sCierraParent;


    STRING.Rule = tString + sAbreParent + LST_VALOR + sCierraParent;

    LINE.Rule = tLine + sAbreParent + LST_VALOR + sCierraParent;



    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Valor
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */



    VALOR                   ->E;

    E.Rule                  -> sMenos + E

                            //Aritemeticas
                            | E + sPot + E
                            | E + sDiv + E
                            | E + sPor + E
                            | E + sMas + E
                            | E + sMenos + E
                            | E + sMod + E

                            //Relacional

                            | E + sIgualacion + E
                            | E + sDiferenciacion + E
                            | E + sMenorQue + E
                            | E + sMenorIgualQue + E
                            | E + sMayorQue + E
                            | E + sMayorIgualQue + E

                            //logicos

                            | E + sAnd + E
                            | E + sOr + E
                            | sNot + E



                            | sAbreParent + E + sCierraParent

                            | valId  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                            | valBoolean
                            | valCadena 
                            | valCaracter
                            | valDecimal
                            | valNumero

                            | tNulo
                            ;


/*
|-------------------------------------------------------------------------------------------------------------------
| CUP
|-------------------------------------------------------------------------------------------------------------------
*/
 
S               ::= LST_CUERPO;


LST_CUERPO      ::= LST_CUERPO CUERPO
                |   CUERPO;


CUERPO          ::= DECLARAR_VAR sPuntoComa
                |   ASIGNAR_VAL sPuntoComa
                |   SENTENCIAS
                |   ROMPER
                |   FUNCIONES_NATIVAS  sPuntoComa
                ;

            
/*
|-------------------------------------------------------------------------------------------------------------------
| Asignar valor
|-------------------------------------------------------------------------------------------------------------------
| Hay que validar que reciba un id, y no un idFUNC
*/


ASIGNAR_VAL     ::= ASGIN_VAR
                |   valId sDobleMas
                |   valId sDobleMenos;


DECLARAR_VAR    ::=tVar LST_DECLARAR_VAR;

LST_DECLARAR_VAR::= LST_DECLARAR_VAR sComa  valId
                |   LST_DECLARAR_VAR sComa ASGIN_VAR
                |   valId
                |   ASGIN_VAR  ;


ASGIN_VAR       ::=valId sIgual VALOR;

LST_VALOR       ::= LST_VALOR sComa VALOR
                |   VALOR;

/*
|-------------------------------------------------------------------------------------------------------------------
| Sentencias 
|-------------------------------------------------------------------------------------------------------------------
|  
*/


SENTENCIAS      ::=  IF 
                |   WHILE
                |   FOR
                ;

/*
|-------------------------------------------------------------------------------------------------------------------
| Sentencias de cotrol
|-------------------------------------------------------------------------------------------------------------------
|  
*/

ROMPER          ::=tSmash sPuntoComa;


/*
------------------------------------------
* IF
------------------------------------------
*  
*/
 
 
IF              ::= tIf sAbreParent VALOR sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
                |   tIf sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves ELIF
                |   tIf sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves IF_NOT;


ELIF            ::= tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves ELIF
                |   tElif sAbreParent  VALOR  sCierraParent  sAbreLlaves  LST_CUERPO sCierraLlaves IF_NOT;


IF_NOT          ::= tIf2  sAbreLlaves  LST_CUERPO sCierraLlaves;

/*
------------------------------------------
* WHILE
------------------------------------------
*/


WHILE           ::=tWhile sAbreParent VALOR sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves;

/*
------------------------------------------
* FOR
------------------------------------------
*/

FOR             ::= tFor sAbreParent DECLARAR_VAR sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves
                |   tFor sAbreParent ASIGNAR_VAL  sPuntoComa VALOR sPuntoComa ASIGNAR_VAL sCierraParent sAbreLlaves LST_CUERPO  sCierraLlaves;

/*
|-------------------------------------------------------------------------------------------------------------------
| Funciones Nativas
|-------------------------------------------------------------------------------------------------------------------
|  
*/

FUNCIONES_NATIVAS   ::= PRINT
                    |   RUNMULTDASM

                    |   POINT
                    |   QUADRATE
                    |   OVAL

                    |   STRING
                    |   LINE;


PRINT           ::= tPrint sAbreParent VALOR sCierraParent
                |   tPrint sAbreParent  sCierraParent;



RUNMULTDASM     ::= tRunMultDasm sAbreParent VALOR sCierraParent
                |   tRunMultDasm sAbreParent  sCierraParent
                |   tRunDasm sAbreParent VALOR sCierraParent
                |   tRunDasm sAbreParent  sCierraParent;

POINT           ::= tPoint sAbreParent LST_VALOR sCierraParent;


QUADRATE        ::= tQuadrate sAbreParent LST_VALOR sCierraParent;



OVAL            ::= tOval sAbreParent LST_VALOR sCierraParent;


STRING          ::= tString sAbreParent LST_VALOR sCierraParent;


LINE            ::= tLine sAbreParent LST_VALOR sCierraParent;

/*
|-------------------------------------------------------------------------------------------------------------------
| Valor
|-------------------------------------------------------------------------------------------------------------------
|  
*/


 VALOR          ::= E;

 E              ::= sMenos  E

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

                | valId  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                | valTrue
                | valFalse
                | valCadena 
                | valDecimal
                | valEntero

                //| tNulo
                ;