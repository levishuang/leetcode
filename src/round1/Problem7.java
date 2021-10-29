package round1;


import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/10/29 21:08
 */

public class Problem7 {
    public static int reverse(int x) {
        double result = 0;
        int temp = Math.abs(x);
        List<Integer> list = new ArrayList<>();
        while (temp > 0){
            list.add(temp % 10);
            temp /= 10;

        }
        int pow = list.size()-1;
        for (int i = 0; i < list.size() ; i++) {
            result += Math.pow(10, pow) * list.get(i);
            pow--;
        }
        result = x>0?result:-result;
        if(result > Math.pow(2, 31)-1 || result < Math.pow(-2, 31)){
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int a = -1234;
        System.out.println(reverse(a));

    }
}
