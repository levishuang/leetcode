package round1;


/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/29 17:23
 */

public class Problem303_3 {
    public static int[] getArrays(int n, int[][] updates){
        int[] nums = new int[n];
        int[] diff = new int[n];
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            diff[i] += val;
            if(j +1 < n){
                diff[j+1] -= val;
            }
        }
        nums[0] = diff[0];
        for(int k = 1; k < n; k++){
            nums[k] = nums[k-1] + diff[k];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] updates = {
                {1,3,2},
                {2,4,3},
                {0,2,-2}
        };
        int[] arrays = getArrays(5, updates);
        for (int array : arrays) {
            System.out.println(array);
        }
    }
 }
