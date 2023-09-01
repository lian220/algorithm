package day1.stringTest;

public class specipickReverse {
    public static void main(String[] args) {
        solution("Ser123EEt4t4E");
    }

    public static String solution(String str) {
        String answer;
        char[] s = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt < rt) {
            char x = s[lt];
            if(Character.isAlphabetic(x) && Character.isAlphabetic(s[rt])) {
                s[lt] = s[rt];
                s[rt] = x;
            }
            lt++;
            rt--;
        }
        answer = String.valueOf(s);
        return answer;
    }
}
