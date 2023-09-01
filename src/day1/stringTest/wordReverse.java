package day1.stringTest;

import java.util.ArrayList;

public class wordReverse {
    public static void main(String[] args) {
        solution(new String[]{"sddf", "good", "test"});
    }

    public static ArrayList<String> solution(String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x: str) {
            int lt=0, rt=x.length()-1;
            char[] s = x.toCharArray();
            while (lt<rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;;
            }
//            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(String.valueOf(s));
        }
        return answer;
    }
}
