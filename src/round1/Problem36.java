package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/17 16:48
 */

public class Problem36 {
    //判断行或列是否有效
    public boolean isValidColumnOrRow(char[] column) {
        for (int i = 0; i < column.length; i++) {
            if(column[i] == '.'){
                continue;
            }
            for (int j = i; j < column.length; j++) {
                if(column[j] == '.'){
                    continue;
                }
                if (i == j) {
                    continue;
                } else {
                    if (column[i] == column[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //判断传入数据所在的3*3的矩阵大小是否符合条件 row->行 column->列
    public boolean isValidSubMatrix(char[][] board, int row, int column) {
        //根据输入的坐标找到子矩阵的左上角坐标
        int matrixRow = (row / 3) * 3;
        int matrixColumn = (column / 3) * 3;
        List<Character> list = new ArrayList<>();
        for (int i = matrixRow; i < matrixRow + 3; i++) {
            for (int j = matrixColumn; j < matrixColumn + 3; j++) {
                if (board[i][j] != '.') {
                    if (list.contains(board[i][j])) {
                        return false;
                    } else {
                        list.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        //判断行数是否符合条件
        for (int i = 0; i < board.length; i++) {
            if (!isValidColumnOrRow(board[i])) {
                return false;
            }
        }
        char temp[] = new char[9];
        //判断列数是否符合条件
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                temp[j] = board[j][i];
            }
            if (!isValidColumnOrRow(temp)) {
                return false;
            }
        }
        //判断所在3*3矩阵是否符合条件
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if(!isValidSubMatrix(board,i,j)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.contains(1));
    }
}
