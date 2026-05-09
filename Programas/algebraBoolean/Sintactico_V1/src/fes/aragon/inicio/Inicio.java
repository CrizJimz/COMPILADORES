package fes.aragon.inicio;

import fes.aragon.codigo.Lexico;
import fes.aragon.codigo.Sym;
import fes.aragon.codigo.Tokens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inicio {
    private boolean error = true;
    private Tokens tokens = null;
    private Lexico analizador = null;

    public static void main(String[] args) {
        Inicio ap = new Inicio();
        BufferedReader buf;
        try {
            buf = new BufferedReader(
                    new FileReader(System.getProperty("user.dir")
                            + "/archivo.txt"));
            ap.analizador = new Lexico(buf);
            ap.siguienteToken();
            ap.inicioAnalisis();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inicioAnalisis() {
        while (tokens.getLexema() != Sym.EOF) {
            // Saltamos líneas vacías
            if (tokens.getLexema() == Sym.SALTOLINEA) {
                siguienteToken();
                continue;
            }

            E(); // Llamada a la regla inicial de la gramática

            // Verificamos el fin de instrucción (Punto y Coma)
            if (tokens.getLexema() != Sym.PUNTOCOMA) {
                errorSintactico();
            }

            if (!this.error) {
                System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
                this.error = true;
            } else {
                System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
            }

            siguienteToken();
        }
    }

    // E ::= T or E | T
    private void E() {
        T();
        if (tokens.getLexema() == Sym.OR) {
            siguienteToken();
            E();
        }
    }

    // T ::= F and T | F
    private void T() {
        F();
        if (tokens.getLexema() == Sym.AND) {
            siguienteToken();
            T();
        }
    }

    // F ::= not F | true | false | ( E )
    private void F() {
        if (tokens.getLexema() == Sym.NOT) {
            siguienteToken();
            F();
        } else if (tokens.getLexema() == Sym.TRUE) {
            siguienteToken();
        } else if (tokens.getLexema() == Sym.FALSE) {
            siguienteToken();
        } else if (tokens.getLexema() == Sym.PAR_A) {
            siguienteToken();
            E();
            if (tokens.getLexema() == Sym.PAR_C) {
                siguienteToken();
            } else {
                this.error = false; // Falta paréntesis de cierre
            }
        } else {
            this.error = false; // Token no reconocido por la gramática F
        }
    }

    private void siguienteToken() {
        try {
            tokens = analizador.yylex();
            if (tokens == null) {
                tokens = new Tokens("EOF", Sym.EOF, 0, 0);
            } else {
                System.out.println("Token: " + Sym.terminales[tokens.getLexema()] +
                        " | Lexema: " + tokens.getToken() +
                        " | L: " + tokens.getLinea() +
                        " | C: " + tokens.getColumna());
            }
        } catch (IOException ex) {
            tokens = new Tokens("EOF", Sym.EOF, 0, 0);
        }
    }

    private void errorSintactico() {
        this.error = false;
        // Recuperación: consumir hasta el delimitador o fin de archivo
        while (tokens.getLexema() != Sym.PUNTOCOMA && tokens.getLexema() != Sym.EOF) {
            siguienteToken();
        }
    }
}