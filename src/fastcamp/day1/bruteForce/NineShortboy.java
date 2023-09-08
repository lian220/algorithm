package fastcamp.day1.bruteForce;

import java.util.Scanner;

public class NineShortboy {
    public static void main(String[] args) {
//        int[] heights = {20, 7, 23, 19, 10, 15, 25, 8, 13};
//        int sum = 100;
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(sc.nextLine());
        }

        solution(heights);
    }

    private static void solution(int[] heights) {
        int[] answer = new int[heights.length - 2];
        int sumOfHeights = 0;
        for (int i = 0; i < heights.length; i++) {
            sumOfHeights += heights[i];
        }
        int diff = sumOfHeights - 100;
        boolean isExcept = false;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (diff == heights[i] + heights[j]) {
                    int ansIndex = 0;
                    for (int k = 0; k < heights.length; k++) {
                        if (k != i && k != j)
                            answer[ansIndex++] = heights[k];
                    }
                    isExcept = true;
                    break;
                }
            }
            if (isExcept) break;
        }

        isSertionSort(answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static int[] isSertionSort(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = i; j > 0; j--) {
                if (answer[j] < answer[j - 1]) {
                    int temp = answer[j];
                    answer[j] = answer[j - 1];
                    answer[j - 1] = temp;
                }
            }
        }
        return answer;
    }
}
