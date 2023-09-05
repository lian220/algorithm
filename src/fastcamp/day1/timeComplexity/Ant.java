package fastcamp.day1.timeComplexity;

import java.util.Scanner;

public class Ant {
    public static void main(String[] args) {
        String grid = "6 4";
        String start = "5 3";
        String time = "8";
        getAntPosition(grid, start, Integer.parseInt(time));

    }

    private static void getAntPosition(String grid, String start, int time) {
        String[] gridArr = grid.split(" ");
        String[] startArr = start.split(" ");
        int[] gridIntArr = new int[gridArr.length];
        int[] startIntArr = new int[startArr.length];
        for (int i = 0; i < gridArr.length; i++) {
            gridIntArr[i] = Integer.parseInt(gridArr[i]);
        }
        for (int i = 0; i < startArr.length; i++) {
            startIntArr[i] = Integer.parseInt(startArr[i]);
        }
        int delatX = startIntArr[0];
        int delatY = startIntArr[1];
//        int[][] directionArr = {{1,1}, {-1 , 1}, {-1, -1}, {-1, 1}};
//        int direction = 0;
//        int round = time % (gridIntArr[0] * gridIntArr[1]);
//        for (int i = 0; i < round; i++) {
//            delatX += directionArr[direction][0];
//            delatY += directionArr[direction][1];
//            if(delatX == gridIntArr[0] || delatX == 0) {
//                direction = (direction + 1) % 4;
//            }
//            if(delatY == gridIntArr[1] || delatY == 0) {
//                direction = (direction + 1) % 4;
//            }
//        }


        int currentX = (delatX + time) % (gridIntArr[0] * 2);
        int currentY = (delatY + time) % (gridIntArr[1] * 2);
        ;
        if (currentX > gridIntArr[0]) {
            currentX = gridIntArr[0] - (currentX - gridIntArr[0]);
        }
        if (currentY > gridIntArr[1]) {
            currentY = gridIntArr[1] - (currentY - gridIntArr[1]);
        }
        System.out.println(currentX + " " + currentY);

        int W = gridIntArr[0];
        int H = gridIntArr[1];
        int P = startIntArr[0];
        int Q = startIntArr[1];
        int T = time;

//        int X = T % (2 * W);
//        int deltaX = 1;
//        while (X-- > 0) {
//            if (P == W || P == 0) deltaX *= -1;
//            P += deltaX;
//        }
//
//        int Y = T % (2 * H);
//        int deltaY = 1;
//        while (Y-- > 0) {
//            if (Q == H || Q == 0) deltaY *= -1;
//            Q += deltaY;
//        }

        int currenX = (P + T) % (2 * W);
        int currenY = (Q + T) % (2 * H);
        if(currenX > W) {
            currenX = 2 * W - currenX;
        }
        if(currenY > H) {
            currenY = 2 * H - currenY ;
        }

        System.out.println(currenX + " " + currenY);
    }
}
