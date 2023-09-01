package day1.stack;

import java.util.Stack;

public class removeSignStr {
    public static void main(String[] args) {
        solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)");
    }

    private static String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x: s.toCharArray()) {
            if(x ==')'){
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for(int i=0; i< stack.size(); i++) answer+=stack.get(i);

        return answer;
    }


}
