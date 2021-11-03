package round1;

public class Problem5 {
    public static boolean isPalindrome(String s){
        int low = 0;
        int high = s.length();
        boolean result = true;
        while(low <= high){
            if(s.substring(low, low+1).equals(s.substring(high-1, high))){
                low++;
                high--;
            }else {
                result = false;
                break;
            }
        }
        return result;
    }
    public static String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int len = s.length();
        String temp = null;
        String result = null;
        int sub_len = 0;
        for(int i = 0; i <= len-1; i++){
            for(int j = i+1; j <= len; j++){
                temp = s.substring(i, j);
                if(isPalindrome(temp) && temp.length() > sub_len){
                    result = temp;
                    sub_len = result.length();
                }
            }
        }
        return result;
    }

    public String longestPalindrome1(String s) {
//        先弄一个非法判断
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = len1 > len2 ? len1 : len2;
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);


    }


    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }
}
