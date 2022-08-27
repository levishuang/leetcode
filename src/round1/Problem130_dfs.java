package round1;



/**
 * @package: round1
 * @Description:先把边界的0进行dfs,换成#， 然后把剩下的换成x, 最后把#复原成0
 * @author: jilai_huang
 * @date: 2022/8/23 20:31
 */

public class Problem130_dfs {
    public static void solve(char[][] board) {
        //边界O的替换
        int m = board.length-1;
        int n = board[0].length-1;
        //第一行遍历
        for(int i = 0; i <= n; i++){
            traverse(board, 0, i);
        }
        //最后一行遍历
        for(int i = 0; i <= n; i++){
            traverse(board, m, i);
        }
        //第一列遍历
        for(int j = 0; j <= m; j++){
            traverse(board, j, 0);
        }
        //最后一列遍历
        for(int j = 0; j<= m; j++){
            traverse(board, j, n);
        }
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void traverse(char[][] board, int x, int y){
        int m = board.length;
        int n = board[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n){
            return;
        }
        if(board[x][y] == '#' || board[x][y] == 'X'){
            return;
        }
        board[x][y] = '#';
        traverse(board, x-1, y);//上
        traverse(board, x+1, y);//下
        traverse(board, x, y-1);//左
        traverse(board, x, y+1);//右
    }

    public static void showBoard(char[][] board){
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                traverse(board, i, j);
//            }
//        }
        solve(board);
        showBoard(board);
    }
}
