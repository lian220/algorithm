package day2;

import java.util.*;

public class Solution {
  public int solution(String[] receivers, String[][] employees) {
    Map<String, String> employeeToTeam = new HashMap<>();  // 사원의 이름을 팀으로 매핑
    Map<String, Set<String>> teamToEmployees = new HashMap<>();  // 팀별 사원 목록
    Set<String> receiverSet = new HashSet<>(Arrays.asList(receivers));  // 수신자 집합
    Set<String> teamsToConsider = new HashSet<>();  // 처리할 팀 목록

    // 사원과 팀 정보를 매핑
    for (String[] employee : employees) {
      String name = employee[0];
      String team = employee[1];
      employeeToTeam.put(name, team);
      teamToEmployees.putIfAbsent(team, new HashSet<>());
      teamToEmployees.get(team).add(name);

      // 수신자에 해당하는 사원만 팀 처리 목록에 추가
      if (receiverSet.contains(name)) {
        teamsToConsider.add(team);
      }
    }

    int answer = 0;  // 시간 초기화
    Set<String> currentReceivers = new HashSet<>();  // 현재 수신자 목록

    // 처리해야 할 팀만 순회
    for (String team : teamsToConsider) {
      Set<String> teamMembers = teamToEmployees.get(team);
      Set<String> neededReceivers = new HashSet<>();
      Set<String> unnecessaryReceivers = new HashSet<>();

      // 해당 팀의 사원들을 분류 (필요한 수신자 vs 불필요한 수신자)
      for (String member : teamMembers) {
        if (receiverSet.contains(member)) {
          neededReceivers.add(member);  // 필요한 수신자
        } else {
          unnecessaryReceivers.add(member);  // 불필요한 수신자
        }
      }

      // 팀 전체 추가 vs 필요한 수신자만 개별 추가 중 선택
      if (!neededReceivers.isEmpty()) {
        if (neededReceivers.size() > unnecessaryReceivers.size()) {
          // 팀 전체 추가하고 불필요한 사원 제거
          currentReceivers.addAll(teamMembers);
          answer++;

          // 불필요한 사원 제거 최적화
          for (String unnecessary : unnecessaryReceivers) {
            if (currentReceivers.contains(unnecessary)) {
              currentReceivers.remove(unnecessary);
              answer++;
            }
          }
        } else {
          // 필요한 수신자만 개별적으로 추가
          for (String receiver : neededReceivers) {
            if (!currentReceivers.contains(receiver)) {
              currentReceivers.add(receiver);
              answer++;
            }
          }
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    // 예시 1
    String[] receivers1 = {"George", "jin", "david"};
    String[][] employees1 = {{"George", "it"}, {"jin", "it"}, {"david", "security"}, {"thomas", "security"}};
    System.out.println(sol.solution(receivers1, employees1));  // 2

    // 예시 2
    String[] receivers2 = {"George", "jin", "david", "thomas", "isla"};
    String[][] employees2 = {{"George", "it"}, {"jin", "it"}, {"david", "security"}, {"thomas", "security"}, {"isla", "it"}, {"ava", "it"}, {"evans", "security"}};
    System.out.println(sol.solution(receivers2, employees2));  // 4
  }
}



