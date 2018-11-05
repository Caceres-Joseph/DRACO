/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Items;

import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */
public class itemRetorno {
    
    public int tipoRetorno = 0;
    public itemAtributo etiquetaDestino;

    /**
     * |--------------------------------------------------------------------------
     * | itemRetorno
     * |--------------------------------------------------------------------------
     * | 0 = normal | 1 = return
     *
     */
    /**
     *
     */
    public itemRetorno() {
        tipoRetorno = 0;
    }

    /**
     * Es un retorno normal
     */
    public void setNormal() {
        this.tipoRetorno = 0;
    }

    /**
     * Es un braek
     * @param etiquetaOrigen Es la etiqueta a donde se quiere saltar
     */
    public void setBreak(itemAtributo etiquetaOrigen) {
        this.tipoRetorno = 1;
        this.etiquetaDestino=etiquetaOrigen;
        
    }
    
    
    
    /**
     * Es un retorno normal
     * @return Booleano para verificar si no hay smash
     */
    public boolean ifNormal() {
        if(this.tipoRetorno==0){
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Es un braek
     * @return Booleano para confirmar si hay smash
     */
    public boolean ifBreak() {
        if(this.tipoRetorno==1){
            return true;
        }else{
            return false;
        }
    } 
}
