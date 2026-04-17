package model;

public class Utilisateur {
    int id_utilisateur;
    String prenom;
    String nom;
    String email;
    String mdp;
    String role;

    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Utilisateur(int id_utilisateur, String prenom, String nom, String email, String mdp, String role) {
        this.id_utilisateur = id_utilisateur;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }
    public Utilisateur(String prenom, String nom, String email, String mdp, String role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }
    public Utilisateur(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    public String toString() {
        return prenom + " " + nom + " : " + email + " ; " + mdp;
    }
}