package fastcamp.day1.petFriends;

public class CountStr {
    public static void main(String[] args) {
//        String s = "abbbccd";
        String s = "abebeaedeac";
        new CountStr().solution(s);
    }

    public int solution(String s) {
        int answer = 0;
        int[] alphabet = new int[26];
        for(char str: s.toCharArray()) {
            int i = str - 'a';
            alphabet[i] = alphabet[i] + 1;
        }

        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] % 2 > 0 && alphabet[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}
