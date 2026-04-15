public class AutomataCeros {
    public static String validarCadena(String cadena) {
        if (cadena == null || cadena.length() < 2) return "Invalida";

        int estado = 0;
        int i = 0;

        do {
            char c = cadena.charAt(i);

            switch (estado) {
                case 0:
                    if (c == '0') estado = 1;
                    else estado = -1;
                    break;

                case 1:
                    if (c == '0') estado = 2;
                    else estado = -1;
                    break;

                case 2:
                    if (c == '0') {
                        estado = 2;
                    }
                    else if (c == '1') {
                        estado = 3;
                    } else {
                        estado = -1;
                    }
                    break;

                case 3:
                    if (c == '0') estado = 4;
                    else if (c == '1') estado = 3;
                    else estado = -1;
                    break;

                case 4:
                    if (c == '0') estado = 2;
                    else if (c == '1') estado = 3;
                    else estado = -1;
                    break;
            }
            i++;
        } while (estado != -1 && i < cadena.length());
        return (estado == 2) ? "Válida" : "Inválida";
    }
}