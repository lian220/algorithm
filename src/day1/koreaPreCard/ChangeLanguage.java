package day1.koreaPreCard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChangeLanguage {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < Integer.parseInt(input); i++) {
            changeLangaue(br.readLine());
        }
    }

    public static String changeLangaue(String text) {
        String answer = text.charAt(0) + "";

        for (int i = 1; i < text.length(); i++) {
            if (compareText(text.charAt(i))) {
                if(compareText(text.charAt(i -1))) {
                    answer += "";
                } else {
                    answer += text.charAt(i);
                }
            } else {
                answer += text.charAt(i);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static boolean compareText(char text) {
        char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
        for(int i = 0; i < aeiou.length; i++) {
            if(aeiou[i] == text) {
                return true;
            }
        }
        return false;
    }
}
