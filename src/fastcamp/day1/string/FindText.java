package fastcamp.day1.string;

public class FindText {
    public static void main(String[] args) {
        String doc = "aaaaaaa";
        String word="aa";

//        Scanner sc = new Scanner(System.in);
//        String doc = sc.nextLine();
//        String word = sc.nextLine();
//        int count = 0;
//        for(int i = 0; i < doc.length() - word.length() + 1; i++) {
//            String temp = doc.substring(i, word.length() + i);
//            if(temp.equals(word)) {
//                count++;
//                i += (word.length() - 1);
//            }
//        }
//        System.out.println(count);

        int startIndex = 0;
        int count = 0;
        while(true) {
            int findIndex = doc.indexOf(word, startIndex);
            if( findIndex < 0) break;
            startIndex = findIndex + word.length();
            count++;
        }
        System.out.println(count);

        String replaced = doc.replace(word, "");
        int length = doc.length() - replaced.length();
        count = length / word.length();
        System.out.println(count)  ;

    }
}
