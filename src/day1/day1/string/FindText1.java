package day1.day1.string;

public class FindText1 {
    public static void main(String[] args) {
        String doc = "a a a a a";
        String word="a a";

        int count = 0;
        for(int i = 0; i <doc.length(); i++) {
            boolean isMatch = true;
            for(int j = 0; j < word.length(); j++) {
                if(i + j >= doc.length() ||
                        doc.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) {
                count++;
                i += word.length() - 1;
            }
        }
    }
}
