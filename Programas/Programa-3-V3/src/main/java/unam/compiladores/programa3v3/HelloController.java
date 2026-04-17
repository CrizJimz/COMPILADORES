package unam.compiladores.programa3v3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HelloController {

    private static final int [][] tablaTransicion=  {{2,1,0},{1,1,0},{2,2,1}};

    @FXML
    private Button BtArchivo;

    @FXML
    private TextArea TxtA_Archivo;

    @FXML
    void LeerArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter ExtF = new FileChooser.ExtensionFilter("Archivos de texto", "*.txt");
        fileChooser.getExtensionFilters().add(ExtF);
        File archivo = fileChooser.showOpenDialog(null);

        List<String> textos = Files.readAllLines(archivo.getPath());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader (new FileReader(archivo))){
            String texto;

            while ((texto = br.readLine()) != null) {
                if (ValidarPalabra(texto)){
                    sb.append(texto).append(": Valido\n");
                }else {
                    sb.append(texto).append(": Invalido\n");
                }
            }
            TxtA_Archivo.setText(sb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    boolean ValidarPalabra (String linea){
        int Estado = 0;
        int Entrada;

        do {
            for (Character c : linea.toCharArray()) {
                if (Character.isLetter(c)) {
                    Entrada = 0;
                } else if (Character.isDigit(c)) {
                    Entrada = 1;
                } else if (Character.isWhitespace(c)) {
                    Entrada = 2;
                    break;
                } else {
                    break;
                }
                Estado = tablaTransicion[Estado][Entrada];
                if (Estado == 0) {
                    break;
                }
            }

        } while (Estado != 0);

        return (Estado == 1);
    }



}
