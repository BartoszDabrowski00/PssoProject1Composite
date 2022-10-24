package gof.decorator;

import java.io.*;

public class UnpackerInputStream extends FilterInputStream {

    private final InputStream inputStream;
    private final int ENCODING_SIZE = 6;
    private final int BYTE_SIZE = 8;

    protected UnpackerInputStream(InputStream in) {
        super(in);
        inputStream = in;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int bytesToRead = b.length / BYTE_SIZE * ENCODING_SIZE;
        var readBytes = inputStream.read(b, 0, bytesToRead);
        if (readBytes == -1) {
            return -1;
        }
        var decompressedString = decode(b, ENCODING_SIZE, bytesToRead);
        if (readBytes % BYTE_SIZE == 0){
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) decompressedString.charAt(i);
            }
            return b.length;
        } else {
            for (int i = 0; i < readBytes; i++) {
                b[i] = (byte) decompressedString.charAt(i);
            }
            return readBytes;
        }
    }

    private String decode(byte[] encoded, int bit, int size) {
        StringBuilder strTemp;
        StringBuilder strBinary = new StringBuilder();
        StringBuilder strText = new StringBuilder();
        int tempInt;
        int intTemp;
        for (int i = 0; i < size; i++) {
            if (encoded[i] < 0) {
                intTemp = (int) encoded[i] + 256;
            } else
                intTemp = (int) encoded[i];
            strTemp = new StringBuilder(Integer.toBinaryString(intTemp));
            while (strTemp.length() % 8 != 0) {
                strTemp.insert(0, "0");
            }
            strBinary.append(strTemp);
        }
        for (int i = 0; i < strBinary.length(); i = i + bit) {
            tempInt = Integer.valueOf(strBinary.substring(i, i + bit), 2);
            strText.append(CompressionValuesMapper.toChar(tempInt));
        }
        return strText.toString();
    }
}
