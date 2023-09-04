package fastcamp.day1.string;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
//        String str1 = "dared";
//        String str2 = "bread";
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    str1 = str1.substring(0, i) + str1.substring(i + 1, str1.length());
                    str2 = str2.substring(0, j) + str2.substring(j + 1, str2.length());
                    i = 0;
                    j = 0;
                }
            }
        }
        if(!str1.equals(str2)) {
            cnt = str1.length() + str2.length();
        }
        System.out.println(cnt);




    }
}
