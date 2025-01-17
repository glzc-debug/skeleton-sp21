package deque;
import deque.ArrayDeque;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */

public class timeArrayDeque {
    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
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
        // TODO: YOUR CODE HERE
        //printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts)
        ArrayDeque<Double> time = new ArrayDeque<>();
        ArrayDeque<Integer> Num = new ArrayDeque<>();
        for(int i=1000;i<=64000;i*=2){
            Num.addLast(i);
            time.addLast(addTests(i));
        }
        printTimingTable(Num, time, Num);
    }

    public static Double addTests(int up) {
        ArrayDeque<Integer> List = new ArrayDeque<>();
        Stopwatch sw = new Stopwatch();
        Double time;
        for(int i=0;i<up;i++){
            List.addLast(i);
        }
        time=sw.elapsedTime();
        return time;
    }
}