package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    @FXML
    void Connexion(ActionEvent event) throws IOException {
        String email = fieldEmail.getText();
        String mdp = fieldMDP.getText();
        System.out.println("Email: " + email);
        System.out.println("MDP: " + mdp);
        if (email.isEmpty() || mdp.isEmpty()) {
            textErreur.setText("Tous les champs sont obligatories !");
        } else {
            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
            Utilisateur u = utilisateurRepository.getUtilisateursParEmail(email);
            if (u.getMdp().equals(mdp)) {
                labelErreur.setText("Tu est connecté");
                StartApplication.changeScene("admin/Dashboard");
            }else {
                labelErreur.setText("Les infos ne correspondent pas");
            }
        }
    }
    @FXML
    void Inscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription");
    }
    @FXML
    void MdpOublier(ActionEvent event) {

    }

    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

}
