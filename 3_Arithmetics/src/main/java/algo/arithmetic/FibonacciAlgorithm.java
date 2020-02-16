package algo.arithmetic;

public class FibonacciAlgorithm {

    public static void main(String[] args) {
        System.out.println(findFibonacciRecursion(13));
        System.out.println(findFibonacciIterative(13));
        System.out.println(findFibonacciUsingGoldenCircle(13));
        System.out.println(findFibonacciUsingMatrixMultiplication(13));

    }

    public static int findFibonacciUsingMatrixMultiplication(int position) {
        if (position < 3)
            return 1;
        
        Matrix res = new SingleMatrix();
        Matrix m = new Matrix();
        int exp = position - 1;
        while ( exp > 1) {
            if ( exp % 2 == 1)
               res = res.multiply(m);
            m = m.multiply(m);
            exp /= 2;
        }
        if ( exp > 0) res = res.multiply(m);
        
        
        return res.getElement(0,0);
    }

    private static class SingleMatrix extends Matrix {
        public SingleMatrix() {
            array[0][0] = 1;
            array[1][0] = array[0][1] = 0;
            array[1][1] = 1;
        }
    }

    private static class Matrix {
        protected int[][] array = new int[2][2];

        public Matrix(){
            array[0][0] = 1;
            array[0][1] = 1;
            array[1][0] = 1;
            array[1][1] = 0;
        }

        public Matrix multiply(Matrix m) {
            Matrix result = new Matrix();

            result.array[0][0] = this.array[0][0] * m.array[0][0] + this.array[0][1] * m.array[1][0];
            result.array[0][1] = this.array[0][0] * m.array[0][1] + this.array[0][1] * m.array[1][1];
            result.array[1][0] = this.array[0][0] * m.array[1][0] + this.array[1][0] * m.array[1][1];
            result.array[1][1] = this.array[1][0] * m.array[0][1] + this.array[1][1] * m.array[1][1];

            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(array[0][0]).append(" , ").append(array[0][1]).append("\n");
            builder.append(array[1][0]).append(" , ").append(array[1][1]).append("\n");
            return builder.toString();
        }
        
        public int getElement(int i, int j) {
            return array[i][j];
        }
    }

    public static double findFibonacciUsingGoldenCircle(int position ) {
        return Math.round(Math.pow((1 + Math.sqrt(5) )/ 2, position) / Math.sqrt(5) + 1/2);
    }

    public static int findFibonacciIterative(int position) {
        int a = 1;
        int b = 1;

        int next = 0;
        for (int i = 3; i <= position; i++) {
            next = a + b;
            a = b;
            b = next;
        }

        return next;
    }

    public static int findFibonacciRecursion(int position) {
        if ( position < 3 )
            return 1;
        else
            return findFibonacciRecursion(position - 1 ) + findFibonacciRecursion(position - 2);
    }
}
