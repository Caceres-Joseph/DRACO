/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Items;

import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class itemValor {
    
    /**
     * Tipos que soporta el lenguaje
     * <br>
     * <br> |--------------------------------------------------------------------------
     * <br> | <h2>Tipos que soporta el lenguaje</h2>
     * <br> |
     * <br> |--------------------------------------------------------------------------
     * <br> | cadena
     * <br> | booleano
     * <br> | numero 
     * <br> | char
     * <br> | nulo
     */
    public String tipo = "nulo";
    public Object valor;
    public elementoGlobal simbolo;
    
    
    /**
     * Constructor que recibe la tabla de errores
     * @param simbolo Se usa para la tabla de errores
     */
    public  itemValor(elementoGlobal simbolo) {
        this.simbolo=simbolo;
//        setValor();
    }
}
