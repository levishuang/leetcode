package round1;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/17 16:09
 */

public class Problem34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(index == -1){
            return ans;
        }
        //查找前面的第一个元素
        while (true){
            if(index != 0 && nums[index-1] == target){
                index--;
            }else {
                break;
            }
        }
        ans[0] = index;
        //查找后面的第一个元素
        while (true){
            if(index != nums.length-1 && nums[index+1] == target){
                index++;
            }else {
                break;
            }
        }
        ans[1] = index;
        return ans;
    }

    public static void main(String[] args) {

        int nums[] = {5,7,7,8,8,10};
        int target = 8;
        int ans[] = searchRange(nums, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
