module unam.compiladores.programa1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens unam.compiladores.programa1 to javafx.fxml;
    exports unam.compiladores.programa1;
}