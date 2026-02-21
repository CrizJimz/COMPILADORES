module unam.compiladores.programa2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens unam.compiladores.programa2 to javafx.fxml;
    exports unam.compiladores.programa2;
}