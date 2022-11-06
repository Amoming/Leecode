package one;

public class 有效数独 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int locate = (i / 3) * 3 + j / 3;
                    if(rows[i][num] || cols[num][j] || boxs[locate][num]){
                        return false;
                    }else {
                        rows[i][num] = true;
                        cols[num][j] = true;
                        boxs[locate][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
