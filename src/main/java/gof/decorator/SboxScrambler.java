package gof.decorator;

public class SboxScrambler {
    private static final int MAX_SIZE = 256;

    public static void scramble(int[] sbox, int[] kbox) {
        int j = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            j = (j + sbox[i] + kbox[i]) % MAX_SIZE;
            int tmp = sbox[i];
            sbox[i] = sbox[j];
            sbox[j] = tmp;
        }
    }
}
