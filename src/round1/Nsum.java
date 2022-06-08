package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/8 11:21
 */

public class Nsum {
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target){
        int sz = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 2 || sz < n){
            return ans;
        }
        if(n == 2){
            int low = start, high = sz - 1;
            while (low < high){
                int sum = nums[low] + nums[high];
                int left = nums[low], right = nums[high];
                if(sum < target){
                    while (low < high && nums[low] == left){
                        low++;
                    }
                }else if(sum > target){
                    while (low < high && nums[high] == right){
                        high--;
                    }
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    ans.add(list);
                    while (low < high && nums[low] == left){
                        low++;
                    }
                    while (low < high && nums[high] == right){
                        high--;
                    }
                }
            }
        }else {
            for(int i = start; i < sz; i++){
                for (List<Integer> list : nSumTarget(nums, n - 1, i + 1, target - nums[i])) {
                    list.add(nums[i]);
                    ans.add(list);
                }
                while (i < sz-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,5,2,5,6,4};
        Arrays.sort(nums);
        for (List<Integer> list : nSumTarget(nums, 3, 0, 8)) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

}
