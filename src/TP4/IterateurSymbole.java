package TP4;

public class IterateurSymbole {
    public final String chaine;
    public int index = 0;

    public IterateurSymbole(String chaine) {
        this.chaine = chaine;
    }

    public Symbole next() {
        char c = chaine.charAt(index);
        index++;

        return switch (c) {
            case '0' -> new Symbole(Nature.BARRE, Epaisseur.ETROIT);
            case '1' -> new Symbole(Nature.ESPACE, Epaisseur.LARGE);
            default -> null;
        };
    }

    public boolean hasNext() {
        return index < chaine.length();
    }
}
