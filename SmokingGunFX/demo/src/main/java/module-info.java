module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens uk.co.gnosis.smokingun to javafx.fxml;
    exports uk.co.gnosis.smokingun;
}