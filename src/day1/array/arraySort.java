package day1.array;

import java.util.ArrayList;

public class arraySort {
    public static void main(String[] args) {
        solution(3, 5, new int[]{1,3,5}, new int[]{2,3,6,7,9});
    }

    private static ArrayList<Integer> solution(int i, int j, int[] x, int[] y) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<i && p2<j){
            if(x[p1]<y[p2]) answer.add(x[p1++]);
            else answer.add(y[p2++]);
        }
        while(p1<i) answer.add(x[p1++]);
        while(p2<j) answer.add(y[p2++]);
        System.out.println(answer);
        return answer;
    }


}
