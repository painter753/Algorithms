package algo.sorts.sort6;

import algo.containers.IArray;
import algo.util.ArrayGenerator;
import algo.util.GapGenerator;
/*
    For comparing performance for algorithms using T[] and int[]
 */
public class IntShellSort {

    private GapGenerator.GapType type;
    private Integer[] gaps;

    public static void main(String[] args) {
        Integer[] array = new Integer[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }

        printArray(array);
        Integer[] cloneArray = ArrayGenerator.cloneArray(array);
        new ShellSort<Integer>().sort(cloneArray);
        printArray(cloneArray);

        System.out.println();
        printArray(array);
        cloneArray = ArrayGenerator.cloneArray(array);
        new ShellSort<Integer>(GapGenerator.GapType.SHELL_GAP).sort(cloneArray);
        printArray(cloneArray);

        System.out.println();
        printArray(array);
        cloneArray = ArrayGenerator.cloneArray(array);
        new ShellSort<Integer>(GapGenerator.GapType.KP_GAP).sort(cloneArray);
        printArray(cloneArray);



    }

    public IntShellSort() {
        type = GapGenerator.GapType.DEFAULT;
    }

    public IntShellSort(GapGenerator.GapType type) {
        this.type = type;
    }

    public static<T> void printArray(T[] array) {
        StringBuilder builder = new StringBuilder();
        if (array.length == 0) {
            System.out.println("no elems");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i].toString()).append(" ");
        }
        System.out.println(builder.toString());
    }

    public void sort(int[] array) {
        IArray<Integer> gaps = GapGenerator.getGapSequence(type, array.length);
        for (int i = 0; i < gaps.size(); i++) {
            int gap = gaps.get(i);
            for (int j = 0; j + gap < array.length; j++) {
                int k = j + gap;
                int elem = array[k];
                while (k - gap >= 0 && array[k - gap] > elem) {
                    array[k] = array[k - gap];
                    k -= gap;
                }
                array[k] = elem;
            }
        }
    }

    public void sortUsingGapsOld(int[] array) {
        IArray<Integer> gaps = GapGenerator.getGapSequence(type, array.length);
        for (int i = 0; i < gaps.size(); i++) {
            int gap = gaps.get(i);
            for (int j = gap; j < array.length; j += gap) {
                int elem = array[j];
                int k = j - gap;
                while (k >= 0 && array[k] > elem) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = elem;
            }
        }
    }


    public void sortOld(int[] array) {
        for (int i = array.length / 2; i > 0; i /= 2) {
            int gap = i;
            for (int j = gap; j < array.length; j += gap) {
                int elem = array[j];
                int k = j - gap;
                while (k >= 0 && array[k] > elem) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = elem;
            }
        }
    }
}
