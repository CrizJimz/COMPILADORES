public class AutomataClase {

    public static String validar(String cadena) {
        if (cadena == null || cadena.isEmpty()) return "Invalida";

        int estado = 1;
        int i = 0;
        char c;
        int columna;

        do {
            c = cadena.charAt(i);
            columna = clasificar(c);

            if (columna == -1) {
                estado = -1;
            } else {
                estado = transicion(estado, columna);
            }

            i++;
        } while (estado != -1 && i < cadena.length());

        return (estado == 4) ? "Valida" : "Invalida";
    }

    private static int clasificar(char c) {
        if (c == '0') return 0;
        if (c == '1') return 1;
        return -1;
    }

    private static int transicion(int estado, int columna) {
        switch (estado) {
            case 1: // Estado inicial
                if (columna == 0) return 1; // Sigue en 0*
                if (columna == 1) return 2; // Pasa a la parte de 1 o 1*
                break;
            case 2:
                if (columna == 0) return 3; // Encontró el '0' de la secuencia final "01"
                if (columna == 1) return 2; // Sigue en 1*
                break;
            case 3:
                if (columna == 0) return 3; // Sigue esperando el '1' final, pero llegó otro '0'
                if (columna == 1) return 4; // ¡Aceptación! Encontró el "01"
                break;
            case 4:
                // Si la cadena sigue después de un "01" exitoso
                if (columna == 0) return 3; // Reinicia búsqueda de "01"
                if (columna == 1) return 2; // Regresa a bloque de unos
                break;
        }
        return -1;
    }
}