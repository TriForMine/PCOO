package TP8;

public interface Info {
    public default void showMessage(String message) {
        System.out.println(message);
    }
}
