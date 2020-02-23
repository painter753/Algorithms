package algo.containers;

public class MatrixArray<T> extends AbstractArray<T> {

    private int size;
    private int vector;

    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        this.array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }
        int index = size();
        array.get(index / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return array
                .get(index / vector)
                .get(index % vector);
    }

    @Override
    public void clear() {
        this.vector = vector;
        this.array = new SingleArray<>();
        size = 0;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);

        if (size() == vector * array.size()) {
            array.add(new VectorArray<>(vector));
        }

        // choose array for insert
        int insertionIndexArray = index / vector;

        // if last = insertion free
        if (insertionIndexArray == array.size() - 1) {
                array.get(insertionIndexArray).add(item, index % vector);
        } else {
        // if array number is not last, then need shifting values
            boolean inserted = false;

            T tmpItem = null;
            for (int i = insertionIndexArray; i < array.size(); i++) {

                IArray<T> tmpArray = array.get(i);
                if (tmpArray.size() < vector && inserted) {
                    tmpArray.add(tmpItem, 0);
                } else if (inserted) {
                    T last = tmpArray.remove(tmpArray.size() - 1 );
                    tmpArray.add(tmpItem, 0);
                    tmpItem = last;
                }
                if (!inserted) {
                    tmpArray.add(item);
                    inserted = true;
                }
            }

        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > array.size() * vector) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // choose array for remove
        int removingIndexArray = index / vector;
        T removedItem = null;
        T tmpItem = null;
        boolean initialize = true;
        if (removingIndexArray == array.size() - 1) {
            IArray<T> tmpArr = array.get(removingIndexArray);
            tmpItem = array.get(removingIndexArray).remove(index % vector);
            removedItem = tmpItem;
        } else {
            for (int i = array.size() - 1 ; i > removingIndexArray; i--) {
                if (!initialize ) {
                    IArray<T> tmpArr = array.get(i);
                    T first = tmpArr.remove(0);
                    tmpArr.add(tmpItem);
                    tmpItem = first;
                } else {
                    IArray<T> tmpArr = array.get(i);
                    tmpItem = tmpArr.remove(0);
                    initialize = false;
                }
            }
            removedItem = array.get(removingIndexArray).remove(index % vector);
            array.get(removingIndexArray).add(tmpItem);
        }
        if (array.get(array.size() - 1).size() == 0) array.remove(array.size() - 1);

        size--;

        return removedItem;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (array.size() == 0) return "no elements";
        for (int i = 0; i < array.size(); i++) {
            builder.append(array.get(i).toString()).append(" ");
        }
        return builder.toString();
    }
}
