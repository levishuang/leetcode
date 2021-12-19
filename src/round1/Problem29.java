package round1;

/**
 * @package: round1
 * @Description:整数除法
 * @author: jilai_huang
 * @date: 2021/12/13 21:10
 */

public class Problem29 {
    //将除法转换为减法
    public static int divide1(int dividend, int divisor) {
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
        while (dividend - divisor <= 0) {
            dividend -= divisor;
            count++;
        }
        return count * op;
    }
    /**使用倍乘法来计算两数的商，简单理解就是每次用被除数减去[除数与最大的2^x的乘积]，这样可以极大地增加处理的速度。
     * 比如，假定被除数为 20，除数为 3，使用倍乘法的过程如下：
     *  计算 3 的 2^x的最大值（不超过 20），为 3 * 2^2 = 12，拿 20 - 122得到 8，做为新的被除数。
     *  计算 3 的 2^x的最大值（不超过 8），为 3 * 2^1 = 6，拿 8 - 6得到 2，做为新的被除数。
     *  判断新的被除数 2 小于 3 了，退出计算过程，最后的结果就是 2^2 + 2^1 = 6
      * @param dividend 被除数
     * @param divisor  除数
     * @return 商
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        //运算符号判断
        int opt = dividend > 0 ? 1 : -1;
        opt = divisor > 0 ? opt : -opt;
        //将数全部转换到负数的范围
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }
        int ans = 0;
        while(dividend <= divisor){
            int temp = divisor;
            int count = 1;
            while(temp >= dividend - temp){
                temp +=temp;
                count+=count;
            }
            dividend-=temp;
            ans += count;
        }
        return ans*opt;
    }

    public static void main(String[] args) {
        System.out.println(divide(100, -3));
    }
}
