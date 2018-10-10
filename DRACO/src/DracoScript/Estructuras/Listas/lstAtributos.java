/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Listas;

import DracoScript.Estructuras.Items.itemAtributo;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class lstAtributos {
    public ArrayList<itemAtributo> lstAtributos=new ArrayList<>();
    
    
    public void insertar(itemAtributo hijo){
        lstAtributos.add(hijo);
    }
}
