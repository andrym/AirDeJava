module fr.matthieu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires transitive java.sql;
    opens fr.matthieu to javafx.fxml;
    exports fr.matthieu;
}