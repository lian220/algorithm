package day1.hacto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        int[] stats1 = {6, 2, 3, 4, 1, 5};
        System.out.println(solution(stats1));
    }

    public static int solution(int[] stats) {
        List<List<Integer>> teams = new ArrayList<>();
        teams.add(new ArrayList<>());
        teams.get(0).add(stats[0]);
        for (int i = 1; i < stats.length; i++) {
            boolean assigned = false;
            int player = stats[i];

            // 모든 팀을 확인하며 배정 가능한 팀을 찾음
            for (List<Integer> team : teams) {
                int maxRating = getMaxRating(team, player);

                if (player == maxRating) {
                    team.add(player);
                    assigned = true;
                    break;
                }
            }

            // 배정 가능한 팀이 없다면 새로운 팀을 생성하여 플레이어를 추가
            if (!assigned) {
                List<Integer> newTeam = new ArrayList<>();
                newTeam.add(player);
                teams.add(newTeam);
            }
        }

        return teams.size(); // 생성된 팀의 수를 반환
    }

    private static int getMaxRating(List<Integer> team, int player) {
        int maxRating = 0;
        for (int member : team) {
            maxRating = Math.max(maxRating, member);
        }
        maxRating = Math.max(maxRating, player);
        return maxRating;
    }


//    public static int solution(int[] stats) {
//        List<Integer> maxRatings = new ArrayList<>();
//        maxRatings.add(stats[0]);
//
//        for (int i = 1; i < stats.length; i++) {
//            int player = stats[i];
//
//            int teamIndex = findTeamIndex(maxRatings, player);
//
//            if (teamIndex == -1) {
//                maxRatings.add(player);
//            } else {
//                maxRatings.set(teamIndex, player);
//            }
//        }
//
//        return maxRatings.size(); // 생성된 팀의 수를 반환
//    }
//
//    private static int findTeamIndex(List<Integer> maxRatings, int player) {
//        int left = 0;
//        int right = maxRatings.size() - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (maxRatings.get(mid) == player) {
//                return mid; // 이미 있는 팀에 배정
//            } else if (maxRatings.get(mid) < player) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1; // 새로운 팀 생성
//    }



}
