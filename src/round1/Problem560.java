package round1;

import netscape.security.UserTarget;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/16 11:16
 */

public class Problem560 {

    //    public static int subarraySum(int[] nums, int k) {
//        int[][] numsubSum = new int[nums.length][nums.length+1];
//        boolean[][] memo = new boolean[nums.length][nums.length+1];
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i; j < nums.length; j++){
//                numsubSum[i][j+1] = numsubSum[i][j] + nums[j];
//                memo[i][j+1] = true;
//                System.out.print(numsubSum[i][j+1] + " ");
//            }
//            System.out.println();
//        }
//        int count = 0;
//        for(int i = 0; i < numsubSum.length; i++){
//            for(int j = 0;j < numsubSum[0].length; j++){
//                if(numsubSum[i][j] == k && memo[i][j] == true){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
    public static int subarraySum(int[] nums, int k) {
        int[] presum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for(int i = 1; i < presum.length; i++){
            for(int j = 0; j < i; j++){
                if(presum[i] - presum[j] == k){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(subarraySum(nums, 1));
    }
}
