package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> Normal = new AListNoResizing<>();
        BuggyAList<Integer> Buggy = new BuggyAList<>();
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);
        Normal.addLast(4);
        Normal.addLast(5);
        Normal.addLast(6);

        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);
        Buggy.addLast(4);
        Buggy.addLast(5);
        Buggy.addLast(6);

        assertEquals(Buggy.size(),Normal.size());

        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());//BUG?
        assertEquals(Buggy.removeLast(),Normal.removeLast());
        assertEquals(Buggy.removeLast(),Normal.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Buggy = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Buggy.addLast(randVal);
                assertEquals(Buggy.size(),L.size());
                assertEquals(Buggy.getLast(),L.getLast());
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
