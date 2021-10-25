package round1;

public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        if(null == s) return  0 ;
        int max = 0;
        for(int i = 0; i < s.length()-1; i++){
            int count = 1;
            StringBuffer sub = new StringBuffer(s.substring(i, i+1));
            for(int j = i+1; j < s.length(); j++){
                String sub2 = s.substring(j, j+1);
                if(!sub.toString().contains(sub2)){
                    count++;
                    sub.append(sub2);
                }else {
                    max = max > count ? max:count;
                    break;
                }
            }
            max = max > count ? max:count;
        }
        return max;
    }
    public static void main(String[] args){
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(s.length());
    }

}
