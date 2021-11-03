package round1;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/11/3 15:36
 * @Author: Jilai Huang
 */
public class Problem14 {
    public static String longestCommonPrefix1(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = minLen > strs[i].length() ? strs[i].length() : minLen;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < minLen; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[0].substring(i, i + 1).equals(strs[j].substring(i, i + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuffer.append(strs[0].substring(i, i + 1));
            } else {
                break;
            }
        }
        return stringBuffer.toString();
    }
    //这个题解有bug
    public static String longestCommonPrefix2(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
           minLen = Math.min(minLen, strs[i].length());
        }
        String s = strs[0];
        int len = 0;
        while(len < minLen){
            for(int i = 1; i < strs.length; i++){
                if(!s.substring(len, len+1).equals(strs[i].substring(len, len+1))){
                    return s.substring(0, len);
                }
            }
            len++;
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(s));
    }
}
