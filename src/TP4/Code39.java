package TP4;

public class Code39 {
    /**
     * Simulation d'un dictionnaire en attendant de voir la classe HashMap. On cherche l'indice i où
     * apparaît le caractère que l'on cherche à coder dans la chaîne 'caracteres' et son codage est
     * alors codage[i].
     */
    private static final String[] codage = {
            "000110100", "100100001", "001100001", "101100000", "000110001", "100110000", "001110000",
            "000100101", "100100100", "001100100", "100001001", "001001001", "101001000", "000011001",
            "100011000", "001011000", "000001101", "100001100", "001001100", "000011100", "100000011",
            "001000011", "101000010", "000010011", "100010010", "001010010", "000000111", "100000110",
            "001000110", "000010110", "110000001", "011000001", "111000000", "010010001", "110010000",
            "011010000", "010000101", "110000100", "011000100", "010010100", "010101000", "010100010",
            "010001010", "000101010"};
    private static final String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    public static String getCode(char c) {
        int i = caracteres.indexOf(c);
        if (i == -1) {
            System.err.println("Le caractère '" + c + "' n'est pas codable en Code 39.");
            return null;
        }

        return codage[i];
    }

    public static String getCode(String s) {
        StringBuilder code = new StringBuilder();
        code.append(getCode('*'));
        for (char c : s.toCharArray()) {
            code.append(getCode(c));
        }
        code.append(getCode('*'));
        return code.toString();
    }
}
