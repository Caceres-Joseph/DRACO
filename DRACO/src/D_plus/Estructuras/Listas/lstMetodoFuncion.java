/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas;
 
import D_plus.Estructuras.Elementos.elementoEntorno;
import D_plus.Estructuras.Items.itemValor;
import D_plus.Estructuras.Listas.HashPolimorfa.clavePolimorfa;
import D_plus.Estructuras.Listas.HashPolimorfa.lstPolimorfismo; 
import D_plus.Estructuras.Listas.HashPolimorfa.valorPolimorfo;
import D_plus.Nodos.nodoModelo;
import Gui.Elementos.elementoGlobal; 
import Gui.Items.itemAtributo;

/**
 *
 * @author joseph
 */


public class lstMetodoFuncion {
    public lstPolimorfismo listaMetodoFuncion = new lstPolimorfismo();
    elementoGlobal simbolo;

    
    public lstMetodoFuncion(elementoGlobal simbolo){
        this.simbolo=simbolo;
        
//        
//        map.put("Adobe", "Mountain View, CA");
//        Iterator k = map.keySet().iterator();
//        while (k.hasNext()) {
//          String key = (String) k.next();
//          System.out.println("Key " + key + "; Value " + (String) map.get(key));
//        }
        
    }
    
    
    /**
     * Traduccion del metodo
     * @param entorno 
     */
    public void ejecutar(elementoEntorno entorno){
        for (lstPolimorfismo.nodoArreglo arreglo : listaMetodoFuncion.lista) {
            clavePolimorfa clave=arreglo.clave;
            valorPolimorfo valor=arreglo.valor;
            
            //aqui se crea un nuevo entorno
            
            
            elementoEntorno entornoMain=new elementoEntorno(entorno, clave.nombre.valor, simbolo, 1, entorno.funciones);
            
            
            simbolo.salidaDasm.comentarioMediano(clave.nombre.valor+"("+valor.parametros.getCadena_parametros()+")");
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getFuncion("$"+clave.nombre.valor+valor.parametros.parteNombreFuncion()), entorno.nivel);
            for (String codigoParametro : valor.parametros.getCodigoParametros(entornoMain)) {
                simbolo.salidaDasm.linea(codigoParametro, entornoMain.nivel);
            }
            
            
            valor.cuerpo.ejecutar(entornoMain);
            simbolo.salidaDasm.linea(simbolo.salidaDasm.gettEtiquetaRetornar(), entornoMain.nivel);
            simbolo.salidaDasm.linea(simbolo.salidaDasm.getEnd(), entorno.nivel);
            
            
        }
        
    }
    
    public nodoModelo getFuncion(itemAtributo nombreFuncion, clavePolimorfa clave){
        
       valorPolimorfo valor= listaMetodoFuncion.getValorPolimorfo(clave);
       if(valor==null){
           simbolo.tablaErrores.insertErrorSemantic(nombreFuncion,"No fue posible encontrar la funcion: "+nombreFuncion.valor +"("+clave.getListaTiposString()+")" );
           return null;
       }
       
       return valor.cuerpo; 
    }
    
    
    
    public void imprimir() {
         
        println("[--- Imprimiendo la lista polimorfa---");
        listaMetodoFuncion.imprimir();
    }
    
    
    public void println(String mensaje){
        System.out.println("[lstMetodoFuncion]"+mensaje);
    }
    
    
}
