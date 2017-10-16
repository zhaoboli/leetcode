package bitwise;

import java.util.logging.ConsoleHandler;

public class BitWiseEntry {
    public static void main(String[] args) {
        int a = 10; // 00001010
        int b = 38; // 00100110
        int c = -10;
        int d = 1;
        System.out.println(a & b); //and
        System.out.println(a | b); //or
        System.out.println(a ^ b); //xor
        System.out.println(a << 2); //left shift a * 2**(n) keep the sign: if positive, still positive
        System.out.println(a >> 4); //right shift a / 2**(n) keep the sign: if negative, still negative
        System.out.println(~d + 1);
        System.out.println("logical right shift");
        System.out.println(c >> 3);
        System.out.println(c >>> 1);

        //integer to binary representation
        System.out.println("Testing change");
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("bit count is " + Integer.bitCount(n));
        String out = String.format("%32s", Integer.toBinaryString(1)).replace(' ', '0');
        System.out.println(out);
    }
}
