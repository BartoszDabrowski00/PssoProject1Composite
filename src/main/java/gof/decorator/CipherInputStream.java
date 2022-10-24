package gof.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CipherInputStream extends FilterInputStream {

    private final int MAX_SIZE = 256;
    private final int BYTE_SIZE = 8;
    private final int[] sbox = new int[MAX_SIZE];
    private final int[] kbox = new int[MAX_SIZE];
    private int[] pseudoRandomNumbers;
    private final InputStream inputStream;


    protected CipherInputStream(InputStream in) {
        super(in);
        inputStream = in;
        for (int i = 0; i < MAX_SIZE; i++) {
            sbox[i] = i;
            kbox[i] = (2 * i) % MAX_SIZE;
        }
        SboxScrambler.scramble(sbox, kbox);
    }

    protected CipherInputStream(InputStream in, int[] kbox) {
        super(in);
        inputStream = in;
        for (int i = 0; i < MAX_SIZE; i++) {
            sbox[i] = i;
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            this.kbox[i] = kbox[i % MAX_SIZE];
        }
        SboxScrambler.scramble(sbox, kbox);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int totalBytes = 0;
        int numOfBytes;
        while (totalBytes != b.length) {
            if ((numOfBytes = inputStream.read(b, totalBytes, BYTE_SIZE)) == -1) {
                return -1;
            }
            pseudoRandomNumbers = PseudoRandomNumbersGenerator.generateRandomNumbers(numOfBytes, sbox);
            decrypt(b, totalBytes, numOfBytes);
            totalBytes += numOfBytes;
            if (numOfBytes % BYTE_SIZE != 0) {
                break;
            }
        }

        return totalBytes;
    }

    private void decrypt(byte[] message, int offset, int size) {
        for (int i = 0; i < size; i++) {
            message[offset + i] ^= pseudoRandomNumbers[i];
        }
    }
}
