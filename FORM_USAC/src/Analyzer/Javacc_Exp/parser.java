/* Generated By:JavaCC: Do not edit this line. parser.java */
package Analyzer.Javacc_Exp;
import java.io.InputStream;
import Analyzer.Tree.*;
import Analyzer.Tree.Nodes.*;
public class parser implements parserConstants {
    public tree arbol=new tree();

    public parser(){

    }

    public void inicializar(InputStream stream ){
        try{

                parser analizador =new parser(stream);

                analizador.Programa();


                this.println("Analisis  exitoso! :)");
            }
        catch(ParseException e){
            this.error(e, arbol);
            /* raiz.tablaSimbolos.tablaErrores.insertErrorSemantic("",0,0,e.getMessage());
            raiz.tablaSimbolos.tablaErrores.println("Error en el parser"); */

        }
    }

    public void error_skipto(int kind) {
        ParseException e = generateParseException();  // generate the exception object.
        System.out.println(e.toString());  // print the error message
        Token t;
        int cont=0;
        do {
            t = getNextToken();
        } while (t.kind != kind && t.kind != EOF);
    }

    public void error(ParseException e, tree arbol){

        arbol.tablaSimbolos.tablaErrores.println("Error en el parser, Recuperandose");
        int maxSize = 0;
        for (int i = 0; i < e.expectedTokenSequences.length; i++) {
            if (maxSize < e.expectedTokenSequences[i].length) {
                maxSize = e.expectedTokenSequences[i].length;
            }
            for (int j = 0; j < e.expectedTokenSequences[i].length; j++) {
                int indice=e.expectedTokenSequences[i][j];
                if(e.tokenImage[indice].contains("&")){
                    arbol.tablaSimbolos.tablaErrores.insertErrorSyntax("encuesta",-2,-2,"No se encontr\u00f3 fila de finalizacion");
                }else if(e.tokenImage[indice].contains("_opcion")){
                    arbol.tablaSimbolos.tablaErrores.insertErrorSyntax("encuesta",-2,-2,"No se encontr\u00f3 fila de inicio de grupo/ciclo");
                }else{
                    arbol.tablaSimbolos.tablaErrores.insertErrorSyntax("encuesta",-2,-2,e.getMessage());
                    arbol.tablaSimbolos.tablaErrores.println("Se esperaba:"+e.tokenImage[indice]);

                }


            }
        }
        //System.out.println(e);
    }


    public void println(Object mensaje){
        arbol.tablaSimbolos.tablaErrores.println(mensaje);
    }
    public void print(Object mensaje){
        arbol.tablaSimbolos.tablaErrores.print(mensaje);
    }

    public static void imprimirToken(String t){
        //tablaSimbolos.tablaErrores.println(t);
    }

    /*
    |--------------------------------------------------------------------------
    | GRAMATICA
    |-------------------------------------------------------------------------- 
    */

        /*
        +-------------------------+
        |   Programa
        */
  final public void Programa() throws ParseException {
    S();
    jj_consume_token(0);
  }

        /*
        +-------------------------+
        |   S
        */
  final public void S() throws ParseException {
    E();
  }

  final public void E() throws ParseException {
    POR();
  }

  final public void POR() throws ParseException {
    DIV();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tMultiplicacion:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(tMultiplicacion);
      DIV();
    }
  }

  final public void DIV() throws ParseException {
    MODULO();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tDivision:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(tDivision);
      MODULO();
    }
  }

  final public void MODULO() throws ParseException {
    SUM();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tModulo:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(tModulo);
      SUM();
    }
  }

  final public void SUM() throws ParseException {
    RES();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tSuma:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_4;
      }
      jj_consume_token(tSuma);
      RES();
    }
  }

  final public void RES() throws ParseException {
    MAYOR_IGUALQUE();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tResta:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_5;
      }
      jj_consume_token(tResta);
      MAYOR_IGUALQUE();
    }
  }

  final public void MAYOR_IGUALQUE() throws ParseException {
    MAYOR_QUE();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tMayorIgualQue:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_6;
      }
      jj_consume_token(tMayorIgualQue);
      MAYOR_QUE();
    }
  }

  final public void MAYOR_QUE() throws ParseException {
    MENOR_IGUALQUE();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tMayorQue:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_7;
      }
      jj_consume_token(tMayorQue);
      MENOR_IGUALQUE();
    }
  }

  final public void MENOR_IGUALQUE() throws ParseException {
    MENOR_QUE();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tMenorIgualQue:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_8;
      }
      jj_consume_token(tMenorIgualQue);
      MENOR_QUE();
    }
  }

  final public void MENOR_QUE() throws ParseException {
    DIFERENCIACION();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tMenorQue:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_9;
      }
      jj_consume_token(tMenorQue);
      DIFERENCIACION();
    }
  }

  final public void DIFERENCIACION() throws ParseException {
    IGUALACION();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tDiferente:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_10;
      }
      jj_consume_token(tDiferente);
      IGUALACION();
    }
  }

  final public void IGUALACION() throws ParseException {
    NOT();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tIgual:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_11;
      }
      jj_consume_token(tIgual);
      NOT();
    }
  }

  final public void NOT() throws ParseException {
    AND();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tNot:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_12;
      }
      jj_consume_token(tNot);
      AND();
    }
  }

  final public void AND() throws ParseException {
    OR();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tAnd:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_13;
      }
      jj_consume_token(tAnd);
      OR();
    }
  }

  final public void OR() throws ParseException {
    F();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tOr:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_14;
      }
      jj_consume_token(tOr);
      F();
    }
  }

  final public void F() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tNumero:
      jj_consume_token(tNumero);
      break;
    case tIdentificador:
      jj_consume_token(tIdentificador);
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case tAbreParent:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_15;
        }
        jj_consume_token(tAbreParent);
        jj_consume_token(tCierraParent);
      }
      break;
    case tNumeral:
      jj_consume_token(tNumeral);
      jj_consume_token(tAbreCorchete);
      jj_consume_token(tIdentificador);
      jj_consume_token(tCierraCorchete);
      break;
    case tAbreParent:
      jj_consume_token(tAbreParent);
      E();
      jj_consume_token(tCierraParent);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

        /*
        +-------------------------+
        |   epsilon
        */
  final public void epsilon() throws ParseException {
        this.imprimirToken("epsilon");
  }

  /** Generated Token Manager. */
  public parserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x80,0x100,0x10,0x20,0x1000,0x800,0x4000,0x2000,0x400,0x200,0x20000,0x8000,0x10000,0x800000,0x2800006,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new parserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new parserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public parser(parserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(parserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[34];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 16; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 34; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
