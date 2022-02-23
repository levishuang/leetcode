package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/23 15:14
 */

public class Problem680 {
    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        if(validLeft(i, j, s) || validRight(i, j, s)){
            return true;
        }else {
            return false;
        }
    }
    public static boolean validLeft(int i, int j, String s){
        int num = 0;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                num++;
                i++;
            }
            if(num >= 2) return false;
        }
        return true;
    }
    public static boolean validRight(int i, int j, String s){
        int num = 0;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                num++;
                j--;
            }
            if(num >= 2) return false;
        }
        return true;
    }

    public static boolean validPalindromePro(String s){
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return isPalidrome(i+1, j, s) || isPalidrome(i, j-1, s);
            }
        }
        return true;
    }
    //检查子串是否为回文字符串
    public static boolean isPalidrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acabbac";
        System.out.println(validPalindromePro(s));
    }
}
