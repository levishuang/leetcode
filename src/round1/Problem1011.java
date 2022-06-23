package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/20 21:29
 */
//为什么使用 <= 就会出问题呢？？？？
public class Problem1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int left = 1, right = Integer.MAX_VALUE;
        int max = 0;
        for (int weight : weights) {
            max = max > weight ? max : weight;
        }
        left = max;
        while (left < right) {
            int middle = left + (right - left) / 2;
//            System.out.println(f(weights, middle));
//            System.out.println("left:" + left + "   " + "middle:" + middle + "   " + "right:" + right);
            if (f(weights, middle) > days) {
                left = middle + 1;
            } else if (f(weights, middle) <= days) {
                right = middle;
            }
        }
        return left;
    }

    /**
     * @param weights
     * @param k       每天运送的重量
     * @return
     */
    public static int f(int[] weights, int k) {
        int days = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; ) {
            sum += weights[i];
            //如果总重量大于等于m
            if (sum > k) {
                days++;
                sum = 0;
            } else if (sum == k) {
                days++;
                i++;
                sum = 0;
            } else {
                i++;
            }
        }
        if(sum > 0) days++;
        return days > 0 ? days : 1;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        System.out.println(shipWithinDays(weights, 4));
//        System.out.println(f(weights, 3));

    }
}
