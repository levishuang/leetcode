package round1;

/**
 * @package: round1
 * @Description:给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jilai_huang
 * @date: 2021/12/13 20:12
 */

public class Problem28 {
    public static int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        if(needle.equals("")){
            return 0;
        }
        int len1 = haystack.length();
        char array1[] = haystack.toCharArray();
        int len2 = needle.length();
        char array2[] = needle.toCharArray();
        //记录当前needle字符串的位置
        int index = 0;
        for(int i = 0; i < len1; ){
            if(array1[i] != array2[index]){
                i = i -index +1;
                index = 0;
                continue;
            }else {
                if(index < len2){
                    index++;
                    i++;
                }
            }
            if(index == len2){
                return i-index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(strStr(s1, s2));

    }
}
