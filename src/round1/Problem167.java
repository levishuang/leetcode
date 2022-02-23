package round1;

/**
 * @package: round1
 * @Description:双指针！！！！
 * @author: jilai_huang
 * @date: 2022/2/22 20:30
 */

public class Problem167 {
    public static int[] twoSum1(int[] numbers, int target) {
        int[] answer = {0, 0};
        boolean flag = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!flag) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] < target) {
                    continue;
                } else if (numbers[i] + numbers[j] == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    flag = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] answer = twoSum2(nums, 9);
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
    //双指针的方法
    private static int[] twoSum(int[] nums, int i) {
        int[] answer = {0, 0};
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            if(nums[low] + nums[high] == i){
                answer[0] = low+1;
                answer[1] = high+1;
                break;
            }
            else if(nums[low] + nums[high] < i){
                low++;
            }else {
                high--;
            }
        }
        return answer;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        if(numbers == null) return null;
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            }else if(sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }

}
