package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/18 16:19
 */

public class Problem733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int origin  = image[sr][sc];
        dfs(image, sr, sc, origin, color, visited);
        return image;
    }
    public static void dfs(int[][] images, int x, int y, int origin, int newColor, boolean[][] visited){
        int m = images.length, n = images[0].length;
        //如果越界
        if(x < 0 || y < 0 || x >= m || y >= n) return;
        //如果不是选定颜色
        if(images[x][y] != origin) return;
        //如果已经访问过
        if(visited[x][y]) return;
        images[x][y] = newColor;
        visited[x][y] = true;
        dfs(images, x-1, y, origin, newColor, visited);//上
        dfs(images, x+1, y, origin, newColor, visited);//下
        dfs(images, x, y-1, origin, newColor, visited);//左
        dfs(images, x, y+1, origin, newColor, visited);//右
    }

    public static void main(String[] args) {
//        int[][] images = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] images = {{0,0,0},{0,0,0}};
        for (int[] ints : floodFill(images, 0, 0, 0)) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }

    }
}
