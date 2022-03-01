package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: round1
 * @Description:这个好像也可以用桶排序解决？不需要
 * @author: jilai_huang
 * @date: 2022/2/28 21:27
 */

public class Problem75 {
    //用个map存储一下次数，因为元素较少不需要桶排序
    public static void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(key == 0){
                for (int j = 0; j < frequency; j++) {
                    stringBuffer.append(key);
                }
            }else if(key == 1){
                for (int j = 0; j < frequency; j++) {
                    stringBuffer.append(key);
                }
            }else {
                for (int j = 0; j < frequency; j++) {
                    stringBuffer.append(key);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stringBuffer.toString().charAt(i) - '0';
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    //快速排序
    public static void sortColors1(int[] nums) {


    }

    public static void quickSort(int[] nums, int i, int j){
//        int low = i, high = j;
//        int temp = nums[low];
//        if(low < high){
//            while(low < high && nums[high] >= temp){
//                high--;
//            }
//            nums[low] = nums[high];
//            while(low < high && nums[low] <= temp){
//                low++;
//            }
//            nums[high] = nums[low];
//        }else {
//            return;
//        }
//        nums[low] = temp;
//        quickSort(nums,i, low-1 );
//        quickSort(nums, low+1, j);
        int low = i, high = j;
        int temp = nums[low];
        if(low < high){
            while (nums[high] >= temp && low < high){
                high--;
            }
            nums[low] = nums[high];
            while (nums[low] <= temp && low < high){
                low++;
            }
            nums[high] = nums[low];
        }else {
            return ;
        }
        if(low > high) return;
        nums[low] = temp;
        quickSort(nums, i, low-1);
        quickSort(nums, low+1, j);

    }

    public static void main(String[] args) {
        int[] nums = { 1,2,0,0};
        quickSort(nums, 0, nums.length-1);
        for(int num:nums){
            System.out.println(num);
        }
    }

}
