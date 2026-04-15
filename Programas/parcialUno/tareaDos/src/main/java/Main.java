import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analizador AFN: aa");

        Label lblInstruccion = new Label("Ingrese la cadena:");
        TextField txtEntrada = new TextField();

        Button btnValidar = new Button("Validar Cadena");

        TextArea txtResultado = new TextArea();
        txtResultado.setEditable(false);
        txtResultado.setPrefHeight(100);

        btnValidar.setOnAction(e -> {
            String cadena = txtEntrada.getText().trim();
            String resultado = AutomataAB.validarCadena(cadena);
            txtResultado.setText("La cadena [" + cadena + "] es: " + resultado);
        });

        VBox layout = new VBox(15, lblInstruccion, txtEntrada, btnValidar, txtResultado);
        layout.setPadding(new Insets(25));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}