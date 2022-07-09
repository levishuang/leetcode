package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/9 17:07
 */

public class Problem380 {
    static class RandomizedSet {
        HashMap<Integer, Integer> val2Index;
        List<Integer> nums;


        public RandomizedSet() {
            val2Index = new HashMap<>();
            nums = new ArrayList<>();
        }

        public boolean insert(int val) {
            //如果包含val，则返回false
            if(val2Index.containsKey(val)){
                return false;
            }
            //加入
            val2Index.put(val, nums.size()-1);
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!val2Index.containsKey(val)){
                return false;
            }
            //获取元素原来的位置，并与链表的最后一个数进行交换
            int index = val2Index.get(val);
            int lastNum = nums.get(nums.size()-1);
            nums.set(index, lastNum);
            val2Index.put(lastNum, index);
            val2Index.put(val, nums.size()-1);
            //删除
            val2Index.remove(val);
            nums.remove(nums.size()-1);
            return true;


        }

        public int getRandom() {
            Random random = new Random();
            return nums.get(random.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
