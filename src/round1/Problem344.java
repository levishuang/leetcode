package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/8 12:09
 */

public class Problem344 {
    public static void reverseString(char[] s) {
        int low = 0, high = s.length-1;
        while (low <= high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        char[] s = "1234567".toCharArray();
        reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }
}
