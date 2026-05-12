package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import model.Utilisateur;
import session.SessionUtilisateur;

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
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
    @FXML
    void Connexion(ActionEvent event) {
        String mail = fieldEmail.getText();
        String mdp = fieldMDP.getText();
        Utilisateur utilisateur = utilisateurRepository.findByMail(mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (utilisateur != null && passwordEncoder.matches(mdp, utilisateur.getMdp())) {
            System.out.println("Connexion réussie pour : " + utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            textErreur.setText("Connexion réussie !");
            textErreur.setVisible(true);
        } else {
            System.out.println("Échec de la connexion.");
            textErreur.setText("Email ou mot de passe incorrect.");
            textErreur.setVisible(true);
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