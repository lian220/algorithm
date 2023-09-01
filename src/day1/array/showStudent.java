package day1.array;

public class showStudent {
    public static void main(String[] args) {
        int[] students = {130, 135, 148, 140, 145, 150, 150, 153};
        solution(students);
    }

    public static int solution(int[] students) {
        int answer = 0;
        int bestTallStudent = 0;
        for (int student :students) {
            if(bestTallStudent < student) {
                bestTallStudent = student;
                answer++;
            }
        }
        return answer;
    }

}
