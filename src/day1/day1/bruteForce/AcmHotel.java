package day1.day1.bruteForce;

import java.util.Scanner;

public class AcmHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] rooms = new int[T][3];
        for (int i = 0; i < T; i++) {
            rooms[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        for (int i = 0; i < T; i++) {
            getRoomNumber(rooms[i][0], rooms[i][1], rooms[i][2]);
        }
    }

    private static void getRoomNumber(int H, int W, int num) {
        int floor = ((num - 1) % H) + 1;
        int roomNumber = (num - 1) / H + 1;
        System.out.printf("%d%02d\n", floor, roomNumber);
    }

//    private static void getRoomNumber(int H, int W, int num) {
//        int floor = num % H;
//        int roomNumber = num / H + 1;
//        if (floor == 0) {
//            floor = H;
//            roomNumber -= 1;
//        }
//        System.out.println(floor + "0" + roomNumber);
//    }


}
