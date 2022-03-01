package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/24 17:01
 */

public class Problem88 {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
        int[] temp = new int[m+n];
        int location = 0;
        if(m != 0 && n != 0){
//            for(int i = 0; i < n; i++){
//                nums1[m+i] = nums2[i];
//            }
//            Arrays.sort(nums1);
            int i = 0, j = 0;
            while(i < m && j < n){
                if(nums1[i] <= nums2[j]){
                    temp[location++] = nums1[i++];
                }else{
                    temp[location++] = nums2[j++];
                }
            }
            while(i < m){
                temp[location++] = nums1[i++];
            }
            while(j < n){
                temp[location++] = nums2[j++];
            }
        }
        nums1 = temp;
        for (int x : nums1) {
            System.out.println("*" + x);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] temp = merge(nums1, 3, nums2, 3);
        for (int x:temp) {
            System.out.println(x);
        }
    }
}
