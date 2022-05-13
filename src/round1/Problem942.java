package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/10 21:29
 */

public class Problem942 {
    //使用数组来保存待处理的数字
    public static int[] diStringMatch1(String s) {
        int len = s.length()+1;
        int[] nums = new int[len];
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = -1;
        }
        //遍历字符串的每个字符
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                //遍历存储数字的数组，并标记(从小到大)
                for(int j = 0; j < len; j++){
                    if(nums[j] == -1){
                        ans[i] = j;
                        //1表示已经使用过
                        nums[j] = 1;
                        break;
                    }
                }
            }
            if(s.charAt(i) == 'D'){
                //从大到小
                for(int j = len-1; j >=0; j--){
                    if(nums[j] == -1){
                        ans[i] = j;
                        //1表示已经使用过
                        nums[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] == -1){
                ans[len-1] = i;
            }
        }
        return ans;
    }
    //贪心算法
    public static int[] diStringMatch(String s){
        int len =s.length();
        int low = 0, high = len;
        int[] ans = new int[len+1];
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == 'I'){
                ans[i] = low++;
            }
            if(s.charAt(i) == 'D'){
                ans[i] = high--;
            }
        }
        ans[len] = low;
        return ans;

    }

    public static void main(String[] args) {
        String s = "DDI";
        int[] ints = diStringMatch(s);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
