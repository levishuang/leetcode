package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/11/10 11:34
 * @Author: Jilai Huang
 */
public class Problem17 {
    //可以用数组下标进行对应的就用数组下标
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuffer letter = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 ){
            return res;
        }
        iterator(digits, letter, 0);
        return res;
    }
    public void iterator(String digits, StringBuffer letter, int index){
        //退出递归的位置
        if(index == digits.length()){
            res.add(letter.toString());
            return;
        }
        char c = digits.charAt(index);
        //取到index对应的字符串
        String s = strs[c-'0'];
        for(int i = 0; i < s.length(); i++){
            //分别取字符串的每一个字符
            letter.append(s.charAt(i));
            iterator(digits, letter, index+1);
            //每次递归完成后把最后一个字符删除，如ad，将d删除后再进行下一轮的加e
            letter.deleteCharAt(letter.length()-1);

        }

    }

}
