package TP8;

public interface Passengers extends Info {
    public default void addPassengers(int n) {
        this.showMessage("Adding " + n + " passengers");
    }

    public default void removePassengers(int n) {
        this.showMessage("Removing " + n + " passengers");
    }
}
