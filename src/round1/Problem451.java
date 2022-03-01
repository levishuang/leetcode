package round1;

import java.util.*;

/**
 * @package: round1
 * @Description:本质也是桶排序
 * @author: jilai_huang
 * @date: 2022/2/28 21:00
 */

public class Problem451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        System.out.println(map);
        List<Character>[] lists = new ArrayList[s.length()+1];
        for(Character c : map.keySet()){
            int frequency = map.get(c);
            if(lists[frequency] == null){
                lists[frequency] = new ArrayList<>();
            }
            lists[frequency].add(c);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = s.length(); i >= 0; i--){
            if(lists[i] == null){
                continue;
            }else {
                for(int k = 0; k < lists[i].size(); k++){
                    char temp = lists[i].get(k);
                    for(int j = 0; j < i; j++){
                        stringBuffer.append(temp);
                    }

                }
            }
        }
//        System.out.println(map);
        return stringBuffer.toString();

    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
