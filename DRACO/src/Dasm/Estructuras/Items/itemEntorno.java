/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dasm.Estructuras.Items;

import Dasm.Estructuras.Listas.lstEtiquetas;
import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class itemEntorno {
    
    public lstEtiquetas listaEtiquetas; 
    public int punteroCodigo=0;
    public elementoGlobal simbolo;
    
    
    public itemEntorno(elementoGlobal simbolo, lstEtiquetas listaEtiquetas){
        this.simbolo=simbolo;
        this.listaEtiquetas=listaEtiquetas;
    }
    
}
