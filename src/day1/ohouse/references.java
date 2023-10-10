package day1.ohouse;

public class references {
    public static void main(String[] args) {
        int[] references = {1, 3, 1};
        solution(references);
    }

    private static int solution(int[] references) {
        int answer = 0;
        //속도 개느림.... 고치자
        isSertionSort(references);
        int n = references.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 현재 중간값을 기준으로 h-index를 계산
            int hIndex = n - mid;

            // 현재 중간값과 h-index를 비교하여 이진 검색 수행
            if (references[mid] == hIndex) {
                return hIndex;
            } else if (references[mid] < hIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        answer = n - left;
        return answer;

    }

    private static int[] isSertionSort(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = i; j > 0; j--) {
                if (answer[j] < answer[j - 1]) {
                    int temp = answer[j];
                    answer[j] = answer[j - 1];
                    answer[j - 1] = temp;
                }
            }
        }
        return answer;
    }
}
