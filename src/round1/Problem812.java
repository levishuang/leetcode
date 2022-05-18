package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/15 15:52
 */

public class Problem812 {
    public static double largestTriangleArea(int[][] points) {
        double res = 0;
        int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    res = Math.max(res, computeTriangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return res;
    }

    public static double computeTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3);
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1}, {1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
