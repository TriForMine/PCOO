package TP2;

import java.util.Scanner;

public class Canal {
    private static final Scanner sc = new Scanner(System.in);
    protected Bot bot;
    protected Moderateur moderateur;
    protected Utilisateur[] utilisateurs = new Utilisateur[10];
    protected int n;

    public Canal() {
        this.bot = new Bot();
        this.moderateur = new Moderateur();
        this.n = 0;

        this.bot.annonce();
    }

    protected void creerUtilisateur(String nom, String message) {
        if (n < utilisateurs.length) {
            utilisateurs[n++] = new Utilisateur(nom);
            utilisateurs[n - 1].parler(message);
        } else {
            System.out.println("Trop d'utilisateurs!");
        }
    }

    protected Utilisateur trouverUtilisateur(String nom) {
        for (int i = 0; i < n; i++) {
            if (utilisateurs[i].nom.equals(nom)) {
                return utilisateurs[i];
            }
        }
        return null;
    }

    public String lireMessage() {
        String message = sc.nextLine();
        String[] mots = message.split(" ");

        if (mots.length < 2) {
            return "exit";
        }

        String nom = mots[0];
        String msg = message.substring(message.indexOf(" ") + 1);

        Utilisateur u = trouverUtilisateur(nom);
        if (u == null) {
            creerUtilisateur(nom, msg);
        } else {
            u.parler(msg);
        }

        this.moderateur.chercherMotCle(msg);

        return msg;
    }
}
