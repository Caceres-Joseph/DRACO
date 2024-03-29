/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;

import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.lstPolimorfismo;
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import Gui.Elementos.elementoGlobal;

/**
 *
 * @author joseph
 */
public class lstPrincipal {
     public lstPolimorfismo listaMain = new lstPolimorfismo();
    elementoGlobal simbolo;

    
    public lstPrincipal(elementoGlobal simbolo){
        this.simbolo=simbolo;
        
//        
//        map.put("Adobe", "Mountain View, CA");
//        Iterator k = map.keySet().iterator();
//        while (k.hasNext()) {
//          String key = (String) k.next();
//          System.out.println("Key " + key + "; Value " + (String) map.get(key));
//        }
        
    }

    public void imprimir() {
         
        println("[--- Imprimiendo la lista polimorfa---");
        listaMain.imprimir();
    }
    
    
    /**
     * Traduccion del metodo
     * @param entorno 
     */
    public void ejecutar(elementoEntorno entorno){
        for (lstPolimorfismo.nodoArreglo arreglo : listaMain.lista) {
            clavePolimorfa clave=arreglo.clave;
            valorPolimorfo valor=arreglo.valor;
            
            //aqui se crea un nuevo entorno
            
            
            elementoEntorno entornoMain=new elementoEntorno(entorno, "principal", simbolo, 1, entorno.funciones);
            
            
            simbolo.salidaDasm.comentarioMediano("Principal");
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getFuncion("$principal"), entorno.nivel);
            valor.cuerpo.ejecutar(entornoMain); 
            simbolo.salidaDasm.linea(simbolo.salidaDasm.gettEtiquetaRetornar(), entornoMain.nivel);
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getEnd(), entorno.nivel);
            
            
        }
    }
    
    /**
     * Inicia la traducción a código DASM
     * @param elemento
     */
//    public void traducir(elementoEntorno elemento){
//        //debería haber solo un principal
//        
//        if(listaMain.lista.isEmpty()){
//            simbolo.salidaDasm.comentarioGrande("No hay metodo principal");
//            
//        }else{
//            
//            simbolo.salidaDasm.comentarioGrande("Principal");
//            
//            simbolo.salidaDasm.lineaComentada(simbolo.salidaDasm.getCall("$principal"), "Metodo Principal", elemento.nivel);
//            simbolo.salidaDasm.comentarioMediano("Funcion principal");
//            simbolo.salidaDasm.linea(simbolo.salidaDasm.getFuncion("$principal"), 0);
//            
//            elementoEntorno entornoMain =new elementoEntorno(elemento, "principal", simbolo, elemento.nivel+1);
//            valorPolimorfo val= listaMain.lista.get(0).getValor();
//            val.cuerpo.ejecutar(entornoMain);
//            
//            simbolo.salidaDasm.linea(simbolo.salidaDasm.getEnd(), 0);
//        }
//         
//    }
    
    /**
     * 
     * @param mensaje 
     */
    public void println(String mensaje){
        System.out.println("[lstPrincipal]"+mensaje);
    }
    
    
    
    
}
