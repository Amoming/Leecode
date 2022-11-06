package 剑指offer;

public class 矩阵中的路径12 {
    private static boolean isExist = false;
    private static boolean isWalk[][];
    public static boolean exist(char[][] board, String word) {

        int wordIndex = 0;
        int i = 0;
        int j = 0;
        if(board[i][j] == word.charAt(wordIndex)){
            isWalk = new boolean[board.length][board[0].length];
            isWalk[i][j] = true;
            if(wordIndex+1 == word.length()) isExist = true;
            if(i < board.length - 1 && !isWalk[i+1][j]) walk(board, i + 1, j ,word, wordIndex + 1);
            if(i > 0 && !isWalk[i-1][j]) walk(board,i - 1,j,word,wordIndex+1);
            if(j < board[0].length - 1 && !isWalk[i][j+1]) walk(board, i ,j + 1,word, wordIndex + 1);
            if(j > 0 && !isWalk[i][j-1]) walk(board, i, j - 1, word,wordIndex + 1);
        }

        return isExist;
    }

    public static void walk(char[][] board, int i, int j, String word, int wordIndex){
        if(wordIndex > word.length() - 1) return;
        if(board[i][j] != word.charAt(wordIndex)) return;
        if(board[i][j] == word.charAt(wordIndex) && wordIndex == word.length() - 1) {
            isExist = true;
            return;
        }
        isWalk[i][j] = true;
        if(i < board.length - 1 && !isWalk[i+1][j]) walk(board, i + 1, j ,word, wordIndex + 1);
        if(i > 0 && !isWalk[i-1][j]) walk(board,i - 1,j,word,wordIndex+1);
        if(j < board[0].length - 1 && !isWalk[i][j+1]) walk(board, i ,j + 1,word, wordIndex + 1);
        if(j > 0 && !isWalk[i][j-1]) walk(board, i, j - 1, word,wordIndex + 1);
        isWalk[i][j] = false;//走完后还原
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
