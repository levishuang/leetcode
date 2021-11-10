package round1;

import java.util.*;

/**
 * @package: round1
 * @Description:不要用暴力破解了！！！！！！
 * @author: jilai_huang
 * @date: 2021/11/8 19:32
 */

public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int H = len - 1;
            if (nums[i] > 0) {
                return result;
            }
            //把i>0放在前面是为了防止数组越界，同时也可以避免重复计算
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (L < H) {
                if (nums[i] + nums[L] + nums[H] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[H]);
                    result.add(list);
                    //排除后面flag重复的情况
                    while(L < H && nums[H] == nums[H-1]) H--;
                    //排除前面flag重复的情况
                    while(L < H && nums[L] == nums[L+1]) L++;
                    L++;
                    H--;
                } else if (nums[i] + nums[L] + nums[H] > 0) {
                    H--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-2,0,0,2,2,2};
        List<List<Integer>> result = threeSum(nums);
        Iterator<List<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
