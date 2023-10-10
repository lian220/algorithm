package day1.day1.bruteForce;

import java.util.Scanner;

public class Panhwa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String command = sc.hasNext() ? sc.next() : "";

        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizon = new boolean[N][N];

        int curR = 0, curC = 0;
        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if (cmd == 'D') {
                if (curR == N - 1) continue;
                passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
                curR++;
            } else if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
                curR--;
            } else if (cmd == 'L') {
                if (curC == 0) continue;
                passHorizon[curR][curC] = passHorizon[curR][curC - 1] = true;
                curC--;
            } else {
                if (curC == N - 1) continue;
                passHorizon[curR][curC] = passHorizon[curR][curC + 1] = true;
                curC++;
            }
        }

        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if (passVertical[i][j] && passHorizon[i][j]) ans += "+";
                else if (passVertical[i][j]) ans += "|";
                else if (passHorizon[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }


    }
}
