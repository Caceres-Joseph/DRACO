/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio;
import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno; 
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
     * @return El retorno es cuando viene un break
     */
    @Override
    public itemRetorno ejecutar(elementoEntorno entorno, int index){
        validandoDebug();
       
        itemRetorno retorno=new itemRetorno();
        if(hayErrores()){
            return retorno;
        } 
        return casos(entorno);
    }
    
    /**
     * Revisando los casos  
     * @param entorno
     * @return 
     */
    public itemRetorno casos(elementoEntorno entorno){
        
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno);
            case 2:
                return case_2(entorno);
            case 3:
                return case_3(entorno);
            case 4:
                return case_4(entorno);
            case 5:
                return case_5(entorno);
            case 6:
                return case_6(entorno);
            case 7:
                return case_7(entorno);
            case 8:
                return case_8(entorno);
            case 9:
                return case_9(entorno);
            case 10:
                return case_10(entorno);
            case 11:
                return case_11(entorno);
            case 12:
                return case_12(entorno);
            case 13:
                return case_13(entorno);
            case 14:
                return case_14(entorno);
            case 15:
                return case_15(entorno);
            case 16:
                return case_16(entorno);
            case 17:
                return case_17(entorno);
            case 18:
                return case_18(entorno);
            case 19:
                return case_19(entorno);
            case 20:
                return case_20(entorno);
            case 21:
                return case_21(entorno);
            case 22:
                return case_22(entorno);
            case 23:
                return case_23(entorno);
            case 24:
                return case_24(entorno);
            case 25:
                return case_25(entorno);
            case 26:
                return case_26(entorno);
//            case 27:
//                return case_27(entorno);
            case 28:
                return case_28(entorno);
                
            case 29:
                return case_29(entorno);
            case 30:
                return case_30(entorno);
            case 31:
                return case_31(entorno);
        }
         
        return new itemRetorno();
    }
    
    
    
    
     
    
}
