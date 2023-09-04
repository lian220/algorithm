package fastcamp.day1.string;

import java.util.Map;
import java.util.Scanner;

public class Anagram1 {

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = "abbbcc";
        String str2 = "xxyybb";

        int[] countA = getAlphabetCount(str1);
        int[] countB = getAlphabetCount(str2);

        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            cnt += Math.abs(countA[i] - countB[i]);
//            if(countA[i] > countB[i])
//                cnt += countA[i] - countB[i];
//            else if (countB[i] > countA[i])
//                cnt += countB[i] - countA[i];
        }
        System.out.println(cnt);

    }
}
