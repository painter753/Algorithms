package algo.sorts;

public interface Sorter<T extends Comparable<T>> {

        public void sort(T[] array);
        default void swap(int i, int j, T[] array) {
            T c = array[i];
            array[i] = array[j];
            array[j] = c;
        }

}
