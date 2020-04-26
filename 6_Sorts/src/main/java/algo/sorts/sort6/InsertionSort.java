package algo.sorts.sort6;

import algo.sorts.Sorter;
import algo.util.ArrayGenerator;

import static algo.util.Utils.*;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {
    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }

        long start = 0;
        long end = 0;

        //printArray(array);

        Integer[] arr = ArrayGenerator.cloneArray(array);
        start = System.currentTimeMillis();
        new InsertionSort<Integer>().sortAdvanced(arr);
        System.out.println(System.currentTimeMillis() - start);
        //printArray(arr);

        arr = ArrayGenerator.cloneArray(array);
        start = System.currentTimeMillis();
        new InsertionSort<Integer>().sort(arr);
        System.out.println(System.currentTimeMillis() - start);
        //printArray(arr);


    }

    @Override
    public void sort(T[] array) {
        sortSimple(array);
    }

    public void sortSimple(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(j, j - 1 ,array);
                }
            }
        }
    }

    public void sortAdvanced(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T elem = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(elem) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = elem;
        }
    }
}
