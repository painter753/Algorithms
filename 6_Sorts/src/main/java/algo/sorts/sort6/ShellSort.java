package algo.sorts.sort6;

import algo.sorts.Sorter;

public class ShellSort<T extends Comparable<T>> implements Sorter<T> {

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        printArray(array);
        new ShellSort<Integer>().sort(array);
        printArray(array);

//        Integer[] clone = new Integer[array.length];
//        System.arraycopy(array, 0, clone, 0, array.length);
//
//
//        System.out.println("Simple Sort:");
//        printArray(array);
//        long start = System.currentTimeMillis();
//        new InsertionSort<Integer>().sortSimple(array);
//        System.out.println((System.currentTimeMillis() - start) + " ms");
//        printArray(array);
//
//        System.out.println("Advanced Sort:");
//        printArray(clone);
//        long start2 = System.currentTimeMillis();
//        new ShellSort<Integer>().sort(clone);
//        System.out.println((System.currentTimeMillis() - start2) + " ms");
//        printArray(clone);
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
