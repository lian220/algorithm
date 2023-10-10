package day1.koreaPreCard;

import java.util.Scanner;

public class FindPasswordPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 다음 줄로 넘어감

        String pattern = scanner.nextLine();
        String[] candidates = new String[M];

        for (int i = 0; i < M; i++) {
            candidates[i] = scanner.nextLine();
        }

        String result = findPasswordPattern(pattern, candidates);
        System.out.println(result);
    }

    public static String findPasswordPattern(String pattern, String[] candidates) {
        return dfs(0, pattern, candidates);
    }

    private static String dfs(int index, String currentPassword, String[] candidates) {
        if (index == currentPassword.length()) {
            return currentPassword;
        }

        for (String candidate : candidates) {
            if (candidate.length() != currentPassword.length() - index) {
                continue;
            }

            boolean valid = true;
            StringBuilder newPasswordBuilder = new StringBuilder(currentPassword);

            for (int i = 0; i < candidate.length(); i++) {
                if (currentPassword.charAt(index + i) == '?') {
                    newPasswordBuilder.setCharAt(index + i, candidate.charAt(i));
                } else if (currentPassword.charAt(index + i) != candidate.charAt(i)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                String result = dfs(index + candidate.length(), newPasswordBuilder.toString(), candidates);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }
}

