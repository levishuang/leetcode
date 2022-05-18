package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/16 10:23
 */

public class Problem304 {
    private int[][] prematrix;

    public Problem304(int[][] matrix) {
        //存储前缀和，行数+1，列数+1
        prematrix = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1; i < matrix.length+1; i++){
            for(int j = 1; j < matrix[0].length+1; j++){
                prematrix[i][j] = prematrix[i][j-1] + prematrix[i-1][j]+matrix[i-1][j-1]- prematrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prematrix[row2+1][col2+1] - prematrix[row1][col2+1] - prematrix[row2+1][col1] + prematrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        Problem304 obj = new Problem304(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }
}
