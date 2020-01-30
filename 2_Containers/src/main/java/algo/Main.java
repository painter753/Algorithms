package algo;

import algo.containers.*;

import java.util.Collection;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //testLinkedList(args);
        testContainerArray(args);
    }

    public static void testDoubleLinkedList(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        System.out.println(linkedList);

        linkedList.add("aa", 0);
        System.out.println(linkedList);

        linkedList.add("cc", 2);
        System.out.println(linkedList);

        linkedList.add("ff", linkedList.size() - 1 );
        System.out.println(linkedList);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(linkedList.size() - 2));
        System.out.println(linkedList.get(linkedList.size() - 1));

        System.out.println(linkedList);

        System.out.println("Removed: " + linkedList.remove(0));
        System.out.println(linkedList);

        System.out.println("Removed: " + linkedList.remove(2));
        System.out.println(linkedList);

        System.out.println("Removed: " + linkedList.remove(linkedList.size() - 1));
        System.out.println(linkedList);

    }

    public static void testLinkedList(String[] args) {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("a");
        array.add("b");
        array.add("c");

        System.out.println(array);
        array.add("e", 0);
        System.out.println(array);
        array.add("f", 3);
        System.out.println(array);
        array.add("ff", array.size());
        System.out.println(array);

        array.remove(0);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);


        array.remove(4);
        System.out.println(array);

        //todo!!
        array.add("dd", 0);
        System.out.println(array);
        //testContainerArray(args);

        array.add("aa", array.size());
        System.out.println(array);
    }

    public static void testArithmetic(String[] args) {
        int a = 1234567890;
        int b = 12345;

        double aa = 1.000001;
        double res = 1.0;
        int exp = 1000000;

        while (exp != 0) {
             res = res * aa;
             exp--;
        }
        System.out.println(res);

        while (a != 0 && b != 0) {
            if (a > b)  {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        /*
        while (a != b) {
            if (a > b)  {
                a = a - b;
            } else {
                b = b - a;
            }
        }*/

        System.out.println(b);
    }
    public static void testContainerArray(String[] args) {
        int counter = 100000          ;

        IArray<String> singleArray = new SingleArray<>();
        IArray<String> vectorArray = new VectorArray<>(100);
        IArray<String> factorArray = new FactorArray<>();
        IArray<String> matrixArray = new MatrixArray<>(100);
        IArray<String> arrayListWrapper = new ArrayListWrapper<>();
        IArray<String> linkedArray = new LinkedArray<>();
        IArray<String> doubleLinkedArray = new DoubleLinkedList<>();

        testArray(arrayListWrapper, counter);
        System.out.println("==========");
        testArray(linkedArray, counter);
        System.out.println("==========");
        testArray(doubleLinkedArray, counter);
    }
    public static void testStack(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Hi");
        stack.push("I Am");
        stack.push("Ivan");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static void testQueue(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Hi");
        queue.enqueue("I Am");
        queue.enqueue("Ivan");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    // test for get, add, remove elements
    public static void testArray(IArray<String> array, int elementsCount) {

        System.out.printf("Array %s. Size: %d \n" ,array.getClass().getSimpleName(), elementsCount );
        addFirstPositionValues(array, elementsCount, false);
        System.out.println("Size: " + array.size());
        removeFirstPositionValues(array, elementsCount);
        System.out.println("Size: " + array.size());

        addLastPositionValues(array, elementsCount, false);
        System.out.println("Size: " + array.size());
        removeLastPositionValues(array, elementsCount);
        System.out.println("Size: " + array.size());

        addRandomPositionValues(array, elementsCount, false);
        System.out.println("Size: " + array.size());
        removeRandomPositionValues(array, elementsCount);
        System.out.println("Size: " + array.size());
    }
    public static void printElements(IArray<String> array) {
        System.out.println(array.toString());
        System.out.println("\n");
    }
    public static void addValues(Collection<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.add(i + "");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Add " + array +
                " " + count + " " + duration + " ms");
    }
    public static void addValues(IArray<String> array, int count, boolean mute) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.add(i + "");
        }
        long duration = System.currentTimeMillis() - start;
        if (!mute) {
            System.out.println("Add " + array +
                    "\n" + count + " " + duration + " ms");
        }
    }

    public static void addFirstPositionValues(IArray<String> array, int count, boolean mute) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "", 0);
        }

        long duration = System.currentTimeMillis() - start;
        if (!mute)
            System.out.println("Add First element:. " + duration + " ms");
    }
    public static void addLastPositionValues(IArray<String> array, int count, boolean mute) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "", array.size() );
        }

        long duration = System.currentTimeMillis() - start;
        if (!mute)
            System.out.println("Add Last element:. " + duration + " ms");
    }
    public static void addRandomPositionValues(IArray<String> array, int count, boolean mute) {
        long start = System.currentTimeMillis();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int position = random.nextInt(array.size() + 1);
            array.add(i + "", random.nextInt(array.size() + 1) );
        }

        long duration = System.currentTimeMillis() - start;
        if (!mute)
            System.out.println("Add Random element:. " + duration + " ms");
    }

    public static void removeFirstPositionValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();

        for (int i = count; i > 0; i--) {
            array.remove(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove First element:. " + duration + " ms");
    }
    public static void removeLastPositionValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();

        for (int i = count; i > 0; i--) {
            array.remove(array.size() - 1);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove Last element:. " + duration + " ms");
    }
    public static void removeRandomPositionValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        Random r = new Random();
        for (int i = count; i > 0; i--) {
            array.remove(r.nextInt(array.size()));
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove Random element:. " + duration + " ms");
    }

    public static void getFirstPositionValue(IArray<String> array, int count, boolean mute) {
        long start = System.currentTimeMillis();
        for (int i = count; i > 0; i--) {
            array.get(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove Random element:. " + duration + " ms");
    }
    public static void getLastPositionValue(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = count; i > 0; i--) {
            array.get(array.size() - 1);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove Random element:. " + duration + " ms");
    }
    public static void getRandomPositionValue(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        Random r = new Random();
        for (int i = count; i > 0; i--) {
            array.get(r.nextInt(array.size()));
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove Random element:. " + duration + " ms");
    }

    public static void removeValue(IArray<String> array, int index) {
        long start = System.currentTimeMillis();
        String item = array.remove(index);
        long duration = System.currentTimeMillis() - start;
        System.out.println("Remove element: " + item + " from: " + index + ". " + duration + " ms");
    }
    public static void addValueToIndex(IArray<String> array, String item, int index) {
        long start = System.currentTimeMillis();
        array.add(item, index);
        long duration = System.currentTimeMillis() - start;
        System.out.println("Add element: " + item + " from: " + index + ". " + duration + " ms");
    }
}
