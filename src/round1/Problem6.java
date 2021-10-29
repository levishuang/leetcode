package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/10/29 19:55
 */

public class Problem6 {
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuffer> lists = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            lists.add(new StringBuffer());
        }
        int flag = -1;//行数变化的标志
        int j = 0;
        for(char c:s.toCharArray()){
            if(j == 0 || j == numRows-1){
                flag = -flag;
            }
            lists.get(j).append(c);
            j += flag;
        }
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            result.append(lists.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int num = 4;
        System.out.println(convert(s, num));
    }

}
