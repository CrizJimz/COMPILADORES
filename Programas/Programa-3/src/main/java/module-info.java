module unam.compiladores.programa3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens unam.compiladores.programa3 to javafx.fxml;
    exports unam.compiladores.programa3;
}