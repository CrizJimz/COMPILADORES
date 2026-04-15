import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lector Txt");

        Button btnCargar = new Button("Buscar Archivo .txt");
        TextArea txtAreaResultados = new TextArea();
        txtAreaResultados.setEditable(false);
        txtAreaResultados.setPromptText("Los resultados aparecerán aquí...");

        btnCargar.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedFile != null) {
                procesarArchivo(selectedFile, txtAreaResultados);
            }
        });

        VBox layout = new VBox(15, btnCargar, txtAreaResultados);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void procesarArchivo(File file, TextArea textArea) {
        try {
            List<String> lineas = Files.readAllLines(file.toPath());
            StringBuilder sb = new StringBuilder();

            for (String linea : lineas) {
                String resultado = LectorTxt.validarCadena(linea.trim());
                sb.append(linea).append(" -> ").append(resultado).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (Exception ex) {
            textArea.setText("Error al leer el archivo: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}