package two;

public class 单词搜索 {
    private int cols;
    private int rows;
    private char[][] board;
    private char[] charWord;
    private boolean[][] visited;
    private int length;
    //方向数组
    private int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.charWord = word.toCharArray();
        this.board = board;
        visited = new boolean[rows][cols];
        this.length = word.length();
        //挨个遍历 看看有没有出路 如果有就返回true
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x,int y,int begin){
        if(begin == length - 1){ //遍历到最后一个了
            return board[x][y] == charWord[begin];
        }
        if(board[x][y] == charWord[begin]){ //遍历的这一个是正确的数
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) { //每个方向都进行分支
                int newX = x + direction[0]; //新的遍历的坐标
                int newY = y + direction[1];
                //若此时这个新的坐标没有被访问过 且在表格当中
                if(isInBoard(newX,newY) && !visited[newX][newY]){
                    if(dfs(newX,newY,begin + 1)){
                        return true;
                    }
                }
            }
            //释放此点
            visited[x][y] = false;
        }
        //若此路不通
        return false;
    }

    public boolean isInBoard(int x,int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
