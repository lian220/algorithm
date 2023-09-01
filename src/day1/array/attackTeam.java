package day1.array;

public class attackTeam {
    public static void main(String[] args) {
        solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24",  "a 25", "b 12"});
    }

    public static int[] solution(String[] students) {
        int[] answer = new int[students.length];
        int studentCnt = students.length;
        for (int i=0;i< studentCnt; i++) {
            int studentWinScore = 0;
            int scoreX = getScore(students[i]);
            String teamX = getTeam(students[i]);
            for (int j=0; j< studentCnt; j++) {
                if(i != j) {
                    int scoreJ = getScore(students[j]);
                    String teamJ = getTeam(students[j]);
                    if(scoreX > scoreJ && !teamX.equals(teamJ)) {
                        studentWinScore += scoreJ;
                    }
                }
            }
            answer[i] = studentWinScore;
        }

        return answer;
    }

    private static String getTeam(String student) {
        String[] splitScore = student.split(" ");
        return splitScore[0];
    }

    public static int getScore(String student) {
        String[] splitScore = student.split(" ");
        return Integer.parseInt(splitScore[1]);
    }
}
