public class LectorTxt {
    private static final int ERROR = -1;
    private static final int ACEPTAR = 100;

    public static String validarCadena(String linea) {
        if (linea == null || linea.trim().isEmpty()) return "Invalida";

        int estado = 1; // Estado inicial según la imagen
        int i = 0;
        String entrada;

        // Implementación con do-while para simular el "repeat-until"
        do {
            if (i >= linea.length()) break;

            char c = linea.charAt(i);
            entrada = clasificarEntrada(c);

            // Transiciones basadas en la tabla de la imagen
            switch (estado) {
                case 1:
                    if (entrada.equals("letra")) estado = 3;
                    else if (entrada.equals("digito")) estado = 2; // Lleva a estado de no aceptación
                    else if (entrada.equals("FC")) estado = ERROR;
                    else estado = ERROR;
                    break;
                case 2:
                    // Si entra un dígito, se queda en este estado (invalida la cadena)
                    if (entrada.equals("digito")) estado = 2;
                    else estado = ERROR;
                    break;
                case 3:
                    if (entrada.equals("letra")) estado = 3;
                    else if (entrada.equals("FC")) estado = ACEPTAR;
                    else if (entrada.equals("digito")) estado = 2;
                    else estado = ERROR;
                    break;
            }

            i++;
            // El ciclo continúa mientras no estemos en ERROR o ACEPTAR y queden caracteres
        } while (estado != ERROR && estado != ACEPTAR && i < linea.length());

        return (estado == ACEPTAR) ? "Valida" : "Invalida";
    }

    private static String clasificarEntrada(char c) {
        if (c == ';') return "FC"; // Fin de cadena solicitado
        // Alfabeto español: letras, espacios, ñ y acentos
        if (String.valueOf(c).matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]")) return "letra";
        if (Character.isDigit(c)) return "digito";
        return "ninguno";
    }
}