package TP1;

public class TestComplexe {
    public static void main(String[] args) {
        Complexe c1 = new Complexe(1, 2);
        Complexe c2 = new Complexe(1, 2);

        Complexe c3 = c1.plus(c2);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c3: " + c3);

        if (c1 == c2) {
            System.out.println("Les deux complexes sont égaux");
        } else {
            System.out.println("Les deux complexe ne sont pas égaux");
        }
    }
}
