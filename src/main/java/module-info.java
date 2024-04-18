module com.example.paoim4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.zaxxer.hikari;
    requires org.hibernate.orm.core;

    opens com.example.paoim4 to javafx.fxml,org.hibernate.orm.core;
    exports com.example.paoim4;
}