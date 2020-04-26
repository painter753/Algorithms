package algo.sorts.sort8;

import algo.sorts.Sorter;
import algo.util.ArrayGenerator;
import algo.util.Utils;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.generateRandomSequence(10, 50);
        Utils.printArray(array);
        new QuickSort<Integer>().sort(array);
        Utils.printArray(array);


    }

    public int partition(T[] array, int left, int right) {
        int i = left - 1;
        T pivot = array[right];
        for (int j = left; j <= right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j, array);
            }
        }
        return i;
    }

    @Override
    public void sort(T[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public void quicksort(T[] array, int left, int right) {
        if (left >= right) return;

        int middle = partition(array, left, right);
        quicksort(array, left, middle - 1);
        quicksort(array, middle + 1, right);

    }
}
