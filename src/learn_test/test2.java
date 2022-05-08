package learn_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/24 15:11
 */

public class test2 {


    static int solve(int[] arr, int n, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            map.put(i, 0);
        }
        for (int i : arr) {
            if(map.containsKey(m - i) && map.get(m - i) == 0){
                count++;
                map.replace(i, 0, 1);
                map.replace(m - i, 0, 1);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        System.out.println(n);
//        System.out.println(m);
//        for (int num : nums) {
//            System.out.println(num);
//        }
        System.out.println(solve(nums, n, m));

    }
}
