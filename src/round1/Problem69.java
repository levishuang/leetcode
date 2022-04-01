package round1;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/27 22:37
 */

public class Problem69 {
    public static int mySqrt(int x) {
        if (x < 3) return 1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int sqrt = x / middle;
            if (sqrt == middle) {
                return middle;
            } else if (sqrt < middle) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
}
