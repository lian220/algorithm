package day1.day1.bruteForce;

import java.util.Scanner;

public class Euraka {

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void main(String[] args) {
        //1. K보다 작은 삼각수를 모두 구한다.
        //2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
        preprocess();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int[] numbers = {3, 10, 20};
//        int K = 1000;

        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? 1 : 0);
        }
    }

    public static boolean preprocess() {
        //1. K보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[50];
        int triangleNumberCnt = getTriangleNumbers(triangleNumbers, 1000);


        //2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
        boolean[] isSumOfTriangleNumber = new boolean[1001];
        for (int i = 0; i < triangleNumberCnt; i++) {
            for (int j = 0; j < triangleNumberCnt; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) isSumOfTriangleNumber[sum] = true;
            }
        }

        for (int i = 0; i < 1000; i++) {
            if (!isSumOfTriangleNumber[i]) continue;
            for (int j = 0; j < triangleNumberCnt; j++) {
                int sum = i + triangleNumbers[j];
                if (sum <= 1000) isEurekaNumber[sum] = true;
            }
        }
        return false;
    }

    public static int getTriangleNumbers(int[] triangleNumbers, int K) {
        int triangleNumberCnt = 0;
        for (int i = 1; ; i++) {
            int traingleNumber = (i * (i + 1)) / 2;
            if (traingleNumber > K) break;
            triangleNumbers[triangleNumberCnt++] = traingleNumber;
        }
        return triangleNumberCnt;
    }
}
