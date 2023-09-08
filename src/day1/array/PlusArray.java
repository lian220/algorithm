package day1.array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PlusArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; st.hasMoreTokens(); i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(bf.readLine());
//        int n = 9;
//        int[] arr = {5, 12, 7, 10, 9, 1, 2, 3, 11};
//        int x = 13;
        solution(n, arr, x);

    }

    private static void solution(int n, int[] arr, int x) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        boolean[] exist = new boolean[1000001];
        for(int i =0; i < n; i++) {
            exist[arr[i]] = true;
        }

        for (int i = 1; i <= (x - 1) / 2; i++) {
            if ( i <= 1000000 &&  x - i <= 1000000)
                answer += (exist[i] && exist[x - i]) ? 1 : 0;
        }
        bw.write(answer + "");
        bw.flush();
    }


}
