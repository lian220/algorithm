package day1.lguPlus;

import java.util.Arrays;

public class CustomizedLessons {
    public static int minDifferenceSum(int[] scores, int k) {
        Arrays.sort(scores); // 점수를 오름차순으로 정렬

        int n = scores.length;
        int minDifferenceSum = 0;

        // 팀당 학생 수 계산
        int teamSize = n / k;
        int remainder = n % k;

        int start = 0;
        int end = 0;

        // 팀을 나누어서 각 팀의 최대 점수와 최소 점수 차이 계산
        for (int i = 0; i < k; i++) {
            end = start + teamSize + (i < remainder ? 1 : 0);
            int difference = scores[end - 1] - scores[start];
            minDifferenceSum += difference;
            start = end;
        }

        return minDifferenceSum;
    }

    public static void main(String[] args) {
        int[] scores1 = {1, 3, 7, 8, 10, 15};
        int k1 = 3;
        int result1 = minDifferenceSum(scores1, k1);
        System.out.println("입출력예 1: " + result1);

        int[] scores2 = {1, 2, 12, 14, 15};
        int k2 = 2;
        int result2 = minDifferenceSum(scores2, k2);
        System.out.println("입출력예 2: " + result2);
    }
}



