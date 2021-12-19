package round1;

import javax.jnlp.ClipboardService;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @package: round1
 * @Description:给定一个正整数 n ，输出外观数列的第 n 项。
 * @author: jilai_huang
 * @date: 2021/12/19 13:54
 */

public class Problem38 {


    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String temp = countAndSay(n-1);
        char[] nums = temp.toCharArray();
//        Deque<Integer> deque = new ArrayDeque<>();
//        while(n > 0){
//            deque.push(n%10);
//            n = n/10;
//        }
//        //将数字变为数组
//        int[] nums = new int[deque.size()];
//        for(int i = 0; i < nums.length; i++){
//            nums[i] = deque.pop();
////            System.out.println(nums[i]);
//        }
        StringBuffer stringBuffer = new StringBuffer();
        int count = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                stringBuffer.append(count);
                stringBuffer.append(nums[i]);
                count = 1;
            }else {
                count++;
            }
        }
        stringBuffer.append(count);
        stringBuffer.append(nums[nums.length-1]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
