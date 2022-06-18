package round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/18 17:09
 */

public class Problem567 {
    public static boolean checkInclusion(String s1, String s2) {
        //记录需要匹配字符串的字符状况
        Map<Character, Integer> need  = new HashMap<>();
        //记录窗口情况
        Map<Character, Integer> window = new HashMap<>();
        //窗口的左侧和右侧
        int left = 0, right = 0;
        //记录匹配的字符个数
        int valid = 0;
        for(char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s2.length()){
            //窗口扩大
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //窗口缩小
            while (right-left >= s1.length()){
                if(valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1, s2));
    }

}
