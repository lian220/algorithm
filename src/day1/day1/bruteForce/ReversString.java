package day1.day1.bruteForce;

import java.util.Scanner;

public class ReversString {
    public static void main(String[] args) {
//        int length = 3;
//        int[] arr = {3000512};
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        solution(length, arr);
    }

    private static void solution(int length, int[] arr) {
        for (int i = 0; i < length; i++) {
            boolean ans = false;
            for (int j = 2; j <= 64; j++) {
                if (isPalindromeInBase(arr[i], j)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? 1 : 0);
        }


//        String[] convert = new String[length];
//        for (int i = 0; i < length; i++) {
//            int n = arr[i];
//
//            if(String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse().toString())){
//                convert[i] = "1";
//                break;
//            } else convert[i] = "0";
//            // 1. B진법 으로 변환을 한다.
//            for (int b = 2; b <= 64; b++) {
//                String converted = getBStr(n, b);
//                if (converted.equals(new StringBuilder(converted).reverse().toString())) {
//                    convert[i] = "1";
//                    break;
//                }
//                convert[i] = "0";
//            }
//        }
//
//
//        for (int i = 0; i < length; i++) {
//            System.out.println(convert[i]);
//        }
    }

    public static boolean isPalindromeInBase(int x, int base) {
        int[] digit = new int[20];
        int len = 0;
        while (x > 0) {
            digit[len++] = x % base;
            x /= base;
        }

        for (int i = 0; i < len / 2; i++)
            if (digit[i] != digit[len - i - 1])
                return false;
        return true;
    }

    public static String getBStr(int n, int b) {
        String answer = "";
        while (n > 0) {
            int digit = n % b;
            if (digit < 10) answer = digit + answer;
            else answer = (char) ('A' + digit - 10) + answer;
            n /= b;
        }
        return answer;
    }
}
