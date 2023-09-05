package fastcamp.day1.string;

import java.util.Scanner;

public class MostAlphbet {
    public static void main(String[] args) {
        String str = "baaadddFFFeeFEd";
        int[] alphabetArr = new int[26];
        str = str.toLowerCase();
        for (char x: str.toCharArray()) {
            alphabetArr[(int)x - 'a']++;
        }

        char answer = getAnswer(alphabetArr);

        System.out.println(answer);
    }

    private static char getAnswer(int[] alphabetArr) {
        int mostAlphabet = 0;
        char answer = 0;
        for (int i = 0 ; i < alphabetArr.length; i++) {
            mostAlphabet = Math.max(mostAlphabet, alphabetArr[i]);
        }

        int cnt = 0;
        for(int i = 0; i < alphabetArr.length; i++) {
            if(mostAlphabet == alphabetArr[i]) {
                answer = (char) (i + 'A');
                cnt++;
            } else if(cnt == 2){
                return '?';
            }
        }
        return answer;
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        int[] alphabetArr = new int[26];
//        str = str.toLowerCase();
//        for (char x: str.toCharArray()) {
//            alphabetArr[(int)x - 'a']++;
//        }
//
//        int mostAlphabet = Integer.MIN_VALUE;
//        for (int cnt: alphabetArr) {
//            mostAlphabet = Math.max(mostAlphabet, cnt);
//        }
//    }
//}
