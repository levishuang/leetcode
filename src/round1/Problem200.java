package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/18 15:14
 */

public class Problem200 {

    public static int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    traverse(grid, i, j);
                }
            }
        }
        return count;

    }

    public static void traverse(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        //越界情况
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        traverse(grid, i - 1, j);
        traverse(grid, i + 1, j);
        traverse(grid, i, j - 1);
        traverse(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] graph = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(graph));
    }
}
