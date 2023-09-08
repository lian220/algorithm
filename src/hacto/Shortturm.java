package hacto;

public class Shortturm {
    public static void main(String[] args) {
        String s1 = "abababab";
        System.out.println(solution(s1)); // 출력: 2

        String s2 = "abcabcabd";
        System.out.println(solution(s2));
    }

//    public static int solution(String s) {
//        int length = s.length();
//        for (int i = 1; i <= length / 2; i++) {
//            if (length % i == 0) {
//                String pattern = s.substring(0, i);
//                StringBuilder repeated = new StringBuilder();
//                for (int j = 0; j < length / i; j++) {
//                    repeated.append(pattern);
//                }
//                if (s.equals(repeated.toString())) {
//                    return i;
//                }
//            }
//        }
//        return length;
//    }

    public static int solution(String s) {
        int n = s.length();
        int[] pi = new int[n];

        // pi 배열 초기화
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
            }
        }

        int period = n - pi[n - 1];
        if (n % period == 0) {
            return period;
        } else {
            return n;
        }
    }





}
