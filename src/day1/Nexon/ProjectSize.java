package day1.Nexon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectSize {

    public static void main(String[] args) {
        List<Integer> projectCosts = Arrays.asList(1, 5, 3, 4, 2);
        int target = 2;
        countPairs(projectCosts, target);
    }

    private static int countPairs(List<Integer> projectCosts, int target) {
        int answer = 0;
        Map<Integer, Integer> valueCount = new HashMap<>();

        for (int current : projectCosts) {
            int targetValue1 = current - target;
            int targetValue2 = current + target;

            // 첫 번째 타겟 값(targetValue1)이 맵에 존재하면 해당 값의 개수를 증가시킴
            if (valueCount.containsKey(targetValue1)) {
                answer += valueCount.get(targetValue1);
            }

            // 두 번째 타겟 값(targetValue2)이 맵에 존재하면 해당 값의 개수를 증가시킴
            if (valueCount.containsKey(targetValue2)) {
                answer += valueCount.get(targetValue2);
            }

            // 현재 값의 개수를 맵에 업데이트
            valueCount.put(current, valueCount.getOrDefault(current, 0) + 1);
        }

        return answer;
    }

//        projectCosts.sort(Integer::compareTo);
//
//        for (int i = 0; i < projectCosts.size(); i++) {
//            int current = projectCosts.get(i);
//            int targetValue = current - target;
//            if (projectCosts.contains(targetValue)) {
//                answer++;
//            }

//            for (int j = i + 1; j < projectCosts.size(); j++) {
//                if (Math.abs(projectCosts.get(i) - projectCosts.get(j)) == target) {
//                    answer++;
//                }
//            }
//        }
//        return answer;

//    }

}
