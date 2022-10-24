package gof.decorator;

public class PseudoRandomNumbersGenerator {
    private static final int MAX_SIZE = 256;

    public static int[] generateRandomNumbers(int size, int[] sbox) {
        int[] pseudoRandomNumbers = new int[size];
        int i = 0;
        int j = 0;
        for (int k = 0; k < size; k++) {
            i = (i + 1) % MAX_SIZE;
            j = (j + sbox[i]) % MAX_SIZE;
            int tmp = sbox[i];
            sbox[i] = sbox[j];
            sbox[j] = tmp;
            pseudoRandomNumbers[k] = sbox[(sbox[i] + sbox[j]) % MAX_SIZE];
        }
        return pseudoRandomNumbers;
    }
}
