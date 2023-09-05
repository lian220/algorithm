package fastcamp.day1.array;

public class DefenceCastle {
    public static void main(String[] args) {
        int x = 4;
        int y = 4;
        String[][] grid = {{".", ".", ".", "."},
                {".", ".", ".", "."},
                {".", ".", ".", "."},
                {".", ".", ".", "."}};
//        int x = 3;
//        int y = 5;
//        String[][] grid = {{"X", "X", ".", ".", "."},
//                {".", "X", "X", ".", "."},
//                {".", ".", ".", "X", "X"}};
//        int x = 5;
//        int y = 8;
//        String[][] grid = {{".", ".", ".", ".", "X", "X", "X", "X"},
//                {".", ".", ".", ".", ".", ".", ".", "."},
//                {"X", "X", ".", "X", ".", "X", "X", "."},
//                {".", ".", ".", ".", ".", ".", ".", "."},
//                {".", ".", ".", ".", ".", ".", ".", "."}};
        solution(x, y, grid);
    }

    private static void solution(int x, int y, String[][] grid) {
//        int[] xGuider = new int[x];
//        int[] yGuider = new int[y];
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                if (grid[0][j].equals("X")) {
//                    xGuider[i] += 1;
//                }
//                if (grid[i][j].equals("X")) {
//                    yGuider[j] += 1;
//                }
//            }
//        }
//        int xGuiderCnt = 0;
//        for (int guider : xGuider) {
//            if(guider == 1) xGuiderCnt++;
//        }
//        int yGuiderCnt = 0;
//        for (int guider : yGuider) {
//            if(guider == 1) yGuiderCnt++;
//        }


//        Integer min = x > y ? yGuiderCnt : xGuiderCnt;
//        for(int i =0; i < xGuider.length; i++) {
//
//        }
        int existRowCount = 0;
        for (int i = 0; i < x; i++) {
            boolean isExist = false;
            for (int j = 0; j < y; j++) {
                if (grid[i][j].equals("X")) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) existRowCount++;
        }

        int existColCount = 0;
        for (int i = 0; i < y; i++) {
            boolean isExist = false;
            for (int j = 0; j < x; j++) {
                if (grid[j][i].equals("X")) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) existColCount++;
        }
        int needRowCount = x - existRowCount;
        int needColCount = y - existColCount;
        System.out.println(Math.max(needRowCount, needColCount));
    }
}
