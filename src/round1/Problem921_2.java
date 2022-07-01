package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/1 9:37
 */

public class Problem921_2 {

    public static int minAddToMakeValid(String s) {
        //need是匹配（ , insert是匹配 ）
        int need = 0, insert = 0;
        for (char c : s.toCharArray()) {
            //当遇到（时need++
            if(c == '('){
                need++;
            }
            if(c == ')'){
                need--;
                if(need == -1){
                    need = 0;
                    insert++;
                }
            }
        }
        return need+insert;
    }

    public static void main(String[] args){
        String s = "((()(";
        System.out.println(minAddToMakeValid(s));
    }
}
