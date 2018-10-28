/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas.HashPolimorfa;
 
import D_plus.Estructuras.Items.itemParametro;
import D_plus.Estructuras.Listas.lstParametro; 
import Gui.Items.itemAtributo;
import java.util.ArrayList;
import java.util.Map;

/**
 *<br> Clave para saber si un elemento polimorfo es único
 * @author joseph
 */
public class clavePolimorfa {
    
    /**
     * <br> Lista que contiene tipos y dimensiones
     * <br> |TIPO    |   DIMENSION
     * <br> +--------+-------------
     * <br> |cadena  |  3
     * <br> |cadena  |  0
     * <br> |int     |  2
     */
    public ArrayList<itemClave> lstClaves;
    public itemAtributo nombre;
    /**
     * Se insertan los valores para crear la clavePolimorfa
     * @param parametros  Lista de parametros para formar la clave
     * @param nombre
     */
    public clavePolimorfa(lstParametro parametros, itemAtributo nombre){
        this.nombre=nombre;
        lstClaves =new ArrayList<>();
        
        for (Map.Entry<String,itemParametro> lstVariable : parametros.listaParametros.entrySet()) {
//            String k=lstVariable.getKey();
            itemParametro v=lstVariable.getValue();
            itemClave clave=new itemClave(v.tipo.valor, v.dimension);
            lstClaves.add(clave);
        }
    } 
    
    public void imprimir(){
        println("CLAVE:"+nombre.valor+"--");
        for (itemClave lstClave : lstClaves) {
            println("tipo:"+lstClave.tipo+"|"+"dim:"+String.valueOf(lstClave.dimension));
        } 
    }
    
    
    public void println(String mensaje){
        System.out.println("[clavePolimorfa]"+mensaje);
    }
    
    
     
    /**
     * Verificando si ya se encuentra el metodo 
     * @param clave2
     * @return 
     */
    public boolean esIgual(clavePolimorfa clave2){
         
        //validando si se llaman igual
        if(!nombre.valor.equals(clave2.nombre.valor)){
            return false; 
        }
        
        //validando las longitudes
        else if(lstClaves.isEmpty() && clave2.lstClaves.isEmpty()){
            return true;
        }
        else if(lstClaves.size()==clave2.lstClaves.size()){
            
            for (int i = 0; i < lstClaves.size(); i++) {
                itemClave tempClave1= lstClaves.get(i);
                itemClave tempClave2=clave2.lstClaves.get(i);
                //validando que sean del mismo tipo y de la misma dimension
                if ((tempClave1.tipo.equals(tempClave2.tipo)) && (tempClave1.dimension == tempClave2.dimension)) {
                    
                }else{
                    return false;
                }
            } 
            return true;
        }else{
            return false;
        }
         
    }
    
    /**
     * Clase para tener un par de tipo [tipo][dimension]
     */
     
    public class itemClave{
        String tipo;
        int dimension;
        
        public itemClave(String tipo, int dimension){
            this.tipo=tipo;
            this.dimension=dimension; 
        }
    }
    
}
