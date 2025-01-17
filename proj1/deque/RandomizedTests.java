package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedTests {
    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> Buggy = new LinkedListDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Buggy.addLast(randVal);
                assertEquals(Buggy.size(),L.size());
                assertEquals(Buggy.get(i),L.get(i));
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = Buggy.size();
                assertEquals(Buggy.size(),L.size());
            } else if (L.size()>0&&Buggy.size()>0&&operationNumber == 2) {
                //removeLast
                assertEquals(Buggy.size(),L.size());
                assertEquals(Buggy.removeLast(),L.removeLast());
            }
        }
    }
}


