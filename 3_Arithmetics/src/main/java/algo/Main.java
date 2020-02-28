package algo;

import algo.arithmetic.FibonacciAlgorithm;
import algo.arithmetic.GcdAlgorithm;
import algo.arithmetic.PowAlgorithm;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testAlgorithms();
    }

    public static void testAlgorithms() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       int[] repeats = new int[]{100, 1000, 10000};
       testPowAlgorithms(repeats, new Object[]{1.989d, 100234});
       //testGcdAlgorithms(repeats, new Object[]{});
       //testFindPrimeAlgorithms(repeats, new Object[]{});
       testFibonacciAlgorithms(repeats, new Object[]{34});
    }

    private static void testPowAlgorithms(int[] repeats, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        double d = (double) args[0];
        int exp = (int) args[1];

        System.out.printf("Pow Algorithms \nArguments: base = %f, exp = %d\n", d, exp);
        System.out.printf("|Short Name|Duration|Repeats|\n");

        String[] methods = new String[]{"powSimple", "powAdvanced", "powBinary"};

        for (int repeat : repeats) {
            for (String method : methods) {
                Method m = PowAlgorithm.class.getMethod(method, double.class, int.class);
                testAlgorithm(m, repeat, args);
            }
        }


    }

    private static void testGcdAlgorithms(int[] repeats, Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int number1 = (int) args[0];
        int number2 = (int) args[1];

        System.out.printf("\n\nGcd Algorithms \nArguments: num1 = %d, num2 = %d\n", number1, number2);
        System.out.printf("|Short Name|Duration|Repeats|\n");

        String[] methods = new String[]{"gcdSimple", "gcdAdvanced", "gcdRecursive", "gcdBinary"};

        for (int repeat : repeats) {
            for (String method : methods) {
                Method m = GcdAlgorithm.class.getMethod(method, int.class, int.class);
                testAlgorithm(m, repeat, args);
            }
        }
    }
    private static void testFindPrimeAlgorithms(int[] repeats, Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (true) throw new NotImplementedException();

        int number1 = (int) args[0];
        int number2 = (int) args[1];

        System.out.printf("\n\nGcd Algorithms \nArguments: num1 = %d, num2 = %d\n", number1, number2);
        System.out.printf("|Short Name|Duration|Repeats|\n");

        String[] methods = new String[]{"gcdSimple", "gcdAdvanced", "gcdRecursive", "gcdBinary"};

        for (int repeat : repeats) {
            for (String method : methods) {
                Method m = PowAlgorithm.class.getMethod(method, double.class, int.class);
                testAlgorithm(m, repeat, args);
            }
        }
    }
    private static void testFibonacciAlgorithms(int[] repeats, Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int num = (int) args[0];

        System.out.printf("\n\nFibonacci Algorithms \nArguments: num1 = %d\n", num);
        System.out.printf("|Short Name|Duration|Repeats|\n");

        String[] methods = new String[]{
                "findFibonacciIterative",
                "findFibonacciRecursion",
                "findFibonacciUsingGoldenCircle",
                "findFibonacciUsingMatrixMultiplication"};

        for (int repeat : repeats) {
            for (String method : methods) {
                Method m = FibonacciAlgorithm.class.getMethod(method, int.class);
                testAlgorithm(m, repeat, args);
            }
        }
    }
    public static void testAlgorithm(Method method, int repeats, Object... args ) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < repeats; i++) {
            method.invoke(null, args);
        }
        long end = System.currentTimeMillis() - start;
        System.out.printf("|%s|%d|%d|\n", method.getName(), end, repeats);
    }
}
