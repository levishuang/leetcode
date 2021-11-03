package round1;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/11/3 15:14
 * @Author: Jilai Huang
 */
public class Problem13 {
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0 ; i < chars.length; i++){
            switch (chars[i]){
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    sum += 1;
                    break;
                default:
                    break;
            }
        }
        for(int i = 0 ; i < chars.length-1; i++){
//            if(i == chars.length-1) break;
            if(chars[i] == 'C' && chars[i+1] == 'M' || chars[i] == 'C' && chars[i+1] == 'D'){
                sum -= 200;
            }
            if(chars[i] == 'X' && chars[i+1] == 'L' || chars[i] == 'X' && chars[i+1] == 'C'){
                sum -= 20;
            }
            if(chars[i] == 'I' && chars[i+1] == 'V' || chars[i] == 'I' && chars[i+1] == 'X'){
                sum -= 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }
}
