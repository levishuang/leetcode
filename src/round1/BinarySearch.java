package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/27 22:25
 */

public class BinarySearch {
    public static int binarySearch(int[] nums, int num){
        int low = 0;
        int high = nums.length-1;
        int middle = -1;
        while(low <= high){
            middle = (low+high)/2;
            if(nums[middle] == num){
                break;
            }else if(nums[middle] > num){
                high--;
            }else {
                low++;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        System.out.println(binarySearch(nums, 3));
    }
}
