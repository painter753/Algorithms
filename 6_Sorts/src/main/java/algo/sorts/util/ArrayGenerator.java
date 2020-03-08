package algo.sorts.util;

import java.util.*;
import static algo.sorts.util.Utils.*;

public class ArrayGenerator {

    private static Random random = new Random();

    public static void main(String[] args) {
        printArray(generateRandomSequence(10, 50 ));
        printArray(generatePartiallyRandomSequencePercentage(100, 50, 10));
        printArray(generatePartiallyRandomSequenceNumbers(20, 40, 2));
    }
    public static Integer[] generateRandomSequence(int count, int bound) {
        Integer[] intArray = new Integer[count];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add((int) (Math.random() * bound));
        }
        return array.toArray(intArray);
    }

    public static Integer[] generatePartiallyRandomSequencePercentage(int count, int bound, int percentage) {
        Integer[] intArray = new Integer[count];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add(i);
        }
        int randomizedCounter = count * percentage / 100;
        while (randomizedCounter-- > 0) {
            array.remove(random.nextInt(array.size()));
            array.add(random.nextInt(array.size()), random.nextInt(bound));
        }

        return array.toArray(intArray);
    }

    public static Integer[] generatePartiallyRandomSequenceNumbers(int count, int bound, int number) {
        Integer[] intArray = new Integer[count];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add(i);
        }
        int randomizedCounter = number;
        while (randomizedCounter-- > 0) {
            array.remove(random.nextInt(array.size()));
            array.add(random.nextInt(array.size()), random.nextInt(bound));
        }

        return array.toArray(intArray);
    }

    public static Integer[] cloneArray(Integer[] array) {
        Integer[] newArray = new Integer[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }


}
