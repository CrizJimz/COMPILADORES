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
                    new FileReader(System.getProperty("user.dir") + "/archivo.txt"));
            ap.analizador = new Lexico(buf);

            // Según la imagen 1: Función secuencia() inicia con un get_token();
            ap.siguienteToken();
            ap.secuencia();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementación de la Imagen 1: Función secuencia()
     */
    private void secuencia() {
        do {
            expresion(); // Llamada a E()

            // Bucle interno: while (token != PUNTOYCOMA) { Error; get_token(); }
            while (tokens.getLexema() != Sym.PUNTOCOMA && tokens.getLexema() != Sym.EOF) {
                System.out.println("Error en expresión en línea: " + (tokens.getLinea() + 1));
                this.error = false;
                siguienteToken(); // get_token() del pseudocódigo
            }

            if (this.error) {
                System.out.println("Valida línea: " + (tokens.getLinea() + 1));
            } else {
                System.out.println("Invalida línea: " + (tokens.getLinea() + 1));
                this.error = true; // Reset para la siguiente línea
            }

            // get_token() después del while para consumir el PUNTOYCOMA
            if (tokens.getLexema() == Sym.PUNTOCOMA) {
                siguienteToken();
            }

        } while (tokens.getLexema() != Sym.EOF);
    }

    // E ::= T { or T }
    private void expresion() {
        termino();
        while (tokens.getLexema() == Sym.OR) {
            siguienteToken();
            termino();
        }
    }

    // T ::= F { and F }
    private void termino() {
        factor();
        while (tokens.getLexema() == Sym.AND) {
            siguienteToken();
            factor();
        }
    }

    /**
     * Implementación de la Imagen 2: Función factor()
     */
    private void factor() {
        int lex = tokens.getLexema();

        // switch (token) del pseudocódigo
        if (lex == Sym.TRUE || lex == Sym.FALSE) { // Representan NUM o ID en tu lógica
            siguienteToken();
        }
        else if (lex == Sym.NOT) {
            siguienteToken();
            factor(); // Llamada recursiva a factor() según diagrama
        }
        else if (lex == Sym.PAR_A) { // AB_PARID en tu pseudocódigo
            siguienteToken();
            expresion();

            if (tokens.getLexema() != Sym.PAR_C) { // CE_PAR en tu pseudocódigo
                System.out.println("Error: Paréntesis de cierre faltante");
                this.error = false;
            } else {
                siguienteToken();
            }
        }
        else {
            // default: Error: Expresión no válida
            System.out.println("Error: Expresión no válida en columna " + tokens.getColumna());
            this.error = false;
        }
    }

    private void siguienteToken() {
        try {
            tokens = analizador.yylex();
            if (tokens == null) {
                tokens = new Tokens("EOF", Sym.EOF, 0, 0);
            } else {
                System.out.println("Token detectado: " + Sym.terminales[tokens.getLexema()]);
            }
        } catch (IOException ex) {
            tokens = new Tokens("EOF", Sym.EOF, 0, 0);
        }
    }
}