package day1.day1.bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class LuckyHeels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 칸의 개수
        int K = sc.nextInt(); // 돌린 횟수
        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

//        1. 바퀴의 커서 인덱스를 S만큼 움직인다.
//        1-0. 커서 인덱스가 배열 범위를 넘어 갔다면 조정 한다.

        int curIndex = 0;
        while (K-- > 0) {
            int step = sc.nextInt(); //시계 방향으로 step 만큼 이동
            char backAlphabet = sc.next().charAt(0);
            int nextIndex = ((curIndex - step) % N + N) % N; // 이동한 칸의 index (예정)

//            nextIndex 칸의 알파벳을 확인하는 1-1 ~ 1-3 수행
//            1-1. 도착한 칸이 아직 알아내지 못한 글자라면 기록한다.
//            1-2. 도착한 칸의 글자가 적힌 글자와 다르다면 바퀴는 존재하지 않는다.
//            1-3. 도착한 칸의 글자가 적힌 글자와 같다면 넘어간다.
            if (wheel[nextIndex] == '?') wheel[nextIndex] = backAlphabet;
            else if (wheel[nextIndex] != backAlphabet) {
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        boolean[] chk = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') continue;
            if (chk[wheel[i] - 'A']) {
                System.out.println("!");
                return ;
            }
            chk[wheel[i] - 'A'] = true;
        }


        for(int i = 0; i < N; i++) {
            System.out.print(wheel[(curIndex + i) % N]);
        }
        System.out.println();

//        int curIndex = 0;
//        wheel[curIndex] = inputAlphabet[K - 1];
//        for(int i = K - 2; i >= 0; i--) {
//            int step = inputStep[i + 1];
//            char beforeAlphabet = inputAlphabet[i];
//            int beforeIndex = (curIndex + step) & N;
//            if(wheel[beforeIndex] == '?')
//                wheel[beforeIndex] = beforeAlphabet;
//            else if (wheel[beforeIndex] != beforeAlphabet) {
//                System.out.println("!");
//                return;
//            }
//        }
    }
}
