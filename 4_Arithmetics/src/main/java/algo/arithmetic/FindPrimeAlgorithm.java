package algo.arithmetic;

import algo.containers.FactorArray;
import algo.containers.VectorArray;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FindPrimeAlgorithm {

    //O(n)
    //todo
    public static void EratosthenesSieveAdvanced(int bound) {
        if (true) throw new NotImplementedException();

        int[] base = new int[bound + 1];
        FactorArray<Integer> array = new FactorArray<>();

        for (int i = 2; i < base.length; i++) {
            if (base[i] == 0) {
                array.add(i);
                for (int j = 0; j < array.size(); j++) {

                }
            }
        }

    }

    public static void EratosthenesSieveSimple(int bound) {
        VectorArray<Integer> array = new VectorArray<>();
        boolean[] checked = new boolean[bound + 1];

        for (int i = 2; i * i < bound + 1; i++) {
            if (!checked[i]) {
                for(int j = i * i ; j < bound + 1; j += i) {
                    checked[j] = true;
                }
            }
        }

        for (int i = 2; i < bound; i++) {
            if (!checked[i])
                array.add(i);
        }
    }

    public static void simplePrimeCounter(int bound) {
        int counter = 0;
        for (int i = 2; i <= bound; i++)
            if (isPrimeSimple(i))
                counter++;
    }

    public static boolean isPrimeSimple3(int value){
        int counter = 0;
        if (value == 2) return true;
        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0)
                counter++;
        }
        return counter == 2;
    }

    public static boolean isPrimeSimple2(int value){
        int counter = 0;
        if (value == 2) return true;
        for (int i = 3; i <= value; i += 2) {
            if (value % i == 0)
                counter++;
        }
        return counter == 2;
    }

    public static boolean isPrimeSimple(int value){
        int counter = 0;
        for (int i = 1; i <= value; i++) {
            if (value % i == 0)
                counter++;
        }
        return counter == 2;
    }

    public static boolean isPrimeAdvanced(int value){

        if (value == 2) return true;
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

}
