package unam.compiladores.programa1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button BnArchivo;

    @FXML
    private TextArea TxtA_Archivo;

    @FXML
    void LeerArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter ExtF = new FileChooser.ExtensionFilter("Archivos de texto", "*.txt");
        fileChooser.getExtensionFilters().add(ExtF);
        File archivo = fileChooser.showOpenDialog(null);
        try (FileReader fr = new FileReader(archivo)){
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            String texto;
            while ((texto=br.readLine()) != null) {
                if (ValidarCaracteres(texto) != 3){
                    sb.append(texto).append(": Invalido\n");
                }else {
                    sb.append(texto).append(": Valido\n");
                }
            }
            TxtA_Archivo.setText(sb.toString());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int ValidarCaracteres(String texto) {
        int Estado = 1;
        for (Character c : texto.toCharArray()) {
            switch (Estado) {
                case 1:
                    if (c.equals('a')) {
                        Estado = 2;
                    } else if (c.equals('b')) {
                        Estado = 1;
                    } else {
                        //no es ni a ni b
                    }
                    break;
                case 2:
                    if (c.equals('a')) {
                        Estado = 3;
                    } else if (c.equals('b')) {
                        Estado = 1;
                    } else {
                        //caracter no valido
                    }
                    break;
                case 3:
                    if (c.equals('a')) {
                        Estado = 3;
                    } else if (c.equals('b')) {
                        Estado = 3;
                    } else {
                        //caracter no valido
                    }
                    break;
            }
        }
        return Estado;
    }
}
