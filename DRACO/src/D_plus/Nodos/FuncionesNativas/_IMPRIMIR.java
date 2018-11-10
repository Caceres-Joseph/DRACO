/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Nodos.FuncionesNativas;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemRetorno;
import D_plus.Estructuras.Items.itemValor; 
import D_plus.Nodos.Valor._VALOR;
import Gui.Items.itemAtributo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal;  

/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------
 * 
IMPRIMIR                ::= tImprimir  sAbreParent  VALOR  sCierraParent
                        |   tImprimir  sAbreParent  sCierraParent
                        ;
 */
public class _IMPRIMIR extends nodoModelo{
    
    public _IMPRIMIR(itemAtributo atrib, elementoGlobal simbolo) {
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
    public itemRetorno ejecutar(elementoEntorno entorno){ 
        validandoDebug();
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        
        return casos(entorno);
    }
    
    public itemRetorno casos(elementoEntorno entorno) { 
        itemRetorno retorno=new itemRetorno();
          
        switch(atributo.nivelProduccion){
            case 0:
                return case_0(entorno);
            case 1:
                return case_1(entorno); 
            
            default:
                println("[casos]Ninguno de los casos");
                return retorno;
        }  
    }
    
    
    /**
     * <br> +----------------
     * <br> | tImprimir  sAbreParent  VALOR  sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_0(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();

        _VALOR nodoValor = (_VALOR) listaHijos.lstHijos.get(0);
        itemValor valValor = nodoValor.getValor(entorno);

        if (valValor.isTypeNulo()) { 
            //llamando a la funcion prro
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getCall("$DASM_IMPRIMIR_NULO"), entorno.nivel);
                
        } else if (valValor.dimension != 0) {
            
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getCall("$DASM_IMPRIMIR_OBJECT"), entorno.nivel);
            return retorno;
        } else {
            if (valValor.esEstructura) {
                
//                simbolo.setConsola("\nestructura");
            } else {
                switch (valValor.tipo) {
                    case "numero":
                        parametroNumero(valValor, entorno);
                        break;
                    case "caracter":
                        parametroCaracter( valValor, entorno);
                        break;
                    case "cadena":
                        parametroCadena( valValor, entorno);
                        break;
                    case "booleano":
                        parametroNumero( valValor, entorno);
                        break;
                    default:
                        println("[case_00]es una estructura");
                        //tiene que ser una estructura
                        break;
                }
            }
        }
        return retorno;
    }
 
    private void saltoDeLinea(elementoEntorno entorno){
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrintCaracter(), "Imprimiendo caracter", entorno.nivel);
        simbolo.salidaDasm.lineaComentada("10", "salto ln", entorno.nivel);
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrint(), "Imprimiendo", entorno.nivel);
    }
     private void parametroNumero(itemValor valValor, elementoEntorno entorno) {

        simbolo.salidaDasm.comentarioPequeño("Imprimir", "Imprimiendo numero", entorno.nivel);
         saltoDeLinea(entorno);
         simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrintDecimal(), "Imprimiendo numero", entorno.nivel);
        /*CODIGO DASM*/
        //operaciones E
        simbolo.salidaDasm.comentario("operacionesE", entorno.nivel);
        for (String string : valValor.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrint(), "Imprimiendo", entorno.nivel);

    }
     
    private void parametroCaracter(itemValor valValor, elementoEntorno entorno) {
        simbolo.salidaDasm.comentarioPequeño("Imprimir", "Imprimiendo caracter", entorno.nivel);
        saltoDeLinea(entorno);
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrintCaracter(), "Imprimiendo caracter", entorno.nivel);
        /*CODIGO DASM*/
        //operaciones E
        simbolo.salidaDasm.comentario("operacionesE", entorno.nivel);
        for (String string : valValor.cadenaDasm) {
            simbolo.salidaDasm.linea(string, entorno.nivel);
        }
        simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getPrint(), "Imprimiendo", entorno.nivel);
    }
      
    private void parametroCadena(itemValor valValor, elementoEntorno entorno){
          
        
                simbolo.salidaDasm.comentarioPequeño("DASM_IMPRIMIR_CADENA", "Imprimiendo cadena", entorno.nivel);
                /*PARAM 1*/ 
                simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "PARAMETRO 1:"+ valValor.tipo, entorno.nivel);
                //tamaño del ambito
                simbolo.salidaDasm.linea(String.valueOf(entorno.posRelativa - 1), entorno.nivel);
                //sumanodo
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
                //Num parametro
                simbolo.salidaDasm.linea("1", entorno.nivel);
                //sumando
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
                //operaciones E
                simbolo.salidaDasm.comentario("operacionesE", entorno.nivel);
                for (String string : valValor.cadenaDasm) {
                    simbolo.salidaDasm.linea(string, entorno.nivel);
                }
                
                
                
                
                //obtengo el puntero
                simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getGet_local_id("0"), "Iniciando llamado", entorno.nivel);
                //tamanio del ambito para avanzar
                simbolo.salidaDasm.linea(String.valueOf(entorno.posRelativa - 1), entorno.nivel);
                //sumando
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getAdd(), entorno.nivel);
                //actualizando puntero
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getSet_local_id("0"), entorno.nivel);
                //llamando a la funcion prro
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getCall("$DASM_IMPRIMIR_CADENA"), entorno.nivel);
                //obtengo el puntero
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getGet_local_id("0"), entorno.nivel);

                //tamanio del ambito para regresar
                simbolo.salidaDasm.linea(String.valueOf(entorno.posRelativa - 1), entorno.nivel);
                //resto
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getDiff(), entorno.nivel);
                //actualizando puntero
                simbolo.salidaDasm.linea(simbolo.salidaDasm.getSet_local_id("0"), entorno.nivel);
 
         
    }
     
    /**
     * <br> +----------------
     * <br> | tImprimir  sAbreParent  sCierraParent
     * <br> +---------------- 
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_1(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno(); 
          
        return retorno;
    }
    
     
    
}
