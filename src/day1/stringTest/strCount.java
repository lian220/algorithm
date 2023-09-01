package day1.stringTest;

public class strCount {
    public static void main(String[] args) {
        String msg = "it is time study to tesrs least";
        solution(msg);

    }


    public static String solution(String str) {
        String answer = "";
//        String[] strArr = str.split(" ");
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m) answer = str;
//        for (String x: strArr) {
//            int len = x.length();
//            if(len >= m) {
//                m = len;
//                answer = x;
//            }
//        }

        return answer;
    }
}
