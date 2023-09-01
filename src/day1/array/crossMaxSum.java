package day1.array;

public class crossMaxSum {
    public static void main(String[] args) {
        int[][] twoHang = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        };
        solution(5, twoHang);
    }

    private static int solution(int n, int[][] twoHang) {
        int maxSum = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += twoHang[i][j];
                sum2 += twoHang[j][i];
            }
        }
        maxSum = Math.max(maxSum, sum1);
        maxSum = Math.max(maxSum, sum2);

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += twoHang[i][i];
            sum2 += twoHang[i][n - i - 1];
        }
        maxSum = Math.max(maxSum, sum1);
        maxSum = Math.max(maxSum, sum2);
        return maxSum;

    }

}
