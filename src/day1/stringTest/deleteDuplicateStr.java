package day1.stringTest;

public class deleteDuplicateStr {
    public static void main(String[] args) {
        solution("ksekkset");
    }

    public static String solution(String str) {
        String answer = "";
        for(int i=0;i<str.length();i++){
            if(str.indexOf(str.charAt(i))==i) answer += String.valueOf(str.charAt(i));
        }
        return answer;
    }
}
