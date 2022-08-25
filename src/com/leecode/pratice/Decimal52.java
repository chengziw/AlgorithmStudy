package com.leecode.pratice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Decimal52 {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入！");
            String number = sc.next();
            // System.out.println(decimal52.getDecimal());
            System.out.println(getBigInteger52(number));
        }
    }

    private static final int LOWER_A = 97;
    private static final int LOWER_Z = 123;
    private static final int UPPER_A = 65;
    private static final int UPPER_Z = 91;

    public static String getBigInteger52(String numStr) {
        if (numStr.length() < 100000) {
            BigInteger num = BigInteger.valueOf(0);
            char[] ch = numStr.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                //单个字符转十进制
                int x1 = Integer.parseInt(String.valueOf(ch[i]));
                //按位计算
                BigInteger x2 = BigInteger.valueOf(10).pow(ch.length - i - 1).multiply(BigInteger.valueOf(x1));
                num = num.add(x2);
            }

            StringBuffer sb = new StringBuffer();
            List<Character> charactersList = new ArrayList<>();
            IntStream.range(UPPER_A, UPPER_Z).forEach((number) -> charactersList.add((char) number));
            IntStream.range(LOWER_A, LOWER_Z).forEach((number) -> charactersList.add((char) number));
            int size = charactersList.size();
            while (true) {
                if (num.compareTo(BigInteger.valueOf(size - 1)) > 0) {
                    BigInteger[] results = num.divideAndRemainder(BigInteger.valueOf(size));
                    num = results[0];
                    sb.append(charactersList.get(Integer.parseInt(String.valueOf(results[1]))));
                } else {
                    sb.append(charactersList.get(Integer.parseInt(String.valueOf(num))));
                    break;
                }
            }
            return sb.reverse().toString();
        }

        return "数据超长！";
    }

}


//    public String convertToBase7(int num) {
//        if (num == 0) {
//            return "0";
//        }
//        boolean negative = num < 0;
//        num = Math.abs(num);
//        StringBuffer digits = new StringBuffer();
//        while (num > 0) {
//            digits.append(num % 7);
//            num /= 7;
//        }
//        if (negative) {
//            digits.append('-');
//        }
//        return digits.reverse().toString();
//    }
//}