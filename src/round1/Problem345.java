package round1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @package: round1
 * @Description:反转字符串中的元音位置
 * @author: jilai_huang
 * @date: 2022/2/23 14:18
 */
//代码一定要优雅
public class Problem345 {
    public static String reverseVowels(String s) {
        char[] arrays = s.toCharArray();
        int i = 0;
        int j = arrays.length-1;
        while(i < j){
            if(isVowel(arrays[i]) && isVowel(arrays[j])){ //两个均为元音
                char temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
                i++;
                j--;
            }else if(isVowel(arrays[i]) && (!isVowel(arrays[j]))){ //低位为元音，高位不为元音
                j--;
            }else if(isVowel(arrays[j]) && (!isVowel(arrays[i]))){ //低位不为元音高位为元音
                i++;
            }else{
                i++;
                j--;
            }
        }
        return new String(arrays);

    }
    public static boolean isVowel(char temp){
        if(temp == 'a' || temp == 'e' ||temp == 'i' ||temp == 'o' ||temp == 'u' ||temp == 'A' ||temp == 'E' ||temp == 'I' ||temp == 'O' || temp == 'U'){
            return true;
        }else {
            return false;
        }
    }

    public static String reverseVowelsPro(String s){
        char[] result = new char[s.length()];
        int i = 0,j = s.length()-1;
        while(i <= j){
            char l = s.charAt(i);
            char h = s.charAt(j);
            if(!vowels.contains(l)){
                result[i++] = l;
            }else if(!vowels.contains(h)){
                result[j--] = h;
            }else{
                result[i++] = h;
                result[j--] = l;
            }
        }
        return new String(result);
    }
    private static final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i','o','u','A','E','I','O','U'));


    public static void main(String[] args) {
        String s = "leetcode";
        String temp = reverseVowelsPro(s);
        System.out.println(temp);
    }

}
