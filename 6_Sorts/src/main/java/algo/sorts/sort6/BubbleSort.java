package algo.sorts.sort6;

import algo.sorts.Sorter;

import static algo.util.Utils.*;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100 );
        }

        Integer[] clone = new Integer[array.length];
        System.arraycopy(array, 0, clone, 0, array.length);

        Integer[] clone2 = new Integer[array.length];
        System.arraycopy(array, 0, clone2, 0, array.length);


        System.out.println("Simple Sort:");
        printArray(array);
        long start = System.currentTimeMillis();
        new BubbleSort<Integer>().sortSimple(array);
        System.out.println((System.currentTimeMillis() - start) + " ms");
        printArray(array);

        System.out.println("Advanced Sort");
        printArray(clone);
        long start2 = System.currentTimeMillis();
        new BubbleSort<Integer>().sortAdvanced(clone);
        System.out.println((System.currentTimeMillis() - start2) + " ms");
        printArray(clone);

        System.out.println("Advanced2 Sort");
        printArray(clone2);
        long start3 = System.currentTimeMillis();
        new BubbleSort<Integer>().sortAdvanced2(clone2);
        System.out.println((System.currentTimeMillis() - start3) + " ms");
        printArray(clone2);

    }

    @Override
    public void sort(T[] array) {
        sortSimple(array);
    }

    private void sortSimple(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    public void sortAdvanced(T[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1, array);
                    swapped = true;
                }
            }
        }
    }

    public void sortAdvanced2(T[] array) {
        boolean swapped = true;
        int counter = array.length - 1;
        while (swapped) {
            swapped = false;

            for (int j = 0; j < counter; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1, array);
                    swapped = true;
                }
            }
            counter--;
        }
    }
}
