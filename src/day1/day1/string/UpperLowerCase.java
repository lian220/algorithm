package day1.day1.string;

public class UpperLowerCase {
    public static void main(String[] args) {
        new UpperLowerCase().solution("ABscDef");
    }

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        for (char alphabet: str.toCharArray()) {
            if(Character.isUpperCase(alphabet)) {
                answer.append(String.valueOf(alphabet).toLowerCase());
            } else {
                answer.append(String.valueOf(alphabet).toUpperCase());
            }
        }

        for(int i = 0; i< str.length(); i++) {
            char ch = str.charAt(i);
            if('A' <= str.charAt(i) && 'Z' >= str.charAt(i)) {
                answer.append((char)('a' - 'A' + ch));
            } else {
                answer.append((char)('A' - 'a' + ch));
            }
        }
        System.out.println(answer);
        return answer.toString();
    }
}
