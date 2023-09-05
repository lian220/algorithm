package fastcamp.day1.string;

import java.util.Scanner;

public class MostAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
        String str = "baaa".toUpperCase();
        int maxCount =  -1;
//        int maxAlphabetIndex = -1;
//        int duplicateCnt = -1;
        char maxAlphabet = '?';
        for (char alp = 'A'; alp <= 'Z'; alp++) {
            int count = getAlphabetCount(str, alp);
            if(count > maxCount) {
                maxCount = count;
                maxAlphabet = alp;
//                maxAlphabetIndex = i;
//                duplicateCnt++;
            } else if(count == maxCount) {
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);

//        if(duplicateCnt > 0) System.out.println("?");
//        else System.out.println((char) ('A' + maxAlphabetIndex));
    }

    private static int getAlphabetCount(String str, char alp ) {
        int count = 0;
        for(int i =0; i < str.length(); i++) {
            if(alp == str.charAt(i)) count++;
        }
        return count;
    }
}
