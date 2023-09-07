package Nexon;

import java.util.*;

public class GetRequestStatus {
    public static void main(String[] args) {

        List<String> requestUrl = Arrays.asList("www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com",
                "www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com",
                "www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com",
                "www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com",
                "www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com");
        getRequestStatus(requestUrl);

    }

    public static List<String> getRequestStatus(List<String> requests) {
        // Write your code here
        System.out.print(requests);
        List<String> results = new ArrayList<>();
        Map<String, Queue<Integer>> requestQueue = new HashMap<>();
        int sec = 0;
        // 요청 URL을 순회하면서 각 URL의 요청을 관리
        for (String url : requests) {
            // 도메인별로 요청 큐 생성 또는 가져오기
            Queue<Integer> queue = requestQueue.getOrDefault(url, new LinkedList<>());

            // 30초 이상 경과한 요청 정보 제거
            while (!queue.isEmpty() && sec - queue.peek() >= 30) {
                queue.poll();
            }

            // 5초 이상 경과한 요청 정보 초기화
            while (!queue.isEmpty() && sec - queue.peek() >= 5) {
                queue.poll();
            }

            sec++;
            // 5초 내에 최대 2개의 요청 허용
            if (queue.size() < 2) {
                queue.add(sec);
                requestQueue.put(url, queue);
                results.add("{status: 200, message: OK}");
            } else {
                results.add("{status: 429, message: Too many requests}");
            }
        }
        return results;
    }
}
