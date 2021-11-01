package round1;
;

/**
 * @package: round1
 * @Description:
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jilai_huang
 * @date: 2021/11/1 20:25
 */

public class Problem8 {
    public static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int flag = 1;
        long result = 0;
        if (chars[0] >= 'a' && chars[0] <= 'z') return 0; //排除非数字字符
        StringBuffer stringBuffer = new StringBuffer();
        if (chars[0] == '-'){
            flag = -1;  //负数标志
            for (int i = 0; i < chars.length-1 && chars[i+1] >= '0' && chars[i+1] <= '9'; i++){
                stringBuffer.append(chars[i+1] - '0');
            }
            result = charsToNums(stringBuffer.toString().toCharArray())*flag;
        }else if(chars[0] == '+'){
            for (int i = 0; i < chars.length-1 && chars[i+1] >= '0' && chars[i+1] <= '9'; i++){
                stringBuffer.append(chars[i+1] - '0');
            }
            result = charsToNums(stringBuffer.toString().toCharArray());
        }
        else {
            for (int i = 0; i < chars.length && chars[i] >= '0' && chars[i] <= '9'; i++){
                stringBuffer.append(chars[i] - '0');
            }
            result = charsToNums(stringBuffer.toString().toCharArray());
        }
        if(result < Math.pow(-2, 31)){
            return (int) Math.pow(-2, 31);
        }else if(result > Math.pow(2, 31) - 1){
            return (int) Math.pow(2, 31);
        }else {
            return (int)result;
        }

    }
    public static long charsToNums(char[] chars){
        int len = chars.length;
        long result = 0;
        for(int i = 0; i < chars.length; i++){
            double temp = Math.pow(10,len-1);
            result += (chars[i] - '0')*temp;
            len--;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "21474836460";
        System.out.println(myAtoi(s));
    }
}
