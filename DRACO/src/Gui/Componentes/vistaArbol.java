/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Componentes;

import GUI.Principal;
import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;

/**
 *
 * @author joseph
 */
public class vistaArbol {
    
    TreeView<String> vistaArbol;
    
    /**
     * 
     * @param vistaArbol Elemento treeView
     */
    public vistaArbol(TreeView<String> vistaArbol){
        this.vistaArbol=vistaArbol;
        
    }
    
    
    
    
}
