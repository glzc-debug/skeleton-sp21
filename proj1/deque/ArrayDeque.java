package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private int size;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    @Override
    public void addFirst(T item) { //completed
        if (items.length == size) {
            resize(size * 2);
        }
        for (int i = size; i > 0; i--) {
            items[i] = items[i - 1];
        }
        items[0] = item;

        size++;
    }

    @Override
    /**最后一个总是size-1*/
    public void addLast(T item) { //completed
        if (items.length == size) {
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }

    private void resize(int sizeTmp) {
        T[] tmp = (T[]) new Object[sizeTmp];
        for (int i = 0; i < size; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    @Override
    public int size() { //completed
        return size;
    }

    @Override
    public void printDeque() { //completed
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public T removeFirst() { //completed
        if (items[0] == null) {
            if (size < items.length / 4 && size > 4) {
                resize(size);
            }
            return null;
        } else {
            T missingT = items[0];
            items[0] = null;
            for (int i = 0; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            if (size < items.length / 4 && size > 4) {
                resize(size);
            }
            size--;
            return missingT;
        }
    }

    @Override
    public T removeLast() { //completed
        if (items[0] == null) {
            if (size < items.length / 4 && size > 4) {
                resize(size);
            }
            return null;
        } else {
            T missingT = items[size - 1];
            items[size - 1] = null;
            if (size < items.length / 4) {
                resize(size);
            }
            size--;
            return missingT;
        }
    }

    @Override
    public T get(int index) { //completed
        if (index >= size || index < 0) {
            return null;
        }
        return items[index];
    }

    private class ArrayDequeIterator implements Iterator<T> {

        private int wizPos;

        ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos++;
            return returnItem;
        }
    }

    public Iterator<T> iterator() { //completed
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object o) { //completed
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            ArrayDeque<T> tmp = (ArrayDeque<T>) o;
            if (this.size != tmp.size()) {
                return false;
            }

            for (int i = 0; i < size; i++) {
                if (items[i] != tmp.items[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
