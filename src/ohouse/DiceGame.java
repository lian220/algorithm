package ohouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiceGame {
    public static void main(String[] args) {
//        new DiceGame().solution(new String[]{"2", "3", "+", "D", "0","3", "R"});
        new DiceGame().solution(new String[]{"9", "D", "3", "4", "D", "R", "R", "+"});
    }

    public int solution(String[] rolls) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (rolls[i].equals("R")) {
                stack.pop();
            } else if (rolls[i].equals("+")) {
                int temp = stack.peek();
                stack.pop();
                int temp2 = stack.peek();
                stack.push(temp);
                stack.push(temp + temp2);
            } else {
                stack.push(Integer.parseInt(rolls[i]));
            }
        }
        answer = stack.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}
