package ohouse;

import java.util.Stack;

public class test1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // 괄호 쌍을 나타내는 맵
        java.util.HashMap<Character, Character> map = new java.util.HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                // 여는 괄호인 경우 스택에 추가
                stack.push(c);
            } else if (map.containsKey(c)) {
                // 닫는 괄호인 경우
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "([]){}";
        boolean result1 = isValid(s1);
        System.out.println("'" + s1 + "'는 유효한 괄호 문자열입니다: " + result1);

        String s2 = "[(]){}";
        boolean result2 = isValid(s2);
        System.out.println("'" + s2 + "'는 유효한 괄호 문자열입니다: " + result2);
    }

}
