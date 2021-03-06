package algo.sorts.sort6;

import algo.containers.IArray;
import algo.sorts.Sorter;
import algo.util.ArrayGenerator;
import algo.util.GapGenerator;
import algo.util.Utils;

public class ShellSort<T extends Comparable<T>> implements Sorter<T> {

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

    public ShellSort() {
        type = GapGenerator.GapType.DEFAULT;
    }

    public ShellSort(GapGenerator.GapType type) {
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

    @Override
    public void sort(T[] array) {
        IArray<Integer> gaps = GapGenerator.getGapSequence(type, array.length);
        for (int i = 0; i < gaps.size(); i++) {
            int gap = gaps.get(i);
            for (int j = 0; j + gap < array.length; j++) {
                int k = j + gap;
                T elem = array[k];
                while (k - gap >= 0 && array[k - gap].compareTo(elem) > 0) {
                    array[k] = array[k - gap];
                    k -= gap;
                }
                array[k] = elem;
            }
        }
    }

    public void sortUsingGapsOld(T[] array) {
        IArray<Integer> gaps = GapGenerator.getGapSequence(type, array.length);
        for (int i = 0; i < gaps.size(); i++) {
            int gap = gaps.get(i);
            for (int j = gap; j < array.length; j += gap) {
                T elem = array[j];
                int k = j - gap;
                while (k >= 0 && array[k].compareTo(elem) > 0) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = elem;
            }
        }
    }


    public void sortOld(T[] array) {
        for (int i = array.length / 2; i > 0; i /= 2) {
            int gap = i;
            for (int j = gap; j < array.length; j += gap) {
                T elem = array[j];
                int k = j - gap;
                while (k >= 0 && array[k].compareTo(elem) > 0) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = elem;
            }
        }
    }

}
