package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/11/3 12:00
 * @Author: Jilai Huang
 */
public class Problem12 {
    public static String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < nums.length; i++){
            while (num-nums[i] >= 0){
                stringBuffer.append(strs[i]);
                num -= nums[i];
            }
            if(num == 0){
                break;
            }
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
