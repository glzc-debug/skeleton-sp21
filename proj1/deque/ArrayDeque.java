package deque;

import java.util.Iterator;

public class ArrayDeque<pineapple> implements Deque<pineapple>, Iterable<pineapple> {

    public int size;
    public pineapple[] items;

    public ArrayDeque() {
        items = null;
    }


    public ArrayDeque(pineapple x) {
        items = (pineapple[]) new Object[8];
        items[0] = x;
        size++;
    }

    @Override
    public void addFirst(pineapple item) {//completed
        if (items == null) {
            items = (pineapple[]) new Object[8];
            items[0] = item;
        } else {
            if (items.length == size) {
                resize(size);
            }
            for (int i = size; i > 0; i--) {
                items[i] = items[i - 1];
            }
            items[0] = item;
        }
        size++;
    }

    @Override
    /**最后一个总是size-1*/
    public void addLast(pineapple item) {//completed
        if (items == null) {
            items = (pineapple[]) new Object[8];
            items[0] = item;
        } else {
            if (items.length == size) {
                resize(size);
            }
            items[size] = item;
        }
        size++;
    }

    private void resize(int size) {
        pineapple[] tmp = (pineapple[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    @Override
    public boolean isEmpty() {//completed
        return items == null;
    }

    @Override
    public int size() {//completed
        return size;
    }

    @Override
    public void printDeque() {//completed
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public pineapple removeFirst() {//completed
        if (items == null) {
            return null;
        } else {
            pineapple missingPineapple = items[0];
            items[0] = null;
            if (size == 1) {
                items = null;
                size--;
                return missingPineapple;
            } else {
                for (int i = 0; i < size - 1; i++) {
                    items[i] = items[i + 1];
                }
                if (size < items.length/4 && size > 4) {
                    resize(size);
                }
                size--;
                return missingPineapple;
            }
        }
    }

    @Override
    public pineapple removeLast() {//completed
        if (items == null) {
            return null;
        } else {
            pineapple missingPineapple = items[size - 1];
            if (size == 1) {
                items = null;
                size--;
                return missingPineapple;
            } else {
                items[size - 1] = null;
                if (size < items.length/4) {
                    resize(size);
                }
                size--;
                return missingPineapple;
            }
        }
    }

    @Override
    public pineapple get(int index) {//completed
        if (index >= size || index < 0) {
            return null;
        }
        return items[index];
    }

    private class ArrayDequeIterator implements Iterator<pineapple> {

        private int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public pineapple next() {
            pineapple returnItem = get(wizPos);
            wizPos++;
            return returnItem;
        }
    }

    public Iterator<pineapple> iterator() {//completed
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object o) {//completed
        ArrayDeque<pineapple> tmp = (ArrayDeque<pineapple>) o;
        if (this.size != tmp.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (items[i] != tmp.items[i]) {
                return false;
            }
        }

        return true;
    }


}
