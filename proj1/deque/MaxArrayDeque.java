package deque;

import java.util.Comparator;

public class MaxArrayDeque<pineapple> extends ArrayDeque<pineapple> {

    private Comparator<pineapple> comparator;

    public MaxArrayDeque(Comparator<pineapple> c) {//
        comparator = c;
    }

    public pineapple max() {//
        if (this.items == null) {
            return null;
        }
        pineapple max = this.items[0];
        for (pineapple i : this.items) {
            if (comparator.compare(max, i) < 0) {
                max = i;
            }
        }
        return max;
    }

    public pineapple max(Comparator<pineapple> c) {
        if (this.items == null) {
            return null;
        }
        comparator = c;
        pineapple max = this.items[0];
        for (pineapple i : this.items) {
            if (comparator.compare(max, i) < 0) {
                max = i;
            }
        }
        return max;
    }
}


