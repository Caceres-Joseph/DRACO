/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Nodos.Nativas;

import Dasm.Gramatica.Analizador.anlzDasm;
import DracoScript.Estructuras.Elementos.elementoEntorno;
import DracoScript.Estructuras.Items.itemRetorno;
import DracoScript.Estructuras.Items.itemValor;
import DracoScript.Nodos.Valor._VALOR;
import Gui.Elementos.elementoGlobal;
import Gui.Items.itemAtributo;
import DracoScript.Nodos.nodoModelo;
import Gui.Nodos.nodoTabClase;


/**
 * Nodo para asignar el valor 
 * @author joseph
 * +----------------------
 * | NO TERMINAL:
 * | Es donde se guardan los no terminales
 * +----------------------

    RUNMULTDASM     ::= tRunMultDasm sAbreParent VALOR sCierraParent
                |   tRunMultDasm sAbreParent  sCierraParent
                |   tRunDasm sAbreParent VALOR sCierraParent
                |   tRunDasm sAbreParent  sCierraParent;
 */
 
public class _RUNMULTDASM extends nodoModelo{
    
    /**
     * constructor de _RUNMULTDASM
     * @param atrib Atributo que contiene los datos del nodo, como la linea, la columna, y el nombre dela rchivo
     * @param simbolo Es el simbolo global
     */

    public _RUNMULTDASM(itemAtributo atrib, elementoGlobal simbolo) {
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
     * @return 
     */
       @Override
    public itemRetorno ejecutar(elementoEntorno entorno) {
        itemRetorno ret = new itemRetorno();
        if (hayErrores()) 
            return ret;
        validandoDebug();
        
        
        switch(atributo.nivelProduccion){
            case 0:
                
                _VALOR nod = (_VALOR) listaHijos.lstHijos.get(0);
                itemValor tel = nod.getValor(entorno);
                Object ret2 = tel.getValorParseado("cadena", atributo);
                String pColor=(String)ret2;
                println("hay que buscar el archivo:"+pColor);
                buscando_nodoTab(pColor);

                break;
            case 1:
                
                break;
            case 2:
                
                break; 
                
            case 3:
                
                
                break;
        }
        //buscando el indice de la tab con el nombre:
        
        
        
//        SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
//        int indice = selectionModel.getSelectedIndex(); 
//        simbolo.listaTabsClases.ejecutarNodo(indice);
        
        return ret; 
    } 
    
      public void buscando_nodoTab(String nombreArchivo) {
        int indice = 0;
        for (nodoTabClase listaTab : simbolo.listaTabsClases.listaTabs) {
            if (listaTab.nombre.equals(nombreArchivo)) {
                String entradaDasm = listaTab.ejecutar2();

                println("[run][DASM]Iniciando Hilo de Ejecución");
                anlzDasm dDasm = new anlzDasm(entradaDasm, nombreArchivo, simbolo);
                dDasm.analizar();
                if (dDasm.raiz != null) {
                    //primer pasada
//                       Dasm.Estructuras.Elementos.elementoClase claseDasm=new Dasm.Estructuras.Elementos.elementoClase(simbolo);
//                       dDasm.raiz.primerPasada(claseDasm); 

                    //ejecución
                    Dasm.Estructuras.Elementos.elementoEntorno entornoDasm = new Dasm.Estructuras.Elementos.elementoEntorno(simbolo, dDasm.raiz.listaHijosHash.listaMetodoFuncion, dDasm.raiz.listaHijosHash.listaEtiquetas);
                    //coloco el puntero de codigo en el inicio
                    entornoDasm.punteroCodigo = 0;
                    //lo paso al global para poder mostrarlo en tablas
                    simbolo.entornoDasm = entornoDasm;
//                       
                    dDasm.raiz.ejecutar(entornoDasm);
                    simbolo.tablaSimbolosDasm.mostrar(simbolo);

                } else {
                    println("[DASM]Raiz nula");
                }
                break;

            }
            indice++;
        }
    } 
    
}
