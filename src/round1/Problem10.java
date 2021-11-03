package round1;

/**
 * @Package: round1
 * @Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * @Date: 2021/11/2 10:44
 * @Author: Jilai Huang
 */
public class Problem10 {
    //s代表原字符串，p代表需要匹配的字符串
    public static boolean isMatch(String s, String p) {
        boolean table[][] = new boolean[s.length() + 1][p.length() + 1];
        //对初始化状态转移表的第一行进行赋值
        table[0][0] = true;
        for (int col = 1; col < table[0].length; col++) {
            char ch = p.charAt(col-1);
            if (col > 1) {
                if (ch == '*') {
                    table[0][col] = table[0][col - 2];
                } else {
                    table[0][col] = false;
                }
            } else {
                if (ch == '*') {
                    table[0][col] = true;
                }
            }
        }
        //对第二行起的状态转移方程进行赋值处理
        for(int row = 1; row < table.length; row++){
            char ch1 = s.charAt(row-1);//取出原字符串的每一个字符
            for(int col = 1; col < table[row].length; col++){
                char ch2 = p.charAt(col-1);//取出需要匹配的字符串的每一个字符
                if(ch1 == ch2 || ch2 == '.'){ //字符相等或者遇到.字符时，比较前面的字符串
                    table[row][col] = table[row-1][col-1];
                }else if(ch2 == '*'){
                    if(col > 1){
                        if(table[row][col-2]){
                            table[row][col] = true;//模拟0个字符，相当于把前一个字符去掉，所以比较前两个字符
                        }else {
                            char prev = p.charAt(col-2);//取需要匹配的前一个前一个字符
                            if(prev == ch1 || prev == '.'){
                                table[row][col] = table[row-1][col];//模拟前面的*出现多次
                            }
                        }
                    }

                }
            }
        }
        boolean lastRow[] = table[table.length-1];
        return lastRow[lastRow.length-1];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

}
