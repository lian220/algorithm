package day1.petFriends;

import java.util.Arrays;

public class CanRotateToMatch {

    public static void main(String[] args) {
        int[] arrA1 = {7, 8, 10};
        int[] arrB1 = {10, 7, 8};
        System.out.println(canRotateToMatch(arrA1, arrB1)); // true

        int[] arrA2 = {4, 3, 2, 1};
        int[] arrB2 = {5, 4, 1, 2};
        System.out.println(canRotateToMatch(arrA2, arrB2)); // false
    }

    public static boolean canRotateToMatch(int[] arrA, int[] arrB) {
        // 배열 A와 배열 B의 길이가 다르면 회전해서 일치시킬 수 없음
        if (arrA.length != arrB.length) {
            return false;
        }

        // 배열 A를 회전하여 가능한 모든 경우를 확인
        for (int i = 0; i < arrA.length; i++) {
            if (Arrays.equals(arrA, arrB)) {
                return true;
            }
            // 배열 A를 회전 (한 칸씩 오른쪽으로 이동)
            int temp = arrA[arrA.length - 1];
            System.arraycopy(arrA, 0, arrA, 1, arrA.length - 1);
            arrA[0] = temp;
        }

        // 모든 회전을 시도한 후에도 일치하지 않으면 false 반환
        return false;
    }


    public static boolean solution(int[] arrA, int[] arrB) {
        // 배열 A와 배열 B의 길이가 다르면 회전해서 일치시킬 수 없음
        int aLength = arrA.length;
        if (aLength != arrB.length) {
            return false;
        }

        for(int i = 0; i < aLength; i++) {
            int temp = arrA[i];

            if(arrA[i] != arrB[aLength - i]) {
                return false;
            }
        }

        // 문자열 arrAConcat에서 문자열 arrB를 찾습니다.
        // 만약 찾을 수 있다면, 배열 A를 회전시켜 배열 B를 만들 수 있습니다.
        return true;
    }

}
