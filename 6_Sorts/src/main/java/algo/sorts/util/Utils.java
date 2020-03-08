package algo.sorts.util;

public class Utils {
    public static <T> void printArray(T[] array) {
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

}
