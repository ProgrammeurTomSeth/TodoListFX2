module appli.accueil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;


    opens appli.accueil to javafx.fxml;
    exports appli.accueil;
    exports appli;
    opens appli to javafx.fxml;
}