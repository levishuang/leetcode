package round1;
import java.lang.Math;
/**
 * @package: round1
 * @Description:注意数据溢出的问题
 * @author: jilai_huang
 * @date: 2022/2/22 21:26
 */

public class Problem633 {
    public static boolean judgeSquareSum(int c) {
        boolean answer = false;
        int i = 0;
        long j = (int)Math.sqrt(c);
        while (i <= j){
            long sum = i*i + j*j;
            if(sum == c){
                answer = true;
                break;
            }else if(sum < c){
                i++;
            }else {
                j--;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        boolean ans = judgeSquareSum(2147483600);
        System.out.println(ans);
    }
}
