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
        primaryStage.setTitle("Analizador Léxico (0*1|1*)01");

        TextField txtEntrada = new TextField();
        txtEntrada.setPromptText("Ingrese cadena ");

        Button btnValidar = new Button("Analizar");

        Label lblResultado = new Label("Resultado:");
        TextArea areaResultado = new TextArea();
        areaResultado.setEditable(false);
        areaResultado.setPrefHeight(80);

        btnValidar.setOnAction(e -> {
            String input = txtEntrada.getText().trim();
            String res = AutomataClase.validar(input);
            areaResultado.setText(res);

            if(res.equals("Valida")) areaResultado.setStyle("-fx-control-inner-background: #d4edda;");
            else areaResultado.setStyle("-fx-control-inner-background: #f8d7da;");
        });

        VBox root = new VBox(15, new Label("Cadena a evaluar:"), txtEntrada, btnValidar, lblResultado, areaResultado);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(root, 400, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}