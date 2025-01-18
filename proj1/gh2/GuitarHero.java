package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static GuitarString strings[]= new GuitarString[37];

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        /* create two guitar strings, for concert A and C */
//        GuitarString stringA = new GuitarString(CONCERT_A);
//        GuitarString stringC = new GuitarString(CONCERT_C);
        for (int i = 0; i < 37; i++) {
            strings[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24) / 12));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) > 36 || keyboard.indexOf(key) < 0) {
                    continue;
                }
                strings[keyboard.indexOf(key)].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < 37; i++) {
                sample += strings[i].sample();
            }
            //double sample = stringA.sample() + stringC.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
//            stringA.tic();
//            stringC.tic();
            for (int i = 0; i < 37; i++) {
                strings[i].tic();
            }
        }
    }
}
