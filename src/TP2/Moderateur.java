package TP2;

public class Moderateur extends Utilisateur {
    protected String motCle = "java";

    public Moderateur() {
        super("modo");
        this.symbole = "~";
    }

    public void chercherMotCle(String message) {
        if (message.contains(this.motCle)) {
            super.parler("Attention, le mot \"" + this.motCle + "\" a été utilisé!");
        }
    }
}
