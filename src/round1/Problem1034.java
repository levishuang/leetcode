package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/18 16:42
 */

public class Problem1034 {
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        //标记访问的矩阵
        boolean[][] visited = new boolean[m][n];
        int origin = grid[row][col];
        dfs(grid, row, col, origin, color, visited);
        return grid;
    }

    public static int dfs(int[][] grid, int row, int col, int origin, int color, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        //越界
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return 0;
        }
        //访问过了
        //先来看是否访问过了，如果访问过来的话颜色就已经改变
        if (visited[row][col]) {
            return 1;
        }
        //不是原来的颜色
        if (grid[row][col] != origin) {
            return 0;
        }
        //最后都符合条件后再进行颜色的改变，否则干扰上面的判断
        visited[row][col] = true;
        int fill = dfs(grid, row - 1, col, origin, color, visited)
                + dfs(grid, row + 1, col, origin, color, visited)
                + dfs(grid, row, col - 1, origin, color, visited)
                + dfs(grid, row, col + 1, origin, color, visited);
        if (fill < 4) {
            grid[row][col] = color;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        for (int[] ints : colorBorder(grid, 1, 1, 2)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }
}
