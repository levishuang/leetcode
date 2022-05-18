package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/17 14:45
 */

public class Problem1109 {
//    private static int[] ans;

//    public static int[] corpFlightBookings(int[][] bookings, int n) {
//        //创建结果数组
//        int[] ans = new int[n];
//        for (int i = 0; i < bookings.length; i++) {
//            //序列从1开始，所以默认减一
//            increaseArr(bookings[i][0]-1, bookings[i][1] - 1, bookings[i][2], ans);
//        }
//        return ans;
//    }

//    private static void increaseArr(int i, int j, int seat, int[] ans) {
//        int n = ans.length;
//        int[] diff = new int[n];
//        //生成差分数组
//        diff[0] = ans[0];
//        for (int k = 1; k < n; k++) {
//            diff[k] = ans[k] - ans[k - 1];
//        }
//        //修改差分数组的值
//        diff[i] += seat;
//        if (j + 1 < n) {
//            diff[j + 1] -= seat;
//        }
//        ans[0] = diff[0];
//        for(int k = 1; k < n; k++){
//            ans[k] = ans[k-1] + diff[k];
//        }
////        System.out.println("------------------------");
////
////        for(int k = 0; k < n; k++){
////            System.out.print(ans[k] + ", ");
////        }
////        System.out.println();
////
////        System.out.println("------------------------");
//    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        //创建结果数组
        int[] ans = new int[n];
        //生成差分数组
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1];
            int val = booking[2];
            diff[i] += val;
            if (j < n) {
                diff[j] -= val;
            }
        }
        ans[0] = diff[0];
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] + diff[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25},
        };
        for (int i : corpFlightBookings(bookings, 5)) {
            System.out.println(i);
        }

    }
}
