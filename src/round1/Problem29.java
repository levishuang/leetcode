package round1;

/**
 * @package: round1
 * @Description:整数除法
 * @author: jilai_huang
 * @date: 2021/12/13 21:10
 */

public class Problem29 {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        //符号
        int op = dividend > 0 ? 1 : -1;
        op = divisor > 0 ? op : -op;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int count = 0;
        while(dividend-divisor <= 0){
            dividend-=divisor;
            count++;
        }
        return count*op;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, -3));
    }
}
