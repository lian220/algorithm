package Nexon;

import java.util.Arrays;

public class Keypad {

    public static void main(String[] args) {
        String s = "423692";
        String keypad = "923857614";
        entryTime(s, keypad);
    }

    private static int entryTime(String s, String keypad) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dictionary = new int[10][10];

        //1. 키패드 생성
        setKeypad(pad, keypad);

        //2. 번호 별로 거리 계산배열 생성
        makeDictionary(pad, dictionary, dx, dy);

        for(int i=1; i<s.length();i++){
            int from = s.charAt(i - 1) - 48;
            int to = s.charAt(i) - 48;
            answer += dictionary[from][to];
        }

        return answer;
    }

    private static int[][] makeDictionary(int[][] pad, int[][] dictionary, int[] dx, int[] dy) {
        for(int i=0;i<10;i++){
            Arrays.fill(dictionary[i],2);
        }
        for(int i=0; i<10;i++){
            dictionary[i][i] = 0;
        }
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                int from = pad[i][j];
                for(int k=0; k<8; k++){
                    if(i+dx[k] >=0 && i+dx[k] < 3 && j+dy[k] >=0 && j+dy[k] <3){
                        int to = pad[i + dx[k]][j + dy[k]];
                        dictionary[from][to] = 1;
                    }
                }
            }
        }
        return dictionary;
    }

    private static int[][] setKeypad(int[][] pad, String keypad) {
        char[] chars = keypad.toCharArray();
        for(int i=0; i<3; i++){
            for(int j=0; j<3;j++){
                pad[i][j] = Integer.parseInt(String.valueOf(chars[(i * 3) + j]));
            }
        }
        return pad;
    }

//    public static int entryTime(String s, String keypad) {
//        // Write your code here
//        int cnt = 0;
//        int[][] arr = new int[3][3];
//        for(int i = 0; i < keypad.length(); i++) {
//            arr[i / 3][i % 3] = keypad.charAt(i);
//        }
//        for (int i = 0; i < s.length() - 1; i++) {
//            cnt += getDistance(arr, s.charAt(i), s.charAt(i + 1));
//        }
//        System.out.println( arr);
//        return cnt;
//
//    }
//
//    public static int getDistance(int[][] arr, int start, int end) {
//        int cnt = 0;
//        int startX = start;
//        int startY = 0;
//        int endX = 0;
//        int endY = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr.length; j++){
//                if(arr[i][j] == start) {
//                    startX = i;
//                    startY = j;
//                }
//                if(arr[i][j] == end) {
//                    endX = i;
//                    endY = j;
//                }
//            }
//        }
//        cnt = Math.abs(startX - endX);
//        return cnt;
//    }
}
