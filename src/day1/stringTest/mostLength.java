package day1.stringTest;

public class mostLength {
    public static void main(String[] args) {
        String msg = "ComputerCooler";
        solution(msg, 'C');

    }


    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for (char x: str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }
}