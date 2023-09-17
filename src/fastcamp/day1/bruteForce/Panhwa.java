package fastcamp.day1.bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Panhwa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String directions = sc.next();
        char[][] panhwa = new char[n][n];

        for (int x = 0; x < n; x++) {
            Arrays.fill(panhwa[x], (char) 46);
        }
        int[] right = {0, 1};
        int[] left = {0, -1};
        int[] up = {-1, 0};
        int[] down = {1, 0};

        char beforeDirection = directions.toCharArray()[0];
        int[] moved = {0, 0};
        for(char direction : directions.toCharArray()) {
            switch (direction) {
                case 'R':
                    if(!isCheckPossilbleMove(moved, right, n)) break;
                    checkedMove(panhwa, beforeDirection, direction, moved, right, 45);
                    moved = setMoved(moved, right);
                    beforeDirection = 'R';
                    break;
                case 'L':
                    if(!isCheckPossilbleMove(moved, left, n)) break;
                    checkedMove(panhwa, beforeDirection, direction, moved, left, 45);
                    moved = setMoved(moved, left);
                    beforeDirection = 'L';
                    break;
                case 'U':
                    if(!isCheckPossilbleMove(moved, up, n)) break;
                    checkedMove(panhwa, beforeDirection, direction, moved, up, 124);
                    moved = setMoved(moved, up);
                    beforeDirection = 'U';
                    break;
                case 'D':
                    if(!isCheckPossilbleMove(moved, down, n)) break;
                    checkedMove(panhwa, beforeDirection, direction, moved, down, 124);
                    moved = setMoved(moved, down);
                    beforeDirection = 'D';
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                System.out.print(panhwa[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean isCheckPossilbleMove(int[] moved, int[] move, int length) {
        if (moved[0] + move[0] < length && moved[1] + move[1] < length
                && moved[0] + move[0] >= 0 && moved[1] + move[1] >= 0) return true;
        return false;
    }

    private static int[] setMoved(int[] moved, int[] move) {
        moved = new int[]{moved[0] + move[0], moved[1] + move[1]};
        return moved;
    }

    private static char[][] checkedMove(char[][] panhwa, char beforeDirection, char direction, int[] moved, int[] move, int checked) {
        if(beforeDirection != direction && panhwa[moved[0]][moved[1]] != (char) 46)
            panhwa[moved[0]][moved[1]] = (char) 43;
        else
            panhwa[moved[0]][moved[1]] = (char) checked;
        panhwa[moved[0] + move[0]][moved[1] + move[1]] = (char) checked;
        return panhwa;
    }


}
