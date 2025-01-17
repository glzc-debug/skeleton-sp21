package deque;

import java.util.Iterator;

public class LinkedListDeque<pineapple> implements Deque<pineapple>, Iterable<pineapple>{
    private class Node {
        public pineapple item;
        public Node previous;
        public Node next;

        public Node(pineapple i, Node n, Node p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private int size;
    private Node guard;


    public LinkedListDeque() {//completed
        guard = new Node(null, null, null);
        size = 0;
    }

    public LinkedListDeque(pineapple x) {//completed
        guard = new Node(null, null, null);
        guard.next = new Node(x, null, guard);
        size++;
    }

    @Override
    public void addFirst(pineapple item) {//completed
        if (guard.next == null) {
            guard.next = new Node(item, null, guard);
            guard.next.next = guard.next;
            guard.next.previous = guard.next;
            size++;
            return;
        }

        Node tmp = new Node(item, guard.next, guard);
        guard.next = tmp;
        tmp.next.previous = tmp;
        size++;
        return;
    }

    @Override
    public void addLast(pineapple item) {//completed
        if (guard.next == null) {
            guard.next = new Node(item, null, guard);
            guard.next.next = guard.next;
            guard.next.previous = guard.next;
            size++;
            return;
        }

        Node tmp = new Node(item, guard.next, guard.next.previous);
        tmp.previous.next = tmp;
        guard.next.previous = tmp;
        size++;
        return;
    }

    @Override
    public boolean isEmpty() {//completed
        return guard.next==null;
    }

    @Override
    public int size() {//completed
        return size;
    }

    @Override
    public void printDeque() {//completed
        if(guard.next == null) {
            System.out.println("null");
            return;
        }

        Node pointer = guard;
        for(int i =0; i < size; i++) {
            pointer = pointer.next;
            System.out.print(pointer.item + " ");
        }
        return;
    }

    @Override
    public pineapple removeFirst() {//completed
        if(guard.next == null) {
            return null;
        }

        Node previousFirst = guard.next;
        Node last = previousFirst.previous;
        Node newFirst = previousFirst.next;
        pineapple missingPineapple = previousFirst.item;

        guard.next = newFirst;
        newFirst.previous = last;
        previousFirst.previous.next = newFirst;

        size--;

        if (size == 0) {
            guard.next = null;
        }

        return missingPineapple;
    }

    @Override
    public pineapple removeLast() {//completed
        if(guard.next == null) {
            return null;
        }

        Node first = guard.next;
        Node previousLast = first.previous;
        Node newLast = previousLast.previous;
        pineapple missingPineapple = previousLast.item;

        first.previous = newLast;
        newLast.next = first;

        size--;

        if (size == 0) {
            guard.next = null;
        }

        return missingPineapple;
    }

    @Override
    public pineapple get(int index) {//completed
        if (index > size || guard.next == null) {
            return null;
        }

        Node pointer = guard;
        for(int i = 0; i <= index; i++) {
            pointer = pointer.next;
        }

        return pointer.item;
    }

    public pineapple getRecursive(int distance) {//
        Node pointer = guard.next;
        Node targetNode = findNode(distance, pointer);
        return targetNode.item;
    }

    private Node findNode(int distance,Node pointer) {
        if (distance > size || guard.next == null) {
            return null;
        }

        if (distance == 0) {
            return pointer;
        }

        pointer = pointer.next;
        
        return findNode(distance - 1, pointer);
    }

    private class LinkedListDequeIterator implements Iterator<pineapple> {//completed

        private int wizPos;

        public LinkedListDequeIterator() {
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
        return new LinkedListDequeIterator();
    }

    @Override
    public boolean equals(Object o) {//completed
        LinkedListDeque<pineapple> tmp = (LinkedListDeque<pineapple>)o;
        if(size != tmp.size()) {
            return false;
        }

        Node pointer = guard.next;
        for (int i = 0; i < size; i++) {
            if (this.get(i) != tmp.get(i)) {
                return false;
            }
        }
        return  true;
    }
}
