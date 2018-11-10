/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.DeclararVariable;
 
import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemEstructura;
import D_plus.Estructuras.Items.itemValor; 
import D_plus.Nodos.Arreglo._VAR_ARREGLO;
import D_plus.Nodos.Inicio._TIPO;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 * Sirve para la primer pasada
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 

DECLARAR_VARIABLE   ::= DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL 
                    |   DECLARAR_VARIABLE sComa VAR_ARREGLO
                    |   TIPO VAR_ARREGLO VAL
                    |   TIPO VAR_ARREGLO
                    ;
 */
public class _DECLARAR_VARIABLE_1 extends nodoModelo{
    
    public _DECLARAR_VARIABLE_1(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
   
    /*
    |-------------------------------------------------------------------------------------------------------------------
    | RETORNAR EL VALOR
    |-------------------------------------------------------------------------------------------------------------------
    |
     */
    /**
     * Metodo que retorna el valor
     *
     * @param estructura
     */ 
    public void llenarEstructura(itemEstructura estructura){ 
         iniciar( estructura); 
    }
    
    
    
    /**
     * Inicia el analisis de ejecución
     *
     * @param estructura
     */
     
    public void iniciar( itemEstructura estructura) {

        if (hayErrores()) {
            return;
        }

        switch (atributo.nivelProduccion) {
            case 0:
                v_case_0( estructura);
                return;
            case 1:
                v_case_1( estructura);
                return;
            case 2:
                v_case_2(  estructura);
                return;
            case 3:
                v_case_3(  estructura);
                return;
            default:
                println("[casos]Ninguno de los casos");

        }

    }
    
    
    
    /**
     * <br> +----------------
     * <br> | TIPO DECLARAR_VARIABLE sComa VAR_ARREGLO  VAL
     * <br> +---------------- 
     * 
     * @param estructura
     */
    public void v_case_0(  itemEstructura estructura) {
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No se pueden inicializar valores dentro de una estructura.");
    }
    
    
    /**
     * <br> +----------------
     * <br> | TIPO DECLARAR_VARIABLE sComa VAR_ARREGLO
     * <br> +---------------- 
     * 
     * @param estructura
     */
    public void v_case_1(  itemEstructura estructura) {
        
        
       //declarando las variables anteriores
        _DECLARAR_VARIABLE e1 = (_DECLARAR_VARIABLE) listaHijos.lstHijos.get(1); 
        e1.llenarEstructura(  estructura);
        
        
        //ejecutando 
        _TIPO nodTipo = (_TIPO) listaHijos.lstHijos.get(0); 
        _VAR_ARREGLO varArreglo = (_VAR_ARREGLO) listaHijos.lstHijos.get(2);
        declararNulos(nodTipo, varArreglo, estructura);
        
         
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | TIPO VAR_ARREGLO VAL 
     * <br> +---------------- 
     * 
     * @param estructura
     */
    public void v_case_2(  itemEstructura estructura) {
       
         simbolo.tablaErrores.insertErrorSemantic(atributo, "No se pueden inicializar valores dentro de una estructura.");
    }
    
    
    
    /**
     * <br> +----------------
     * <br> | TIPO VAR_ARREGLO
     * <br> +---------------- 
     * 
     * @param estructura
     */
    public  void v_case_3(  itemEstructura estructura) {
          
        _TIPO nodTipo = (_TIPO) listaHijos.lstHijos.get(0); 
        _VAR_ARREGLO varArreglo = (_VAR_ARREGLO) listaHijos.lstHijos.get(1);
        
        declararNulos(nodTipo, varArreglo,estructura);
       
    }
       
    public void declararNulos(_TIPO nodTipo,_VAR_ARREGLO varArreglo, itemEstructura estructura){
        itemAtributo tipo = nodTipo.getTipo();
        itemAtributo idVar = varArreglo.getId();
        int dimension = varArreglo.getDimension();
 
        itemValor val=new itemValor(simbolo);
        val.esNulaSuprema=true;
        val.tipo=tipo.valor;
         
         
        //guardando la variable en la tabla de simbolos
        estructura.lstVariables.insertarVariable(idVar, val, tipo.valor, dimension, 0 , "estructura");
         
    }
    
}
