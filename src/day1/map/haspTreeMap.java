package day1.map;

import java.util.HashMap;
import java.util.Map;

public class haspTreeMap {
    public static void main(String[] args) {
        solution(10, "AAABBCCAAE");
    }

    public static char solution(int n, String s) {
        char answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        char t = map.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();

        for (Character x: map.keySet()) {
            if(map.get(x) > max) {
                max = map.get(x);
                answer = x;
            }
        }
        System.out.println(answer == 'A');
        return answer;
    }
}
