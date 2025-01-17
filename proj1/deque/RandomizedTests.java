package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedTests {
    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> buggy = new LinkedListDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                System.out.println(i + " " + operationNumber +  " " + randVal);
                L.addLast(randVal);
                buggy.addLast(randVal);
                int randVal2 = StdRandom.uniform(0, L.size());
                assertEquals(buggy.size(), L.size());
                assertEquals(buggy.get(randVal2), L.get(randVal2));
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = buggy.size();
                System.out.println(i + operationNumber + sizeL + sizeB);
                assertEquals(buggy.isEmpty(), L.isEmpty());
                assertEquals(buggy.size(), L.size());
            } else if (L.size() > 0 && buggy.size() > 0 && operationNumber == 2) {
                //removeLast
                System.out.println(i + " " + operationNumber + " " + buggy.size() + L.size());
                assertEquals(buggy.size(), L.size());
                assertEquals(buggy.removeLast(), L.removeLast());
                assertEquals(buggy.removeFirst(), L.removeFirst());
                assertEquals(buggy.isEmpty(), L.isEmpty());
            } else if (operationNumber == 3) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                buggy.addFirst(randVal);
                int randVal2 = StdRandom.uniform(0, L.size());
                System.out.println(i + " " + operationNumber + " " + randVal + " " + randVal2 + " " + L.size() + " " + buggy.size());
                assertEquals(buggy.size(), L.size());
                assertEquals(buggy.get(randVal2), L.get(randVal2));
            }
        }
    }
}


