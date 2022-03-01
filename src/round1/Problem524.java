package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/24 20:02
 */

public class Problem524 {
    public static String findLongestWord(String s, List<String> dictionary) {
        int len = dictionary.size();
        Collections.sort(dictionary);
        int max_count = -1;
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            String str = dictionary.get(i);
            int len_s = s.length();
            int len_str = str.length();
            int j = 0, k=0;
            while(j < len_str && k < len_s){
                if(str.charAt(j) != s.charAt(k)){
                    k++;
                }else {
                    k++;
                    j++;
                }
            }
            if(j == len_str) {
                nums[i] = j;
//                System.out.println(j);
                if (max_count < j) {
                    max_count = j;
//                    System.out.println("*" + max_count);
                }
            }
        }
        for(int l = 0; l < len; l++){
            if(nums[l] == max_count){
                return dictionary.get(l);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("apple");
        dictionary.add("ale");
        dictionary.add("monkey");
        dictionary.add("plea");
        dictionary.add("abpcplaaa");
        dictionary.add("abpcllllll");
        dictionary.add("abccclllpppeeaaaa");
        System.out.println(findLongestWord(s, dictionary));
    }
}
