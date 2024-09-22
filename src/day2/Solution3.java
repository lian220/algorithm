package day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {

  // 패턴에 기반하여 가능한 숫자들을 생성하는 함수
  private static List<String> generatePossibleNumbers(String pattern) {
    List<String> possibleNumbers = new ArrayList<>();
    generateCombinations(pattern, 0, new StringBuilder(), possibleNumbers);
    return possibleNumbers;
  }

  // 재귀적으로 조합을 생성하는 함수
  private static void generateCombinations(String pattern, int index, StringBuilder current, List<String> result) {
    if (index == pattern.length()) {
      result.add(current.toString());
      return;
    }

    char ch = pattern.charAt(index);
    if (ch == 'X') {
      for (char digit = '0'; digit <= '9'; digit++) {
        current.append(digit);
        generateCombinations(pattern, index + 1, current, result);
        current.deleteCharAt(current.length() - 1); // 백트래킹
      }
    } else {
      current.append(ch);
      generateCombinations(pattern, index + 1, current, result);
      current.deleteCharAt(current.length() - 1); // 백트래킹
    }
  }

  // existNumbers에 이미 존재하는 숫자들을 필터링하는 함수
  private static String[] filterNumbers(List<String> possibleNumbers, Set<String> existingNumbers) {
    List<String> result = new ArrayList<>();
    for (String number : possibleNumbers) {
      if (!existingNumbers.contains(number)) {
        result.add(number);
      }
    }
    if(result.isEmpty()) {
      result.add("-1");
    }
    return result.toArray(new String[0]);
  }

  public static void main(String[] args) {
    String hopeNumber = "123-4XX";
    String[] existNumbers = {
        "123-XX0", "XXX-4X1", "123-4X2", "123-4X3", "123-4X4", "123-4X5",
        "123-4X7", "123-4X8", "123-4X9", "123-456", "XXX-X9X"
    };
    solution(hopeNumber, existNumbers);

  }

  public static String[] solution(String hope_number, String[] exist_number) {
    String[] answer = {};
    List<String> possibleNumbers = generatePossibleNumbers(hope_number);

    // 존재하는 숫자들을 집합으로 추출
    Set<String> existingNumberSet = new HashSet<>();
    for (String num : exist_number) {
      // 각 기존 패턴에 대해 가능한 모든 숫자들을 생성해야 함
      List<String> generatedExistingNumbers = generatePossibleNumbers(num);
      existingNumberSet.addAll(generatedExistingNumbers);
    }

    // exist_numbers에 이미 있는 숫자들을 필터링
    answer = filterNumbers(possibleNumbers, existingNumberSet);
    System.out.println("exist_numbers에 없는 가능한 숫자들: " + answer);
    return answer;
  }
}
