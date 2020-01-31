package algo.arithmetic;

public class PowAlgorithm {

    public static void main(String[] args) {
        double d = 2.0000001;
        int exp = 10;
        System.out.println(powSimple(d, exp));
        System.out.println(powAdvanced(d, exp));
        System.out.println(powBinary(d, exp));

    }

    public static double powSimple(double d, int exp) {
        double result = 1;
        while (exp-- != 0) {
            result = result * d;
        }

        return result;
    }

    public static double powAdvanced(double d, int exp) {
        double res = d;
        int k;
        for ( k = 1; k < exp / 2 ; k *= 2)
            res *= res;
        for (;k < exp; k++)
            res *= d;


        return res;
    }

    //todo relearn
    public static double powBinary(double d, int exp) {
        double res = 1;

        while (exp > 1 ) {
            if (exp % 2 == 1)
                res *= d;
            d *= d;
            exp /= 2;
        }
        if ( exp > 0) res *= d;



        return res;
    }

}
