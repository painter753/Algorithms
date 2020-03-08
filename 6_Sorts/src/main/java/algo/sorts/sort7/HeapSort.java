package algo.sorts.sort7;

import algo.sorts.Sorter;
import algo.sorts.util.ArrayGenerator;

import static algo.sorts.util.Utils.*;

public class HeapSort<T extends Comparable<T>> implements Sorter<T> {


    @Override
    public void sort(T[] array) {
        heapSort(array);
    }

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.generateRandomSequence(10, 50);
        printArray(array);

        new HeapSort<Integer>().sort(array);

        printArray(array);
    }

    void heapSort(T[] array) {
        for (int node =  array.length / 2 - 1 ; node >= 0; node--)
            down(array, array.length, node);

        for (int size = array.length - 1; size >= 0 ; size--) {
            swap(0, size, array);
            down(array, size, 0);

        }
    }

    void down(T[] array, int size, int root){
        int lindex = 2 * root + 1;
        int rindex = lindex + 1;

        int maxindex = root;

        if (lindex < size && array[lindex].compareTo(array[maxindex]) > 0) maxindex = lindex;
        if (rindex < size && array[rindex].compareTo(array[maxindex]) > 0) maxindex = rindex;

        if (maxindex != root) {

            swap(root, maxindex, array);
            down(array, size, maxindex);
        }

    }


}
