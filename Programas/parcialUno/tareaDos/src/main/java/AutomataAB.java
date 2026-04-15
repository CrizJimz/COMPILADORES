public class AutomataAB {
    public static String validarCadena(String cadena) {
        if (cadena == null || cadena.length() < 2) return "Invalida";

        int estado = 0;
        int i = 0;

        do {
            char c = cadena.charAt(i);

            switch (estado) {
                case 0:
                    if (c == 'a') {
                        estado = 1;
                    }
                    else if (c == 'b') {
                        estado = 0;
                    } else {
                        estado = -1;
                    }
                    break;
                case 1:
                    if (c == 'a') {
                        estado = 2;
                    }
                    else if (c == 'b') {
                        estado = 0;
                    } else {
                        estado = -1;
                    }
                    break;

                case 2:
                    if (c == 'a') estado = 2;
                    else if (c == 'b')estado = 2;
                    else estado = -1;
                    break;
            }
            i++;
        } while (estado != -1 && i < cadena.length());
        return (estado == 2) ? "Válida" : "Inválida";
    }
}