package TP1;

public class Complexe {
    float re;
    float im;

    public Complexe() {
        this.re = 0;
        this.im = 0;
    }

    public Complexe(float re, float im) {
        this.re = re;
        this.im = im;
    }

    public Complexe plus(Complexe c) {
        Complexe res = new Complexe();
        res.re = this.re + c.re;
        res.im = this.im + c.im;
        return res;
    }

    public String texte() {
        return this.re + " + " + this.im + "i";
    }

    @Override
    public String toString() {
        return this.texte();
    }
}
