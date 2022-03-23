package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/15 10:38
 */

public class Problem392 {
    public static boolean isSubsequence(String s, String t) {
        int indexS = 0;
        int indexJ = 0;
        while(indexS < s.length() && indexJ < t.length()){
            if(s.charAt(indexS) == t.charAt(indexJ)){
                indexS++;
            }
            indexJ++;

        }
        return indexS == s.length();

    }

    public static void main(String[] args) {
        String s = "agc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

    }
}
