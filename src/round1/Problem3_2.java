package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/8 12:23
 */

public class Problem3_2 {
    public static String isPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }else {
                break;
            }
        }
        return s.substring(low + 1, high);
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数字符串
            String s1 = isPalindrome(s, i, i);
            //偶数字符串
            String s2 = isPalindrome(s, i, i + 1);
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "babab";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
