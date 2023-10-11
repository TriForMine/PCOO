package TP2;

public class Bot extends Utilisateur {
    public Bot() {
        super("bot");
        this.symbole = "#";
    }

    public void annonce(Canal canal) {
        super.parler("Bienvenue sur le canal: " + canal.getNom() + ".");
    }
}
