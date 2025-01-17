package deque;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */

public class TimeLinkedListDeque {
    private static void printTimingTable(LinkedListDeque<Integer> ns,
                                         LinkedListDeque<Double> times,
                                         LinkedListDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < ns.size(); i += 1) {
            int N = ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;

            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeLinkedListDequeConstruction();
    }

    public static void timeLinkedListDequeConstruction() {
        LinkedListDeque<Double> time = new LinkedListDeque<>();
        LinkedListDeque<Integer> num = new LinkedListDeque<>();
        for (int i = 1000; i <= 64000; i *= 2) {
            num.addLast(i);
            time.addLast(addTests(i));
        }
        printTimingTable(num, time, num);
    }

    public static Double addTests(int up) {
        LinkedListDeque<Integer> List = new LinkedListDeque<>();
        Stopwatch sw = new Stopwatch();
        Double time;
        for (int i = 0; i < up; i++) {
            List.addLast(i);
        }
        time = sw.elapsedTime();
        return time;
    }
}
