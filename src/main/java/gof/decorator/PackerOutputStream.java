package gof.decorator;

import java.io.*;


public class PackerOutputStream extends FilterOutputStream {

    private final OutputStream outputStream;
    private final int ENCODING_SIZE = 6;
    private final int BYTE_SIZE = 8;

    public PackerOutputStream(OutputStream out) {
        super(out);
        outputStream = out;
    }

    @Override
    public void write(byte[] message, int off, int len) throws IOException {
        var encodedMessage = encode(new String(message), ENCODING_SIZE, len);
        if (len % BYTE_SIZE == 0 ) {
            outputStream.write(encodedMessage, off, encodedMessage.length);
        } else {
            outputStream.write(encodedMessage, off, len);
        }
    }

    private byte[] encode(String txt, int bit, int readBytes) {
        float tmpRet1 = 0, tmpRet2 = 0;
        if (bit == 6) {
            tmpRet1 = 3.0f;
            tmpRet2 = 4.0f;
        } else if (bit == 5) {
            tmpRet1 = 5.0f;
            tmpRet2 = 8.0f;
        }
        byte[] encoded = new byte[(int) (tmpRet1 * Math.ceil(readBytes / tmpRet2))];
        char[] str = new char[readBytes];
        txt.getChars(0, readBytes, str, 0);
        StringBuilder temp;
        StringBuilder strBinary = new StringBuilder();
        for (int i = 0; i < readBytes; i++) {
            temp = new StringBuilder(Integer.toBinaryString(CompressionValuesMapper.toValue(str[i])));
            while (temp.length() % bit != 0) {
                temp.insert(0, "0");
            }
            strBinary.append(temp);
        }
        while (strBinary.length() % 8 != 0) {
            strBinary.append("0");
        }
        for (int i = 0; i < strBinary.length(); i = i + 8) {
            Integer tempInt = Integer.valueOf(strBinary.substring(i, i + 8), 2);
            encoded[i / 8] = tempInt.byteValue();
        }

        return encoded;
    }

}
