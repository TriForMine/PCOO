package TP9;


import java.util.ArrayList;
import java.util.List;

public class Tour<T> {
    private final List<T> list;
    private int index = -1;

    public Tour() {
        this.list = new ArrayList<>();
    }

    public Tour<T> add(T element) {
        list.add(element);
        return this;
    }

    public void reset() {
        index = -1;
    }

    public T next() {
        if (index == list.size() - 1) {
            throw new IndexOutOfBoundsException("No more elements");
        }
        return list.get(++index);
    }

    public boolean ended() {
        return index == list.size() - 1;
    }
}
