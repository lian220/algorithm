package day1.array;

public class pibonachi {
    public static void main(String[] args) {
        pibonachi.solution(10);
    }

    public static int[] solution(int n) {
        int[] answer= new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i <n;i++) {
            answer[i]=answer[i-2]+answer[i-1];
        }
        return answer;
    }
}
