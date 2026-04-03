package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InscriptionControler {
    @FXML
    private Button boutonInscri;
    @FXML
    private Button boutonRetour;
    @FXML
    private TextField confirMDP;
    @FXML
    private TextField zoneMDP;
    @FXML
    private TextField zoneMail;
    @FXML
    private TextField zoneNom;
    @FXML
    private TextField zonePrenom;
    @FXML
    private Label erreur;

    @FXML
    void Inscription(ActionEvent event) {
        String nom = zoneNom.getText();
        String prenom = zonePrenom.getText();
        String mail = zoneMail.getText();
        String mdp = zoneMDP.getText();
        String confirmation = confirMDP.getText();
        System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);
        System.out.println("mail: " + mail);
        System.out.println("mdp: " + mdp);
        System.out.println("confirmation: " + confirmation);
        if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || mdp.isEmpty()) {
            erreur.setText("Il faut remplir tous les champs !");
        } else if (!mdp.equals(confirmation)) {
            erreur.setText("Le mot de passe ne correspond pas à la confirmation du mot de passe !");
        } else {
            erreur.setText("");
        }
    }
    @FXML
    void Retour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
}