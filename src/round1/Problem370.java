package round1;

/**
 * @package: round1
 * @Description:差分算法
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k个更新的操作。
 *
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 *
 * 请你返回 k 次操作后的数组。
 * @author: jilai_huang
 * @date: 2022/5/17 11:46
 */

public class Problem370 {
    /**
     *
     * @param n 初始数组长度
     * @param i  需要增加的开始下标
     * @param j  结束下标
     * @param inc 增量
     * @return
     */
    public static int[] rangeAddition(int n, int i, int j, int inc){
        int[] nums = new int[n];
        int[] res = increaseArray(nums, i, j, inc);
        return res;
    }

    private static int[] increaseArray(int[] nums, int i, int j, int inc) {
        int n = nums.length;
        int[] diff = new int[n];
        diff[0] = nums[0];
        //创建差分数组
        for(int k = 1; k < n; k++){
            diff[k] = nums[k] - nums[k-1];
        }
        //对[i, j]范围内的数进行增量处理
        diff[i] += inc;
        if(j + 1 < n){
            diff[j+1] -= inc;
        }
//        System.out.println("diff:");
//        for (int i1 : diff) {
//            System.out.println(i1);
//        }
        for(int k = 1; k < n; k++){
            nums[k] = nums[k-1] + diff[k];
        }
        return nums;
    }

    public static void main(String[] args) {
        for (int i : increaseArray(new int[]{1,3,2,4,5}, 1, 3, 2)) {
            System.out.println(i);
        }
    }


}
