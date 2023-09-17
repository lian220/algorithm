package ohouse;

public class TextWordShake {
    public static void main(String[] args) {
        new TextWordShake().solution(new String[][]{{"O", "A", "C", "D", "E", "O"},
                {"H", "O", "T", "C", "A", "P"},
                {"P", "U", "S", "E", "T", "Z"}},
                "OHOUSE");
    }

    public boolean solution(String[][] board, String word) {
        boolean answer = false;
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (answer) break;
            for (int j = 0; j < board[0].length; j++) {
                if (answer) break;
                if (board[i][j].equals(word.substring(0, 1))) {
                    answer = dfs(board, visited, i, j, word, 0);
                }
            }
        }
        return answer;
    }

    private boolean dfs(String[][] board, int[][] visited, int i, int j, String word, int i1) {
        if (i1 == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (visited[i][j] == 1) return false;
        if (!board[i][j].equals(word.substring(i1, i1 + 1))) return false;
        visited[i][j] = 1;
        boolean answer = dfs(board, visited, i + 1, j, word, i1 + 1) ||
                dfs(board, visited, i - 1, j, word, i1 + 1) ||
                dfs(board, visited, i, j + 1, word, i1 + 1) ||
                dfs(board, visited, i, j - 1, word, i1 + 1);
        visited[i][j] = 0;
        return answer;
    }
}
