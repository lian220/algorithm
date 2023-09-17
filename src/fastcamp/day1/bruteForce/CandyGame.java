package fastcamp.day1.bruteForce;

import java.util.Scanner;
public class CandyGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] candys = new char[N][N];
        for (int i = 0; i < N; i++) {
            candys[i] = sc.next().toCharArray();
        }

        System.out.println(getCandyCount(candys, N));
    }

    private static int getCandyCount(char[][] candys, int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 가로로 바꾸기
                if(j + 1 < n) {
                    char temp = candys[i][j];
                    candys[i][j] = candys[i][j + 1];
                    candys[i][j + 1] = temp;
                    int max = getMaxCandyCount(candys, n);
                    candys[i][j + 1] = candys[i][j];
                    candys[i][j] = temp;
                    answer = Math.max(answer, max);
                }

                // 세로로 바꾸기
                if(i + 1 < n) {
                    char temp = candys[i][j];
                    candys[i][j] = candys[i + 1][j];
                    candys[i + 1][j] = temp;
                    int max = getMaxCandyCount(candys, n);
                    candys[i + 1][j] = candys[i][j];
                    candys[i][j] = temp;
                    answer = Math.max(answer, max);
                }


            }
        }
        return answer;
    }

    private static int getMaxCandyCount(char[][] candys, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 1; j < n; j++) {
                if(candys[i][j] == candys[i][j - 1]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 1; j < n; j++) {
                if(candys[j][i] == candys[j - 1][i]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
