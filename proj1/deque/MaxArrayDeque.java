package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private int size;
    private T[] items;
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (this.items == null) {
            return null;
        }
        comparator = c;
        T max = this.items[0];
        for (T i : this.items) {
            if (comparator.compare(max, i) < 0) {
                max = i;
            }
        }
        return max;
    }
}


