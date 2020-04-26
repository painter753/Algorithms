package algo.sorts.sort8;

import algo.sorts.Sorter;
import algo.util.ArrayGenerator;
import algo.util.Utils;

public class MergeSort<T extends Comparable<T>> implements Sorter<T> {

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.generateRandomSequence(10, 50);
        Utils.printArray(array);
        new MergeSort<Integer>().sort(array);
        Utils.printArray(array);
    }

    public void merge(T[] array, int left, int middle, int right) {
        int indexA = left;
        int indexB = middle + 1;
        int indexR = 0;

        //dangerous!
        T[] result = (T[]) new Integer[right - left + 1];

        while (indexA <= middle && indexB <= right)
            if (array[indexA].compareTo(array[indexB]) < 0)
                result[indexR++] = array[indexA++];
            else
                result[indexR++] = array[indexB++];
        while (indexA <= middle)
            result[indexR++] = array[indexA++];

        while (indexB <= right )
            result[indexR++] = array[indexB++];

        System.arraycopy(result, 0, array, left, result.length);
    }

    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int left, int right) {
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);

    }
}
