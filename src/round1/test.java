package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/11/10 16:53
 */

public class test {
    List<String> res = new ArrayList<>();
    String[] strs ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuffer letter = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        iterator(digits, letter, 0);
        return res;
    }
    public void iterator(String digits, StringBuffer letter, int index){
        if(index == digits.length()){
            res.add(letter.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = strs[c-'0'];
        for(int i = 0; i < s.length(); i++){
            letter.append(s.charAt(i));
            iterator(digits, letter, index+1);
            letter.deleteCharAt(letter.length()-1);
        }

    }

}
