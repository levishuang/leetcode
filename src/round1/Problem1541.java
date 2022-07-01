package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/1 9:46
 */

public class Problem1541 {
    public static int minInsertions(String s) {
        int need = 0, insert = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                need += 2;
                if(need % 2 == 1){
                    //插入一个 ）
                    insert++;
                    //减少一个 ）
                    need--;
                }
            }
            if(c == ')'){
                need--;
                if(need == -1){
                    //插入一个 (
                    insert++;
                    //需要一个 )
                    need = 1;
                }
            }
        }
        return need + insert;
    }

    public static void main(String[] args) {
        String s = ")))";
        System.out.println(minInsertions(s));

    }
}
