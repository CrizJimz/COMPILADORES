import javax.swing.*;

public class VersionDos {
    private int indice = 0;
    private String cadena = "";
    private final int error = -1;
    private final int aceptado = 1;

    public static void main(String[] args) {
        VersionDos app = new VersionDos();
        app.cadena = JOptionPane.showInputDialog("Dame la cadena");

        if (app.cadena == null) return;

        int valor = app.estado_A();
        if (valor == app.aceptado) {
            JOptionPane.showMessageDialog(null, "Cadena Valida");
        } else {
            JOptionPane.showMessageDialog(null, "Cadena invalida");
        }
    }

    private char siguienteCaracter() {
        if (indice < cadena.length()) {
            char caracter = cadena.charAt(indice);
            indice++;
            return caracter;
        }
        return '\0';
    }

    private int estado_A() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_B();
            case '1': return estado_C();
            default: return error;
        }
    }

    private int estado_B() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_D();
            case '1': return estado_E();
            default: return error;
        }
    }

    private int estado_C() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_G();
            default: return error;
        }
    }

    private int estado_D() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_D();
            case '1': return estado_H();
            default: return error;
        }
    }

    private int estado_E() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_I();
            case '1': return estado_F();
            default: return error;
        }
    }

    private int estado_F() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_I();
            case '1': return estado_J();
            default: return error;
        }
    }

    private int estado_G() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_G();
            default: return error;
        }
    }

    private int estado_H() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_I();
            default: return error;
        }
    }

    private int estado_I() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_I();
            default: return error;
        }
    }

    private int estado_J() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_G();
            case '\0': return aceptado;
            default: return error;
        }
    }
}