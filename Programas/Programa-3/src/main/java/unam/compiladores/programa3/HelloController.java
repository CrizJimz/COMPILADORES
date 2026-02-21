package unam.compiladores.programa3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

public class HelloController {

    @FXML
    private Button BtArchivo;

    @FXML
    private TextArea TxtA_Archivo;

    @FXML
    void LeerArchivo(ActionEvent event) throws FileNotFoundException {
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

    int ValidarCaracteres(String Linea) throws IOException {
        int Estado = 1;
            for (char c : Linea.toCharArray()){

                switch (Estado){
                    case 1:
                        if (Character.isLetter(c)){
                            Estado = 3;
                        } else if (Character.isDigit(c)) {
                            Estado = 2;
                        } else {
                            throw new IllegalArgumentException("Argumento no valido:  " + c);
                        }

                    case 2:
                        break;

                    case 3:
                        if (Character.isLetter(c)) {
                            Estado = 3;
                        } else if (Character.isDigit(c)) {
                            Estado = 3;
                        } else {
                            throw new IllegalArgumentException("Argumento no valido:  " + c);
                        }
                }
            }
        return Estado;
    }
}
