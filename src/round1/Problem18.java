package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/11/10 16:00
 */

public class Problem18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j < nums.length-1; j++){
                if((j > i+1 && nums[j] == nums[j-1])){
                    continue;
                }
                int L = j+1;
                int H = nums.length-1;
                while(L < H){
                    int sum = nums[i] + nums[j] + nums[L]+ nums[H];
                    if( sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[L]);
                        temp.add(nums[H]);
                        res.add(temp);
                        while (L < H && nums[H] == nums[H-1]) H--;
                        while (L < H && nums[L] == nums[L+1]) L++;
                        L++;
                        H--;
                    }else if(sum > target){
                        H--;
                    }else {
                        L++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> res = fourSum(nums, target);
        Iterator<List<Integer>> iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}
