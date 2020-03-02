package algo.sorts.util;

import algo.containers.IArray;
import algo.containers.VectorArray;

// todo refactor using lambda
public class GapGenerator {


    public static void main(String[] args) {
        System.out.println(generateShellGaps(1000));
        System.out.println(generateHibbardGaps(1000));
        System.out.println(generatePapernovStasevichGaps(1000));
        System.out.println(generateKnuthPratthGaps(1000));

    }

    public static IArray<Integer> generateShellGaps(int elemCounter) {
        IArray<Integer> gaps = new VectorArray<>();
        int k = 1;
        int gap = 0;
        do {
            gap =  elemCounter / (int) Math.pow(2, k++);
            if (gap <= 0) break;
            gaps.add(gap);
        } while (true);

        return gaps;
    }

    public static IArray<Integer> generateHibbardGaps(int elemCounter) {
        IArray<Integer> gaps = new VectorArray<>();
        int k = 1;
        int gap = 0;
        do {
            gap = (int) Math.pow(2, k++) - 1;
            if (gap > elemCounter) break;
            gaps.add(gap, 0);
        } while ( true );

        return gaps;
    }

    public static IArray<Integer> generatePapernovStasevichGaps(int elemCounter) {
        IArray<Integer> gaps = new VectorArray<>();
        int k = 1;
        gaps.add(1);

        int gap = 0;
        do {
            gap = (int) Math.pow(2, k++) + 1;
            if (gap > elemCounter) break;
            gaps.add(gap, 0);
        } while ( true );

        return gaps;
    }

    public static IArray<Integer> generateKnuthPratthGaps(int elemCounter) {
        IArray<Integer> gaps = new VectorArray<>();
        int k = 1;
        int gap = 0;
        do {
            gap = ((int) Math.pow(3, k++) - 1) / 2;
            if (gap > elemCounter / 3) break;
            gaps.add(gap, 0);
        } while ( true );

        return gaps;
    }



}
