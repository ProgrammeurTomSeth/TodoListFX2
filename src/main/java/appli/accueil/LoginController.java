package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button BtConnexion;
    @FXML
    private Button BtInscri;
    @FXML
    private Button BtMdpOu;
    @FXML
    private TextField fieldEmail;
    @FXML
    private PasswordField fieldMDP;
    @FXML
    private Text textErreur;
    @FXML
    void Connexion(ActionEvent event) {
        String email = fieldEmail.getText();
        String mdp = fieldMDP.getText();
        System.out.println("Email: " + email);
        System.out.println("MDP: " + mdp);
        if (email.isEmpty() || mdp.isEmpty()) {
            textErreur.setText("Tous les champs sont obligatories !");
        } else if (email.equals("t.treillon@orange.fr") && mdp.equals("Azerty1234")) {
            textErreur.setText("Vous êtes connecté !");
        }else {
            textErreur.setText("Les informations fournis ne suffisent pas à vous authentifier");
        }
    }
    @FXML
    void Inscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription");
    }
    @FXML
    void MdpOublier(ActionEvent event) {

    }

}
