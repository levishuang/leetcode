package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/17 21:00
 */

public class Problem1094 {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] ans = new int[1001];
        //构造差分函数
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2];
            diff[i] += val;
            diff[j] -= val;
        }
        ans[0] = diff[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
            if (ans[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {
                {9,0,1},
                {3,3,7}
        };
        System.out.println(carPooling(trips, 4));
    }
}
