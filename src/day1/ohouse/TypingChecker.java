package day1.ohouse;

public class TypingChecker {
    public static boolean isCorrectlyTyped(String target, String typed) {
        int targetLength = 0; // target 문자열 인덱스
        int typedLength = 0; // typed 문자열 인덱스

        while (typedLength < typed.length()) {
            if (targetLength < target.length() && target.charAt(targetLength) == typed.charAt(typedLength)) {
                targetLength++; // 일치하는 문자일 경우 target 인덱스 증가
            } else if (typedLength == 0 || typed.charAt(typedLength) != typed.charAt(typedLength - 1)) {
                // 현재 문자가 이전 문자와 다르고, j가 0인 경우나 이전 문자와 다른 경우
                return false;
            }
            typedLength++; // typed 인덱스 증가
        }

        return targetLength == target.length(); // 모든 typed 문자열이 확인되었을 때 target 문자열의 끝까지 일치하는지 확인
    }

    public static void main(String[] args) {
        String target1 = "ohouse";
        String typed1 = "oohoussse";
        System.out.println(isCorrectlyTyped(target1, typed1)); // true

        String target2 = "bucketplace";
        String typed2 = "buckeetpladce";
        System.out.println(isCorrectlyTyped(target2, typed2)); // false
    }

}
