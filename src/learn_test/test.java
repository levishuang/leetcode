package learn_test;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/24 14:53
 */

public class test {

    public static String add(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? getInt(a.charAt(i)) : 0;
            int y = j >= 0 ? getInt(b.charAt(j)) : 0;
            int sum = x + y + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    public static int getInt(char c) {
        if (c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }

    public static void main(String[] args) {
        String a  = "abbbb";
        String b = "1";
        System.out.println(add(a, b));

    }
}
