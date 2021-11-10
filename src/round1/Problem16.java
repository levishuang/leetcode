package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/11/8 20:54
 */

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        long sum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1;k < nums.length; k++){
                    int temp = nums[i]+nums[j]+nums[k];
                    sum = Math.abs(temp-target) > Math.abs(sum - target) ? sum : temp;
                }
            }
        }
        return (int) sum;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length; i++){
            int l = i+1;
            int h = nums.length-1;
            while (l < h){
                int sum = nums[i]+nums[l]+nums[h];
                if(Math.abs(result-target) > Math.abs(sum-target)){
                    result = sum;
                }
                if(sum > target){
                    h--;
                }
                if(sum < target){
                    l++;
                }
                if(sum ==target){
                    return target;
                }
            }
        }
        return result;
    }

}
