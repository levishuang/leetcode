package round1;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/18 19:28
 */

public class Problem438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //窗口的扩大
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //窗口的缩小
            while(right - left >= p.length()){
                if(valid == need.size()){
                    ans.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(windows.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

}
