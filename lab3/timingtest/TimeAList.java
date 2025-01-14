package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */

public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        AList<Double> time = new AList<>();
        AList<Integer> Num = new AList<>();
        for(int i=1000;i<=64000;i*=2){
            Num.addLast(i);
            time.addLast(addTests(i));
        }
        printTimingTable(Num, time, Num);
    }

    public static Double addTests(int up) {
        AList<Integer> List = new AList<>();
        Stopwatch sw = new Stopwatch();
        Double time;
        for(int i=0;i<up;i++){
            List.addLast(i);
        }
        time=sw.elapsedTime();
        return time;
    }

}

