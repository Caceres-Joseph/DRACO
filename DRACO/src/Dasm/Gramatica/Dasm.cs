


LST_CUERPO          ::=LST_CUERPO CUERPO 
                    |  CUERPO

CUERPO              ::=INSTRUCCION
                    |  FUNCION
                    ;

LST_INSTRUCCIONES   ::= LST_INSTRUCCIONES INSTRUCCION
                    |   INSTRUCCION
                    ;

INSTRUCCION         ::=  
                   
                    /* Aritemeticas */
                    |   tAdd
                    |   tDiff
                    |   tMult
                    |   tDiv
                    |   tMod
                    |   tPot


                    /* Relacionales */
                    |   tLt
                    |   tGt
                    |   tLte
                    |   tGte
                    /* Logico */
                    |   tNot
                    |   tAnd
                    |   tOr
                    /* Saltos */
                    |   tBr valId
                    |   tBrIf valId
                    |    valId //esta es la etiqueta para saltar
                    /* Instruc */
                    |   tGet_local valNum
                    |   tGet_local valId
                    |   tGet_global valNum
                    |   tGet_global valId

                    |   tSet_local valNum
                    |   tSet_local valId
                    |   tSet_global valNum
                    |   tSet_global valId
                    /* Funciones */
                    |   tCall valId

                    /* EXTRAS */
                    |   tEqz

                    /* Num */
                    |   valEntero
                    |   valDecimal
                    ;

 FUNCION            ::= tFuncion valId LST_INSTRUCCIONES tEnd;