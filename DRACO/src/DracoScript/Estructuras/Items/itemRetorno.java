/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Items;

/**
 *
 * @author joseph
 */
public class itemRetorno {

    public int tipoRetorno = 0;

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
     */
    public void setBreak() {
        this.tipoRetorno = 1;
    }

}
