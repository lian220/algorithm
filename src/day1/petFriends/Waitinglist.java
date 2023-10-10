package day1.petFriends;


import java.util.LinkedHashSet;
import java.util.Set;

public class Waitinglist {

    public static void main(String[] args) {
        int[] waiting = {1, 5, 8, 2, 10, 5, 4, 6, 4,8};
        new Waitinglist().solution(waiting);

    }

    public int[] solution(int[] waiting) {
        int[] answer = {};
        Set<Integer> watinglist = new LinkedHashSet<>();
        //1. waiting for 돌면서 중복 문자열을 제거
        for(int i = 0; i<waiting.length; i++) {
            watinglist.add(waiting[i]);
        }
        answer = watinglist.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
