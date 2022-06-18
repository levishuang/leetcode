package round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/18 19:47
 */

public class Problem3_3 {
    public static int lengthOfLongestSubstring(String s) {
        int max_len = 0;
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        //窗口扩大
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            //进行缩小
            while (windows.get(c) > 1){
                char d = s.charAt(left);
                left++;
                windows.put(d, windows.get(d)-1);
            }
            max_len = max_len > (right-left) ? max_len : (right-left);
        }
        return max_len;
    }

    public static void main(String[] args) {
//        String s = "dvdf";
        String s = "bbbbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }
}
