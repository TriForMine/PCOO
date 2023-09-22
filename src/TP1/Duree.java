package TP1;

public class Duree {
    protected int total;
    int jours;
    int heures;
    int minutes;
    int secondes;

    public Duree(int secs) {
        this.total = secs;

        secs = Math.abs(secs);

        this.jours = secs / 86400;
        secs %= 86400;
        this.heures = secs / 3600;
        secs %= 3600;
        this.minutes = secs / 60;
        this.secondes = secs % 60;

        if (this.total < 0) {
            this.jours = -this.jours;
            this.heures = -this.heures;
            this.minutes = -this.minutes;
            this.secondes = -this.secondes;
        }
    }

    public Duree plus(Duree d) {
        return new Duree(this.total + d.total);
    }

    public Duree plus(int secs) {
        return new Duree(this.total + secs);
    }

    public Duree moins(Duree d) {
        return this.plus(-d.total);
    }

    public Duree moins(int secs) {
        return this.plus(-secs);
    }

    public String texte() {
        String res = "";
        if (this.jours != 0) {
            res += this.jours + " jour";
            if (this.jours > 1 || this.jours < -1) {
                res += "s";
            }
            res += ", ";
        }
        if (this.heures != 0) {
            res += this.heures + " heure";
            if (this.heures > 1 || this.heures < -1) {
                res += "s";
            }
            res += ", ";
        }
        if (this.minutes != 0) {
            res += this.minutes + " minute";
            if (this.minutes > 1 || this.minutes < -1) {
                res += "s";
            }
            res += ", ";
        }

        res += this.secondes + " seconde";
        if (this.secondes > 1 || this.secondes < -1) {
            res += "s";
        }

        return res;
    }

    @Override
    public String toString() {
        return this.texte();
    }
}
