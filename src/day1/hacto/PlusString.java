package day1.hacto;

public class PlusString {
    public static void main(String[] args) {
        String a = "1234";
        String b = "5678";
        System.out.println(solution(a, b));

    }

//    public static String solution(String a, String b) {
//        int A = Integer.parseInt(a);
//        int B = Integer.parseInt(b);
//        int sum = A + B;
//        return sum + "";
//    }

    public static String solution(String a, String b) {
        String answer = "";
        int carry = 0;
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        while (aLen >= 0 || bLen >= 0) {
            int sum = carry;
            if (aLen >= 0) {
                sum += a.charAt(aLen) - '0';
                aLen--;
            }
            if (bLen >= 0) {
                sum += b.charAt(bLen) - '0';
                bLen--;
            }
            answer = (sum % 10) + answer;
            carry = sum / 10;
        }
        return answer;


//        StringBuilder result = new StringBuilder();
//
//        int carry = 0;
//        int maxLength = Math.max(a.length(), b.length());
//
//        for (int i = 0; i < maxLength; i++) {
//            int digitA = (i < a.length()) ? Character.getNumericValue(a.charAt(a.length() - 1 - i)) : 0;
//            int digitB = (i < b.length()) ? Character.getNumericValue(b.charAt(b.length() - 1 - i)) : 0;
//
//            int currentSum = digitA + digitB + carry;
//
//            carry = currentSum / 10;
//            result.insert(0, currentSum % 10);
//        }
//
//        if (carry > 0) {
//            result.insert(0, carry);
//        }
//
//        return result.toString();

    }
}
