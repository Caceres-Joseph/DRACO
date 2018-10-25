


   S                         LST_IMPORT + CP_CLASE
                            | CP_CLASE;

    LST_IMPORT              ->LST_IMPORT IMPORT 
                            |IMPORT
 
    TIPO                    ->tEntero
                            |tDecimal
                            |tCaracter
                            |tBooleano 
                            |tVacio

    IMPORT.Rule = tImport + sAbreParent + E + sCierraParent + sPuntoComa
            | SyntaxError;

                     

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Parametros
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    LST_PARAMETROS         -> LST_PARAMETROS sComa PARAMETRO
                            |PARAMETRO



    PARAMETRO               ->TIPO  VAR_ARREGLO

    LST_VAL                 ->LST_VAL  sComa VALOR
                            |VALOR


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo de la clase
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */
                            



    CP_CLASE            ->CP_CLASE CUERPO_CLASE   
                        |CUERPO_CLASE

    CUERPO_CLASE        ->DECLARAR_VARIABLE + sPuntoComa
                        | METODO
                        | MAIN 
                        | ESTRUCTURA
 
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Estructuras
    |-------------------------------------------------------------------------------------------------------------------
    | Solo tengo que aceptar  
    */

    ESTRUCTURA          ->tEstructura tId sAbreLlave  LST_DECLARAR_VAR  sCierraLlave




    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones/Metodos
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    METODO.Rule     ->TIPO  VAR_ARREGLO   sAbreParent   LST_PARAMETROS  sCierraParent  sAbreLlave  LST_CUERPO  sCierraLlave
                     


    MAIN.Rule       ->TIPO tPrincipal  sAbreParent  sCierraParent sAbreLlave  LST_CUERPO  sCierraLlave
 
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Declarar variable
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    LST_DECLARAR_VAR        ->LST_DECLARAR_VAR DECLARAR_VARIABLE sPuntoComa
                            |DECLARAR_VARIABLE sPuntoComa

    DECLARAR_VARIABLE       ->DECLARAR_VARIABLE sComa VAR_ARREGLO VAL
                            | DECLARAR_VARIABLE sComa  VAR_ARREGLO 
                            | TIPO VAR_ARREGLO VAL
                            | TIPO VAR_ARREGLO



    VAL                     ->sIgual  VALOR
    

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

    LST_LLAVES_VAL              ->LST_LLAVES_VAL sComa LLAVES_VAL_P
                                | LLAVES_VAL_P



    LLAVES_VAL_P                ->sAbreLlave  LST_LLAVES_VAL  sCierraLlave
                                | sAbreLlave + LST_VAL + sCierraLlave


    /*
    |----------------------------------------------
    | Corchetes
    */


    VAR_ARREGLO                 ->valId
                                | valId  LST_CORCHETES_VAL

    //LST_CORCHETES               ->LST_CORCHETES PAR_CORCHETES_VAL
    //                            | PAR_CORCHETES_VACIOS

    //PAR_CORCHETES_VACIOS        ->sAbreCorchete + sCierraCorchete;

    

    LST_CORCHETES_VAL           ->LST_CORCHETES_VAL  PAR_CORCHETES_VAL
                                | PAR_CORCHETES_VAL

    PAR_CORCHETES_VAL           ->sAbreCorchete  VALOR  sCierraCorchete




    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Para poder acceder a los metodos o variables
    |-------------------------------------------------------------------------------------------------------------------
    | Me va devolver un metodo () al final
    | Me va devolver un Id al final
    */


    ID_VAR_FUNC         ->ID_VAR_FUNC  LST_PUNTOSP
                        | valId
                        | valId  sAbreParent  LST_VAL  sCierraParent
                        //para hacer uso de corchetes
                        | valId  LST_CORCHETES_VAL
                        | valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL


    LST_PUNTOSP         ->sPunto  valId
                        | sPunto  valId  sAbreParent  LST_VAL  sCierraParent

                        //Corchetes
                        | sPunto  valId  LST_CORCHETES_VAL
                        | sPunto  valId  sAbreParent  LST_VAL  sCierraParent  LST_CORCHETES_VAL



    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Asignar valor
    |-------------------------------------------------------------------------------------------------------------------
    | Hay que validar que reciba un id, y no un idFUNC
    */
 
    ASIG_VALOR          ->ID_VAR_FUNC + VAL
                        | ID_VAR_FUNC + sMas + sMas
                        | ID_VAR_FUNC + sMenos + sMenos
                        
                        


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Cuerpo
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    LST_CUERPO          ->LST_CUERPO CUERPO
                        |CUERPO


    CUERPO              ->LST_DECLARAR_VAR  
                        | ID_VAR_FUNC  sPuntoComa //hay que validar que sea un metodo y no una variables
                        | ASIG_VALOR  sPuntoComa
                        | Empty 
                        | FUNCIONES_NATIVAS + sPuntoComa
                        | SENTENCIAS
                       
                       
                        //| USAR_METODO
                        | ROMPER
                        | CONTINUAR
                        | RETORNO
                       
         
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias de cotrol
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    RETORNO.Rule = tRetornar + sPuntoComa
        | tRetorno + VALOR + sPuntoComa;

    ROMPER.Rule = tDetener + sPuntoComa;

    CONTINUAR.Rule = tContinuar + sPuntoComa;              

    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Sentencias 
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */

    SENTENCIAS.Rule = SI
        // | SI_SIMPLIFICADO
        | CASO

        //CICLOS
        | WHILE
        | FOR
        | DOWHILE
        | REPETIR;

    /*
    ------------------------------------------
    * SI 
    ------------------------------------------
    *  
    */
 



    SI.Rule = tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave
        | tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO_SI
        | tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO;

    SINO_SI.Rule = tSino + tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO_SI
        | tSino + tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave
        | tSino + tSi + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave + SINO;

    SINO.Rule = tSino + sAbreLlave + LST_CUERPO + sCierraLlave;


    /*
    ------------------------------------------
    * SI SIMPLIFICADO
    ------------------------------------------
    */

    SI_SIMPLIFICADO.Rule = VALOR + sCierraInterrogante + E + sDosPuntos + E;

    /*
    ------------------------------------------
    * WHILE
    ------------------------------------------
    */

    WHILE.Rule = tMientras + sAbreParent + E + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave;


    /*
    ------------------------------------------
    * FOR
    ------------------------------------------
    */

    FOR.Rule = tPara + sAbreParent + DECLARAR_VARIABLE + sPuntoComa + E + sPuntoComa + ASIG_VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave
        | tPara + sAbreParent + ASIG_VALOR + sPuntoComa + E + sPuntoComa + ASIG_VALOR + sCierraParent + sAbreLlave + LST_CUERPO + sCierraLlave;


    /*
    |-------------------------------------------------------------------------------------------------------------------
    | Funciones Nativas
    |-------------------------------------------------------------------------------------------------------------------
    |  
    */
 


    FUNCIONES_NATIVAS       ->IMPRIMIR 
                            | PUNTO
                            | CUADRADO
                            | OVALO 
                            | CADENA
                            | LINEA
        
         

    IMPRIMIR.Rule = tImprimir + sAbreParent + VALOR + sCierraParent
        | tImprimir + sAbreParent + sCierraParent;

    PUNTO.Rule = tPunto + sAbreParent + LST_VALOR + sCierraParent;
 
    CUADRADO.Rule = tCuadrado + sAbreParent + LST_VALOR + sCierraParent;
 
    OVALO.Rule = tOvalo + sAbreParent + LST_VALOR + sCierraParent;


    CADENA.Rule = tCadena + sAbreParent + LST_VALOR + sCierraParent;

    LINEA.Rule = tLinea + sAbreParent + LST_VALOR + sCierraParent;


            /*
            |-------------------------------------------------------------------------------------------------------------------
            | Valor
            |-------------------------------------------------------------------------------------------------------------------
            |  
            */

  VALOR.Rule = //aqui tengo que reconocer el-> nuevo opciones()
                | tNuevo + TIPO + LST_CORCHETES_VAL
                | LST_LLAVES_VAL 
                | E;




            E.Rule =
                sMenos + E
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

                | ID_VAR_FUNC  //validar que si viene func() tiene que retornar algo obligatoriamente prro
                | valBoolean
                | valCadena
                | valCadena2
                | valCaracter
                | valDecimal
                | valNumero
                | tNulo
                | tNada
                | SI_SIMPLIFICADO 

