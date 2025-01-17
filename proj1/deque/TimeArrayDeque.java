package deque;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */

public class TimeArrayDeque {
    private static void printTimingTable(ArrayDeque<Integer> ns,
                                         ArrayDeque<Double> times,
                                         ArrayDeque<Integer> opCounts) {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        ArrayDeque<Double> time = new ArrayDeque<>();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        for (int i = 1000; i <= 64000; i *= 2) {
            num.addLast(i);
            time.addLast(addTests(i));
        }
        printTimingTable(num, time, num);
    }

    public static Double addTests(int up) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        Stopwatch sw = new Stopwatch();
        Double time;
        for (int i = 0; i < up; i++) {
            list.addLast(i);
        }
        time = sw.elapsedTime();
        return time;
    }
}