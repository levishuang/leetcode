package round1;

import java.util.Arrays;

//暴力方法不可取，多想想其他方法
public class Problem11 {
//    public static int maxArea(int[] height) {
//        int min = 0;
//        int max = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                min = height[i] > height[j] ? height[j] : height[i];
//                int area = min * (j - i);
//                max = area > max ? area : max;
//            }
//        }
//        return max;
//    }
    public static int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int ans = 0;
        while(low < high){
            ans = Math.max(ans, (high-low)*Math.min(height[low], height[high]));
            if (height[low] < height[high]){
                low++;
            }else {
                high--;
            }
        }
        return ans;
    }

    public static int maxArea2(int[] height){
        int low = 0;
        int high = height.length-1;
        int maxArea = 0;
        while(low < high){
            maxArea = Math.max(maxArea, (high-low)*Math.min(height[low], height[high]));
            if(height[low] < height[high]){
                low++;
            }else {
                high--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height));
    }
}
