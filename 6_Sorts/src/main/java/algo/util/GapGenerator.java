package algo.util;

import algo.containers.IArray;
import algo.containers.VectorArray;

public class GapGenerator {

    public static enum GapType {
        DEFAULT,
        SHELL_GAP,
        HIBBARD_GAP,
        PS_GAP,
        KP_GAP
    }

    public static IArray<Integer> getGapSequence(GapType type, int elems) {
        switch (type) {
            case SHELL_GAP: return generateShellGaps(elems);
            case HIBBARD_GAP: return generateHibbardGaps(elems);
            case PS_GAP: return generatePapernovStasevichGaps(elems);
            case KP_GAP: return generateKnuthPratthGaps(elems);
            case DEFAULT:
            default: return generateDefaultGaps(elems);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateShellGaps(1000));
        System.out.println(generateHibbardGaps(1000));
        System.out.println(generatePapernovStasevichGaps(1000));
        System.out.println(generateKnuthPratthGaps(1000));

    }

    private static IArray<Integer> generateDefaultGaps(int elemCounter) {
        IArray<Integer> gaps = new VectorArray<>();
        int gap = elemCounter;
        do {
            gap = gap / 2;
            if (gap <= 0) break;
            gaps.add(gap);
        } while (true);

        return gaps;
    }

    private static IArray<Integer> generateShellGaps(int elemCounter) {
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

    private static IArray<Integer> generateHibbardGaps(int elemCounter) {
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

    private static IArray<Integer> generatePapernovStasevichGaps(int elemCounter) {
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

    private static IArray<Integer> generateKnuthPratthGaps(int elemCounter) {
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
