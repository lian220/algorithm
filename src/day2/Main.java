package day2;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] input = {10,6,5,8};
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++) {
            maxValue = Math.max(maxValue, input[i]);
        }

        int[] tempInput = new int[maxValue + 1];
        for(int i = 0; i < input.length; i++) {
            if(tempInput[input[i]] == 0) {
                tempInput[input[i]] = 1;
            } else {
                tempInput[input[i]] = 2;
            }
        }
//        {0, 0, 0, 0, 0, 5, 0, 0, 8, 0, 10};

        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i< input.length; i++) {
            if(tempInput[input[i]] != 0) {
                if(i < input.length && !(tempInput[input[i + 1]] > 1) || !(tempInput[i - 1] > 1)) {
                    output.add(input[i]);
                } else if (i == input.length && !(tempInput[i - 1] > 1)) {
                    output.add(input[i]);
                }
            }
        }

        //1. find max value in input array
        //2. create temp array with size of max value + 1
        //3. iterate over input array and set temp array value to 1 if it is not set, otherwise set it to 2
        //4. iterate over input array and check if temp array value is 1 and if it is, add it to output array

        System.out.println(output);

    }


}
