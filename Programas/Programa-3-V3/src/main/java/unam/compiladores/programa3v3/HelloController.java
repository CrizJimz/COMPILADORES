package unam.compiladores.programa3v3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;

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

    }

    

}
