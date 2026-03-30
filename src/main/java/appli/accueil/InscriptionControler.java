package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class InscriptionControler {
    @FXML
    private Button retour;
    @FXML
    void retour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
}