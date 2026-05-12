package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    void Inscription(ActionEvent event) {
        String nom = zoneNom.getText();
        String prenom = zonePrenom.getText();
        String mail = zoneMail.getText();
        String mdp = zoneMDP.getText();
        String confirmation = confirMDP.getText();

        if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || mdp.isEmpty() || confirmation.isEmpty()) {
            erreur.setText("Il faut remplir tous les champs !");
            return;
        }

        if (!mdp.equals(confirmation)) {
            erreur.setText("Les mots de passe ne correspondent pas !");
            return;
        }

        Utilisateur utilisateurExistant = utilisateurRepository.findByMail(mail);

        if (utilisateurExistant != null) {
            erreur.setText("Un utilisateur existe déjà avec ce mail !");
            return;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String mdpHash = passwordEncoder.encode(mdp);
        Utilisateur nouvelUtilisateur = new Utilisateur(prenom, nom, mail, mdpHash, "utilisateur");
        utilisateurRepository.save(nouvelUtilisateur);
        erreur.setText("Inscription réussie !");
    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
}