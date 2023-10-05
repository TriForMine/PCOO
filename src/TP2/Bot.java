package TP2;

public class Bot extends Utilisateur {
    protected String messageAnnonce = "Bienvenue sur le canal!";

    public Bot() {
        super("bot");
        this.symbole = "#";
    }

    public void annonce() {
        super.parler(this.messageAnnonce);
    }
}
