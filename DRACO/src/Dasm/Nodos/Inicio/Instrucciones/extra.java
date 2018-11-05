/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Nodos.Inicio.Instrucciones;

import Dasm.Estructuras.Elementos.elementoEntorno;
import Dasm.Estructuras.Items.itemRetorno;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class extra extends aritmeticas {
    
    public extra(itemAtributo atrib, elementoGlobal simbolo) {
        super(atrib, simbolo);
    }
    
    
    
    
    /**
     * <br> +----------------
     * <br> | tEqz
     * <br> +---------------- 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_25(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer  de pilita 
        Double num1 = entorno.Pilita.pop(atributo);

        Double resultado = 0.0;
        if (num1 == 0.0) {
            resultado = 1.0;
        }
        //Operando or bit a bit

        entorno.Pilita.push(resultado);

        return retorno;
    }

    
    
    /**
     * <br> +----------------
     * <br> | tPrint
     * <br> +---------------- 
     * <br> | Recibe dos parametros, uno de tipo cadena "%c"
     * <br> | el otro de tipo numerico pop a pilita
     * 
     * @param entorno Es el ambito que recibe
     * @return Retorna para revisión de break
     */
    public itemRetorno case_29(elementoEntorno entorno) {
        itemRetorno retorno = new itemRetorno();
        if (hayErrores()) {
            return retorno;
        }
        //extraer  de pilita 
        Double valor = entorno.Pilita.pop(atributo);
        String formato = entorno.Pilita.popCadena(atributo);
        int valEntero=valor.intValue();
        switch (formato.toLowerCase()) {
            case "%c":
                simbolo.setConsola(String.valueOf((char)valEntero));
                break;
            case "%d":
                simbolo.setConsola(String.valueOf(valEntero));
                break;
            case "%f":
                simbolo.setConsola(String.valueOf(valor));
                break;
            default:
                simbolo.tablaErrores.insertErrorSemantic(atributo,"No se reconoce el formato" +formato);
                break;
        }
        return retorno;
    }
}
