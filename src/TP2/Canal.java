package TP2;

import java.io.*;
import java.util.Scanner;

public class Canal implements Sauvegardable, Chargeable {
    private static final Scanner sc = new Scanner(System.in);
    protected Bot bot;
    protected Moderateur moderateur;
    protected Utilisateur[] utilisateurs = new Utilisateur[10];
    protected int n;
    protected String derniereCommande;
    protected String nom;

    public Canal(String nom) {
        this.nom = nom;
        this.bot = new Bot();
        this.moderateur = new Moderateur();
        this.n = 0;
    }

    public void arriver() {
        this.bot.annonce(this);
        this.charger();
    }

    public String getNom() {
        return nom;
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
        derniereCommande = message;
        this.sauver();
        return handleMessage(message);
    }

    private String handleMessage(String message) {
        String[] mots = message.split(" ");

        if (mots.length < 2) {
            return "exit";
        }

        String nomUtilisateur = mots[0];
        String msg = message.substring(message.indexOf(" ") + 1);

        if (nomUtilisateur.equals("switch")) {
            return message;
        }

        msg = msg.replaceAll("(?i)http(s?)://[^ ]+", "[...]");

        Utilisateur u = trouverUtilisateur(nomUtilisateur);
        if (u == null) {
            creerUtilisateur(nomUtilisateur, msg);
        } else {
            u.parler(msg);
        }

        this.moderateur.chercherMotCle(msg);

        return msg;
    }

    @Override
    public void sauver() {
        if (derniereCommande.startsWith("switch")) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("src/TP2/sauvegarde-" + getNom() + ".txt", true)
        )) {
            bw.write(derniereCommande + "\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @Override
    public void charger() {
        System.out.println("Chargement de la sauvegarde du canal " + getNom() + "...");
        try (Scanner fsc = new Scanner(new File("src/TP2/sauvegarde-" + getNom() + ".txt"))) {
            while (fsc.hasNextLine()) {
                String message = fsc.nextLine();
                handleMessage(message);
            }
        } catch (FileNotFoundException ignored) {
        }
    }
}
