package gof.decorator;

public class CompressionValuesMapper {

    public static int toValue(char ch) {
        return switch (ch) {
            case 'a' -> 1;
            case 'b' -> 2;
            case 'c' -> 3;
            case 'd' -> 4;
            case 'e' -> 5;
            case 'f' -> 6;
            case 'g' -> 7;
            case 'h' -> 8;
            case 'i' -> 9;
            case 'j' -> 10;
            case 'k' -> 11;
            case 'l' -> 12;
            case 'm' -> 13;
            case 'n' -> 14;
            case 'o' -> 15;
            case 'p' -> 16;
            case 'q' -> 17;
            case 'r' -> 18;
            case 's' -> 19;
            case 't' -> 20;
            case 'u' -> 21;
            case 'v' -> 22;
            case 'w' -> 23;
            case 'x' -> 24;
            case 'y' -> 25;
            case 'z' -> 26;
            case '.' -> 27;
            case '*' -> 28;
            case ',' -> 29;
            case '\\' -> 30;
            case '2' -> 31;
            case 'A' -> 32;
            case 'B' -> 33;
            case 'C' -> 34;
            case 'D' -> 35;
            case 'E' -> 36;
            case 'F' -> 37;
            case 'G' -> 38;
            case 'H' -> 39;
            case 'I' -> 40;
            case 'J' -> 41;
            case 'K' -> 42;
            case 'L' -> 43;
            case 'M' -> 44;
            case 'N' -> 45;
            case 'O' -> 46;
            case 'P' -> 47;
            case 'Q' -> 48;
            case 'R' -> 49;
            case 'S' -> 50;
            case 'T' -> 51;
            case 'U' -> 52;
            case 'V' -> 53;
            case 'W' -> 54;
            case '0' -> 55;
            case '1' -> 56;
            case '3' -> 57;
            case '4' -> 58;
            case '5' -> 59;
            case '6' -> 60;
            case '7' -> 61;
            case '8' -> 62;
            case '9' -> 63;
            default -> 0;
        };
    }

    public static char toChar(int val) {
        char ch = ' ';
        switch (val) {
            case 1 -> ch = 'a';
            case 2 -> ch = 'b';
            case 3 -> ch = 'c';
            case 4 -> ch = 'd';
            case 5 -> ch = 'e';
            case 6 -> ch = 'f';
            case 7 -> ch = 'g';
            case 8 -> ch = 'h';
            case 9 -> ch = 'i';
            case 10 -> ch = 'j';
            case 11 -> ch = 'k';
            case 12 -> ch = 'l';
            case 13 -> ch = 'm';
            case 14 -> ch = 'n';
            case 15 -> ch = 'o';
            case 16 -> ch = 'p';
            case 17 -> ch = 'q';
            case 18 -> ch = 'r';
            case 19 -> ch = 's';
            case 20 -> ch = 't';
            case 21 -> ch = 'u';
            case 22 -> ch = 'v';
            case 23 -> ch = 'w';
            case 24 -> ch = 'x';
            case 25 -> ch = 'y';
            case 26 -> ch = 'z';
            case 27 -> ch = '.';
            case 28 -> ch = '*';
            case 29 -> ch = ',';
            case 30 -> ch = '\\';
            case 31 -> ch = '2';
            case 32 -> ch = 'A';
            case 33 -> ch = 'B';
            case 34 -> ch = 'C';
            case 35 -> ch = 'D';
            case 36 -> ch = 'E';
            case 37 -> ch = 'F';
            case 38 -> ch = 'G';
            case 39 -> ch = 'H';
            case 40 -> ch = 'I';
            case 41 -> ch = 'J';
            case 42 -> ch = 'K';
            case 43 -> ch = 'L';
            case 44 -> ch = 'M';
            case 45 -> ch = 'N';
            case 46 -> ch = 'O';
            case 47 -> ch = 'P';
            case 48 -> ch = 'Q';
            case 49 -> ch = 'R';
            case 50 -> ch = 'S';
            case 51 -> ch = 'T';
            case 52 -> ch = 'U';
            case 53 -> ch = 'V';
            case 54 -> ch = 'W';
            case 55 -> ch = '0';
            case 56 -> ch = '1';
            case 57 -> ch = '3';
            case 58 -> ch = '4';
            case 59 -> ch = '5';
            case 60 -> ch = '6';
            case 61 -> ch = '7';
            case 62 -> ch = '8';
            case 63 -> ch = '9';
            default -> {
            }
        }
        return ch;
    }
}
