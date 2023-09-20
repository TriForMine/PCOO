public class TestDuree {
    public static void main(String[] args) {
        Duree d1 = new Duree(100000);
        Duree d2 = new Duree(30000);
        Duree d3 = new Duree(-100000);

        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
        System.out.println("d3: " + d3);

        Duree d4 = d1.plus(d2);
        Duree d5 = d1.plus(d3);

        System.out.println("d1 + d2: " + d4);
        System.out.println("d1 + d3: " + d5);

        Duree d6 = d1.moins(d2);
        System.out.println("d1 - d2: " + d6);
    }
}
