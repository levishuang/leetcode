package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double[] num = new double[len1+len2];
        for(int i = 0; i < len1; i++){
            num[i] = nums1[i];
        }
        for (int i = len1; i < len1+len2; i++){
            num[i] = nums2[i-len1];
        }

        Arrays.sort(num);
        if (num.length % 2 == 1){
            return num[num.length/2];
        }else {
            return (num[num.length/2]+num[num.length/2 - 1])/2;
        }
    }
    public static void main(String[] args){
    int[] num1 = {1,2};
    int[] num2 = {3,4};

        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
