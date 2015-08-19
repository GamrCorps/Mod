package src.enigma.mod.util;

import java.util.ArrayList;
import java.util.List;

public  class Queue<T> {
    private List<T> queue;

    public Queue() {
        queue = new ArrayList<T>();
    }

    public void add(T object) {
        queue.add(object);
    }

    public T getNext() {
        return getNext(true);
    }

    public T getNext(boolean remove) {
        if (remove) {
            T temp = queue.get(0);
            queue.remove(0);
            return temp;
        } else {
            return queue.get(0);
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return !(queue.size() > 0);
    }
}