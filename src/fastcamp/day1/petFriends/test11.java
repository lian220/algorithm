package fastcamp.day1.petFriends;

public class test11 {
    public static void main(String[] args) {
        new test11().solution(20);
    }

    public int solution(int s) {
        int minPerimeter = Integer.MAX_VALUE;  // 둘레의 최솟값을 초기화

        for (int a = 1; a <= Math.sqrt(s); a++) {
            if (s % a == 0) {
                int b = s / a;  // b는 s를 a로 나눈 몫
                int perimeter = 2 * (a + b);  // 둘레 계산
                minPerimeter = Math.min(minPerimeter, perimeter);  // 최솟값 갱신
            }
        }

        return minPerimeter;

    }

}
