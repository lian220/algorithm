package fastcamp.day1.bruteForce;

import java.util.Scanner;

public class TwoConvert {
    public static void main(String[] args) {
        int N = 1000000000;
        int B = 2;
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int B = sc.nextInt();
        System.out.println(solution(N, B).length());
    }

    private static String solution(int n, int b) {
        String answer = "";
        while (n > 0) {
            int digit = n % b;
            if (digit < 10) answer = digit + answer;
            else answer = (char) ('A' + digit - 10) + answer;
            n /= b;
        }


//         자리수를 먼저 구한다.
//        int basePower = 1;
//        int K = 0;
//        while ((long)basePower * b <= n) {
//            basePower *= b;
//            K++;
//        }
//
//        // 자리수를 구했으니, 각 자리수를 구한다.
//        for (int i = K; i >= 0; i--) {
//            int D = n / basePower;
//            n %= basePower;
//            basePower /= b;
//            if(D < 10) answer += D;
//            else answer += (char)(D - 10 + 'A');
//        }

        return answer;
    }


}
