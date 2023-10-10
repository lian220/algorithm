package day1.lguPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteDuplicate {
    public static void main(String[] args) {
//        String interview = "abcabcdefABC";
//        String interview = "abxdeydeabz";
//        String interview = "abcabca";
        String interview = "ABCabcA";

        new DeleteDuplicate().solution(interview);
    }

    public String solution(String interview) {
        // 문자 데이터를 구성하는 단어를 저장할 리스트입니다.
        List<String> words = new ArrayList<>();
        for (int i = 0; i < interview.length(); i++) {
            if (i == 0 || interview.charAt(i - 1) != interview.charAt(i)) {
                words.add(String.valueOf(interview.charAt(i)));
            }
        }

        // 단어의 등장 횟수를 저장할 맵입니다.
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // 가장 많이 등장한 패턴을 저장할 리스트입니다.
        List<String> mostFrequentPatterns = new ArrayList<>();
        int maxCount = 0;
        for (String word : wordCountMap.keySet()) {
            if (wordCountMap.get(word) > maxCount) {
                maxCount = wordCountMap.get(word);
                mostFrequentPatterns.clear();
                mostFrequentPatterns.add(word);
            } else if (wordCountMap.get(word) == maxCount) {
                mostFrequentPatterns.add(word);
            }
        }

        // 가장 많이 등장한 패턴을 모두 삭제합니다.
        for (String pattern : mostFrequentPatterns) {
            interview = interview.replaceAll(pattern.toLowerCase(), "");
            interview = interview.replaceAll(pattern.toUpperCase(), "");
        }

        return interview;

    }
}
