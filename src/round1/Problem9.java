package round1;

/**
 * @package: round1
 * @Description:回文数
 * @author: jilai_huang
 * @date: 2021/11/1 22:27
 */

public class Problem9 {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        char[] num = Integer.toString(x).toCharArray();
        int low = 0;
        int high = num.length-1;
        while(low <= high){
            if(num[low] != num[high]){
                return false;
            }else {
                low++;
                high--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int s = 1221;
        System.out.println(isPalindrome(s));
    }
}
