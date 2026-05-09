package fes.aragon.codigo;

/**
 *
 * @author MASH
 */
public class Sym {
  public static final int PUNTOCOMA = 0;
  public static final int SALTOLINEA = 1;
  public static final int EOF = 2;
  public static final int OR = 3;
  public static final int AND = 4;
  public static final int NOT = 5;
  public static final int TRUE = 6;
  public static final int FALSE = 7;
  public static final int PAR_A = 8;
  public static final int PAR_C = 9;

  public static final String[] terminales = new String[] {
          "PUNTOCOMA",
          "SALTOLINEA",
          "EOF",
          "OR",
          "AND",
          "NOT",
          "TRUE",
          "FALSE",
          "PAR_A",
          "PAR_C"
  };
}