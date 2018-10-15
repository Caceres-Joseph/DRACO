/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DracoScript.Estructuras.Items;

import DracoScript.Estructuras.Elementos.elementoGlobal;

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
        setValor();
    }
    
    
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| Set Value
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa cuando se envian los valores, y luego estos son parseados
     */
    /**
     * @param cadena Se esta recibiendo un tipo cadena
     */
    public  void setValor(String cadena) {
        this.tipo = "cadena";
        this.valor = cadena; 
    }
    
    
    /**
     * @param char2 elemento char
     */
    public  void setValor(char char2) {
        this.tipo = "char";
        this.valor = char2; 
    }

    /**
     * @param valor Valor booleano
     */
    public void  setValor(Boolean valor) {
        this.tipo = "booleano";
        this.valor = valor; 
    }

    /**
     * @param entrada Valor entero 
     */
    public void  setValor(double entrada) {
        this.tipo = "numero";
        this.valor = entrada; 
    }

    /** 
     * Convierte el valor en nulo
     */
    public void  setValor() {
        this.tipo = "nulo";
        this.valor= null; 
    }    
    
    
    
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| GET Value
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa para obtener el valor ya parseado
     */
    
    /**
     * @return Retorna una cadena si no hay problema en parseo
     */
    public  String getCadena() {
        String retorno="";
        try {
            retorno= (String)valor;
             
        } catch (Exception e) {
            println("[getCadena]"+e.getMessage()); 
        }  
        return retorno;
    }
    
    
    /**
     * @return retorno de char
     */
    public  char getChar() {
        
        char retorno=0;
        try {
            retorno= (char)valor;
             
        } catch (Exception e) {
            println("[getChar]"+e.getMessage()); 
        }  
        return retorno;
    }

    /** 
     * @return obtiene el booleano
     */
    public Boolean  getBooleano() {
        
        boolean retorno=false;
        try {
            retorno= (boolean)valor;
             
        } catch (Exception e) {
            println("[getBooleano]"+e.getMessage()); 
        }  
        return retorno;
    }

    /**
     * @return doble
     */
    public Double  getNumero() { 
        double retorno=0.0;
        try {
            retorno= (double)valor;
        } catch (Exception e) {
            println("[getNumero]"+e.getMessage()); 
        }  
        return retorno; 
    }
  
    
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| Parseando
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa cuando se envian los valores, y luego estos son parseados
     */

    /**
     * Parseando el valor a partir de una cadena
     * @param arib es donde se encuentra el tipo que se va parsear 
     */
    public void parseToNumero(itemAtributo arib){ 
        try {
            setValor(Double.parseDouble(arib.valor));
        } catch (NumberFormatException e) {
            println(e.getMessage());
            simbolo.tablaErrores.insertErrorSemantic(arib, "No se puede parsear "+arib.valor +" a tipo número.");
        } 
    }
    
    
    /**
     * Parseando el valor a partir de una cadena
     * @param arib es donde se encuentra el tipo que se va parsear 
     */
    public void parseToCadena(itemAtributo arib){ 
        try {
            setValor(String.valueOf(arib.valor));
        } catch (NumberFormatException e) {
            println(e.getMessage());
            simbolo.tablaErrores.insertErrorSemantic(arib, "No se puede parsear "+arib.valor +" a tipo cadena.");
        } 
    }
    
    /**
     * Parseando el valor a partir de una cadena
     * @param arib es donde se encuentra el tipo que se va parsear 
     */
    public void parseToChar(itemAtributo arib) {

        if (arib.valor.length() > 1) {
            char al[] = arib.valor.toCharArray();
            if (al.length > 1) {
                setValor(al[1]);
            } else {
                simbolo.tablaErrores.insertErrorSemantic(arib, "No se puede parsear " + arib.valor + " a tipo char.");
            }
        } else {
            simbolo.tablaErrores.insertErrorSemantic(arib, "No se puede parsear " + arib.valor + " a tipo char.");
        } 
    }
    
    
    /**
     * Parseando el valor a partir de una cadena
     * @param arib es donde se encuentra el tipo que se va parsear 
     */
    public void parseToBooleano(itemAtributo arib) {

        try {
            setValor(Boolean.parseBoolean(arib.valor));
        } catch (NumberFormatException e) {
            println(e.getMessage());
            simbolo.tablaErrores.insertErrorSemantic(arib, "No se puede parsear "+arib.valor +" a tipo booleano.");
        } 
    }

    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| Obtener Tipo de una cadena
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa cuando se cambiar el tipo que tenía inicialmente
     */
    /**
     * 
     * @param aConvertir String que se desea sea el tipo final 
     * @param atrib Sirve para indicar la linea del error
     * @return 
     */
    public Object getValorParseado(String aConvertir, itemAtributo atrib) {

        switch (aConvertir) {
            case "cadena":
                switch (tipo) {
                    case "cadena":
                        return valor;
                    case "numero":
                        return String.valueOf(getNumero());
                    case "char":
                        return String.valueOf(getChar());
                    case "booleano":
                        return String.valueOf(getBooleano());
                    default:
                        return null;
                }
            case "numero":
                switch (tipo) {
                    case "cadena":
                        atrib.valor = getCadena();
                        parseToNumero(atrib);

                        try {
                            return Double.parseDouble(getCadena());
                        } catch (NumberFormatException e) {
                            println("[getValorParseado]" + e.getMessage());
                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getCadena() + " a tipo número.");
                            return null;
                        }

                    case "numero":
                        return getNumero();

                    case "char":
                        double ret = getChar();
                        return ret;
                    case "booleano":
                        if (getBooleano()) {
                            double ret2 = 1;
                            return ret2;
                        } else {
                            double ret2 = 0;
                            return ret2;
                        }
                    default:
                        return null;
                }

            case "char":
                switch (tipo) {
                    case "cadena":
                        if (getCadena().length() < 1) {

                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getCadena() + " a tipo char, debido a que es longitud 0.");
                            return null;
                        } else {
                            char[] el = getCadena().toCharArray();
                            return el[0];
                        }

                    case "numero":
                        try {
                            char el = (char) getNumero().intValue();
                            return el;
                        } catch (Exception e) {
                            println("[getValorParseado]" + e.getMessage());
                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getNumero().toString() + " a tipo char");
                            return null;
                        }
                    case "char":
                        return getChar();

                    case "booleano":
                        if (getBooleano()) {
                            char ret3 = '1';
                            return ret3;
                        } else {
                            char ret3 = '0';
                            return ret3;
                        }

                    default:
                        return null;
                }

            case "booleano":
                switch (tipo) {
                    case "cadena":

                        if (getCadena().toLowerCase().replace(" ", "").contains("true")) {
                            return true;
                        } else if (getCadena().toLowerCase().replace(" ", "").contains("false")) {
                            return false;
                        } else {
                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getCadena() + " a tipo Boolean");
                            return null;
                        }

                    case "numero":
                        if (getNumero().intValue() == 0) {
                            return false;
                        } else if (getNumero().intValue() == 1) {
                            return true;
                        } else {

                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getNumero().toString() + " a tipo Boolean");
                            return null;
                        }
                    case "char":

                        if (getChar() == '0') {
                            return false;
                        } else if (getChar() == '1') {
                            return true;
                        } else if (getChar() == 0) {
                            return false;
                        } else if (getChar() == 1) {
                            return true;
                        } else {
                            simbolo.tablaErrores.insertErrorSemantic(atrib, "No se puede parsear " + getChar() + " a tipo Boolean");
                            return null;
                        }
                    case "booleano":

                        return getBooleano();
                    default:
                        return null;
                }
            default:
                return null;
        }

    }
    
    public Object getParseadoNumero(itemAtributo atrib){
        return getValorParseado("numero", atrib);
    }
    
    
    public Object getParseadoCadena(itemAtributo atrib){
        return getValorParseado("cadena", atrib);
    }
    
    
    public Object getParseadoChar(itemAtributo atrib){
        return getValorParseado("char", atrib);
    }
    
    
    public Object getParseadoBooleano(itemAtributo atrib){
        return getValorParseado("booleano", atrib);
    }
    
     
    
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| IS TYPE
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa cuando se cambiar el tipo que tenía inicialmente
     */
    
    /**
     * Validando Los tipos
     * @return Retorno booleano para verificar si es del tipo especificado
     */
    public boolean isTypeNulo(){
        return tipo.equals("nulo");
    }
    public boolean isTypeNumero(){
        return tipo.equals("numero");
    }
    public boolean isTypeCadena(){
        return tipo.equals("cadena");
    }
    public boolean isTypeBooleano(){
        return tipo.equals("booleano");
    }
    public boolean isTypeChar(){
        return tipo.equals("char");
    }
     
      
    /**
     * <br>|--------------------------------------------------------------------------
     * <br>| Imprimiendo
     * <br>|--------------------------------------------------------------------------
     * <br>| Se usa cuando se cambiar el tipo que tenía inicialmente
     */
    
    public void imprimir(){
        println("tipo: "+tipo);
        
        switch(tipo){
            case "cadena":
                System.out.println(getCadena());
                break;
            case "numero":
                System.out.println(getNumero());
                break;
            case "char":
                System.out.println(getChar());
                
                break; 
            case "booleano":
                System.out.println(getBooleano());
                break;
                
            case "nulo":
                System.out.println("nulo");
                break;
            default:
                System.out.println("No se detecto el tipo");
                break; 
        }
        System.out.println("---");
    }
   

    
    /**
     * Sirve para mostrar mensajes en la consola
     * @param mensaje 
     */
    public void println(String mensaje){
        System.out.println("[itemValor]"+mensaje);
    }

    
    
}
