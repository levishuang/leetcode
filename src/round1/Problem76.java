package round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @package: round1
 * @Description:滑动窗口模板
 *
 **滑动窗口算法框架*
 * @author: jilai_huang
 * @date: 2022/6/14 15:59
 */

public class Problem76 {
    public static String minWindow(String s, String t) {
        //初始化要匹配的字符串
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
//        for (Character character : need.keySet()) {
//            System.out.println(character + "：" + need.get(character));
//        }
        //标注滑动窗口的左右侧
        int left = 0, right = 0;
        int valid = 0;
        //记录最小子串的起始和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //取最右侧的字符
            char temp = s.charAt(right);
            right++;
            if (need.containsKey(temp)) {
                windows.put(temp, windows.getOrDefault(temp, 0) + 1);
                if (windows.get(temp).equals(need.get(temp))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
//        System.out.println(left);

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }
}

//    void slidingWindow(string s, string t) {
//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
//        for (char c : t.toCharArray())
//            need.put(c, need.getOrDefault(c, 0) + 1);
//        int left = 0, right = 0;
//        int valid = 0;
//        while (right < s.size()) {
//            // c 是将移入窗口的字符
//            char c = s.charAt(right);
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//    	...
//
//            /*** debug 输出的位置 ***/
//            System.out.println("window: [" + left + "," + right + ")");
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink){
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//        	...
//            }
//        }
//    }
