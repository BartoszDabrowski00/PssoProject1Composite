package gof.decorator;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class CipherOutputStream extends FilterOutputStream {

    private final int MAX_SIZE = 256;
    private final int[] sbox = new int[MAX_SIZE];
    private final int[] kbox = new int[MAX_SIZE];
    private int[] pseudoRandomNumbers;
    private final FileOutputStream outputStream;
    private final int BYTE_SIZE = 8;

    public CipherOutputStream(FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        outputStream = fileOutputStream;
        for (int i = 0; i < MAX_SIZE; i++) {
            sbox[i] = i;
            kbox[i] = (2 * i) % MAX_SIZE;
        }
        SboxScrambler.scramble(sbox, kbox);
    }

    public CipherOutputStream(FileOutputStream fileOutputStream, int[] kbox) {
        super(fileOutputStream);
        outputStream = fileOutputStream;
        for (int i = 0; i < MAX_SIZE; i++) {
            sbox[i] = i;
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            this.kbox[i] = kbox[i % MAX_SIZE];
        }
        SboxScrambler.scramble(sbox, kbox);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        int parts = len / BYTE_SIZE;
        for (int i = 0; i < parts; i++) {
            pseudoRandomNumbers = PseudoRandomNumbersGenerator.generateRandomNumbers(BYTE_SIZE, sbox);
            encrypt(b, i * BYTE_SIZE, BYTE_SIZE);
            outputStream.write(b, off + i * BYTE_SIZE, BYTE_SIZE);
        }
        if (len % BYTE_SIZE != 0) {
            pseudoRandomNumbers = PseudoRandomNumbersGenerator.generateRandomNumbers(len % BYTE_SIZE, sbox);
            encrypt(b, len - len % BYTE_SIZE, len % BYTE_SIZE);
            outputStream.write(b, off + parts * BYTE_SIZE, len % BYTE_SIZE);
        }
    }

    private void encrypt(byte[] message, int offset, int size) {
        for (int i = 0; i < size; i++) {
            message[offset + i] ^= pseudoRandomNumbers[i];
        }
    }
}
