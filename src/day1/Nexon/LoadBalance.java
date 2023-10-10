package day1.Nexon;

import java.util.*;

public class LoadBalance {
    public static void main(String[] args) {
        int n = 4;
        List<Integer> arrival = List.of(3, 5, 1, 6, 8);
        List<Integer> burstTime = List.of(9, 2, 10, 4, 5);
        getServerIndex(n, arrival, burstTime);
    }

    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> availableServers = new LinkedList<>();
        List<Request> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            availableServers.offer(i);
        }

        for (int i = 0; i < arrival.size(); i++) {
            while (!requests.isEmpty() && requests.get(0).completionTime <= arrival.get(i)) {
                Request completedRequest = requests.remove(0);
                availableServers.offer(completedRequest.serverIndex);
            }

            if (availableServers.isEmpty()) {
                result.add(-1);
            } else {
                int serverIndex = availableServers.poll();
                result.add(serverIndex);
                int completionTime = arrival.get(i) + burstTime.get(i);
                requests.add(new Request(serverIndex, completionTime));
            }
        }

        return result;
    }

    static class Request {
        int serverIndex;
        int completionTime;

        public Request(int serverIndex, int completionTime) {
            this.serverIndex = serverIndex;
            this.completionTime = completionTime;
        }
    }

}
