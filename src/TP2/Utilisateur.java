package TP2;

public class Utilisateur {
    protected String nom;
    protected String symbole;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.symbole = "@";
    }

    public void parler(String message) {
        System.out.println(this.symbole + this.nom + ": " + message);
    }
}
