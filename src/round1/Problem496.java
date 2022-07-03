package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/1 10:38
 */

public class Problem496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[n1];
        for(int i = 0; i < n1; i++){
            int temp = nums1[i];
            int index = -1;
            //找到对应数值的下标
            for(int j = 0; j < n2; j++){
                if(temp == nums2[j]){
                    index = j;
                    break;
                }
            }
            if(index == n2-1) ans[i] = -1;
            for(int j = index+1; j < n2; j++){
                if(nums2[j] > temp){
                    ans[i] = nums2[j];
                    break;
                }else {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        for (int i : nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }

    }

}
