/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio;
import Dasm.Estructuras.Elementos.elementoEntorno; 
import Dasm.Nodos.Inicio.Instrucciones.tee; 
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 

INSTRUCCION         ::=    valId
                    |   tAdd
                    |   tDiff
                    |   tMult
                    |   tDiv
                    |   tMod
                    |   tPot
                    // Relacionales 
                    |   tLt
                    |   tGt
                    |   tLte
                    |   tGte
                    // Logico 
                    |   tNot
                    |   tAnd
                    |   tOr
                    // Saltos 
                    |   tBr valId
                    |   tBrIf valId

                    // Instruc 
                    |   tGet_local  E 
                    |   tGet_local valId
                    |   tGet_global  E 
                    |   tGet_global valId

                    |   tSet_local  E 
                    |   tSet_local valId
                    |   tSet_global  E 
                    |   tSet_global valId
                    // Funciones 
                    |   tCall valId

                    // EXTRAS 
                    |   tEqz
                    //Tengo duda de como funciona
                    

                     // Num  
                    |   valEntero
                    |   valDecimal

                     // PARA IMPRIMIR  

                    |   valCadena

                    | tPrint

                    //
                    ;
 */
public class _INSTRUCCION extends tee{
    
    public _INSTRUCCION(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | EJECUTAR
    |-------------------------------------------------------------------------------------------------------------------
    |
    */
    
    /**
     * Metodo de ejecución final
     * @param entorno Es la tabla que contiene las variables 
     */
    @Override
    public void ejecutar(elementoEntorno entorno){
        
        validandoDebug();  
        if(hayErrores()){
//            entorno.punteroCodigo++;
            //para salirme de la ejecución
            entorno.punteroCodigo=-1;
            return ;
        }
        casos(entorno);
        
    }
    
    /**
     * Revisando los casos  
     * @param entorno
     */
    public void casos(elementoEntorno entorno){
        
        switch(atributo.nivelProduccion){
            case 0:
                 entorno.punteroCodigo++;
                 case_0(entorno);
                 break;
            case 1:
                 entorno.punteroCodigo++;
                 case_1(entorno);
                 break;
            case 2:
                 entorno.punteroCodigo++;
                 case_2(entorno);
                 break;
            case 3:
                 entorno.punteroCodigo++;
                 case_3(entorno);
                 break;
            case 4:
                 entorno.punteroCodigo++;
                 case_4(entorno);
                 break;
            case 5:
                 entorno.punteroCodigo++;
                 case_5(entorno);
                 break;
            case 6:
                 entorno.punteroCodigo++;
                 case_6(entorno);
                 break;
            case 7:
                 entorno.punteroCodigo++;
                 case_7(entorno);
                 break;
            case 8:
                 entorno.punteroCodigo++;
                 case_8(entorno);
                 break;
            case 9:
                 entorno.punteroCodigo++;
                 case_9(entorno);
                 break;
            case 10:
                 entorno.punteroCodigo++;
                 case_10(entorno);
                 break;
            case 11:
                 entorno.punteroCodigo++;
                 case_11(entorno);
                 break;
            case 12:
                 entorno.punteroCodigo++;
                 case_12(entorno);
                 break;
            case 13:
                 entorno.punteroCodigo++;
                 case_13(entorno);
                 break;
            case 14:
                 case_14(entorno);
                 //este es un salto
//                 entorno.punteroCodigo++;
                 break;
            case 15:
                 case_15(entorno);
                 //este es un salto condicional
//                 entorno.punteroCodigo++;
                 break;
            case 16:
                 entorno.punteroCodigo++;
                 case_16(entorno);
                 break;
            case 17:
                 entorno.punteroCodigo++;
                 case_17(entorno);
                 break;
            case 18:
                 entorno.punteroCodigo++;
                 case_18(entorno);
                 break;
            case 19:
                 entorno.punteroCodigo++;
                 case_19(entorno);
                 break;
            case 20:
                 entorno.punteroCodigo++;
                 case_20(entorno);
                 break;
            case 21:
                 entorno.punteroCodigo++;
                 case_21(entorno);
                 break;
            case 22:
                 entorno.punteroCodigo++;
                 case_22(entorno);
                 break;
            case 23:
                 entorno.punteroCodigo++;
                 case_23(entorno);
                 break;
            case 24:
                 entorno.punteroCodigo++;
                 case_24(entorno);
                 break;
            case 25:
                 entorno.punteroCodigo++;
                 case_25(entorno);
                 break;
            case 26:
                 entorno.punteroCodigo++;
                 case_26(entorno);
                 break;
//            case 27:
//                return case_27(entorno);
            case 28:
                 entorno.punteroCodigo++;
                 case_28(entorno);
                 break;
                
            case 29:
                 entorno.punteroCodigo++;
                 case_29(entorno);
                 break;
            case 30:
                 entorno.punteroCodigo++;
                 case_30(entorno);
                 break;
            case 31:
                 entorno.punteroCodigo++;
                 case_31(entorno);
                 break;
            default:
                entorno.punteroCodigo++;
                println("No se reconocio el numero de caso de los nodos hijos");
        }
          
    }
    
    
    
    
     
    
}
