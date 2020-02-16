package algo.arithmetic;

public class GcdAlgorithm {

    public static void main(String[] args) {
        int a = 12345500;
        int b = 22466500;
        System.out.println(gcdSimple(a, b));
        System.out.println(gcdAdvanced(a, b));
        System.out.println(gcdRecursive(a, b));
        System.out.println(gcdBinary(a, b));

    }

    public static int gcdSimple(int a, int b) {
        while ( a != b ) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int gcdAdvanced(int a, int b){
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a != 0 ?  a : b;
    }

    public static int gcdRecursive(int a , int b) {
        if (b == 0) return a;
        return gcdRecursive(b, a % b);
    }

    public static int gcdBinary(int a, int b) {
        if (a == b)
            return a;

        if (a == 0)
            return b;

        if (b == 0)
            return a;

        if ( a % 2 == 0) // ~a & 1 (if a is even)
            if (b % 2 == 1) // b & 1 (if b is odd)
                return gcdBinary(a >> 1, b);
            else
                return gcdBinary(a >> 1, b >> 1 ) << 1;
        else if ( b % 2 == 0)
            return gcdBinary(a, b >> 1);

        //reduce larger argument
        if (a > b)
            return gcdBinary((a - b ) >> 1, b);

        return gcdBinary((b - a) >> 1, a);
    }
}
