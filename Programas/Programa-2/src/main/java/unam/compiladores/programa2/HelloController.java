package unam.compiladores.programa2;

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
    private Button BtArchivo;

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
                if (AFD_00(texto) != 4){
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

    int AFD_00 (String texto){
        int Estado = 1;
        for (Character c: texto.toCharArray()){
            switch (Estado){
                case 1:
                    if (c == '0'){
                        Estado = 3;
                    } else if (c == '1') {
                        Estado = 2;
                    } else {
                        break;
                    }
                case 2:
                    break;
                case 3:
                    if (c == '0'){
                        Estado = 4;
                    } else if (c == '1') {
                        Estado  = 2;
                    } else {
                        break;
                    }
                case 4:
                    if (c == '0'){
                        Estado = 4;
                    } else if (c == '1') {
                        Estado = 5;
                    } else {
                        Estado = 2;
                    }
                case 5:
                    if (c == '0'){
                        Estado = 6;
                    } else if (c == '1') {
                        Estado = 5;
                    } else {
                        break;
                    }
                case 6:
                    if (c == '0'){
                        Estado = 4;
                    } else if (c == '1') {
                        Estado = 5;
                    } else {
                        break;
                    }
            }
        }



        return Estado;
    }

}
