package TP6.Classes;

import TP6.Exceptions.InventoryException;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory<e> {
    private final HashMap<e, Integer> elements = new HashMap<>();

    public int get(e element) {
        return elements.get(element);
    }

    public List<e> getAll() {
        return elements.keySet().stream().filter(e -> elements.get(e) > 0).collect(Collectors.toList());
    }

    public void add(e element, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        if (!elements.containsKey(element)) {
            elements.put(element, n);
            return;
        }

        elements.put(element, elements.get(element) + n);
    }

    public void remove(e element, int n) throws InventoryException {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        if (!elements.containsKey(element)) {
            throw new InventoryException("Element not found");
        }

        if (elements.get(element) < n) {
            throw new InventoryException("Not enough elements");
        }

        elements.put(element, elements.get(element) - n);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
