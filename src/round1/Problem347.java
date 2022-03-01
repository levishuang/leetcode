package round1;

import java.util.*;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/26 16:02
 */

public class Problem347 {
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num :nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        System.out.println(map);
        int[] res = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        //利用小顶堆找出前k个
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        int j = 0;
        while (!priorityQueue.isEmpty()){
            res[j] = priorityQueue.peek();
            priorityQueue.poll();
            j++;
        }
        return res;

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int key:frequencyForNum.keySet()){
            int frenquency = frequencyForNum.get(key);
            if(buckets[frenquency] == null){
                buckets[frenquency] = new ArrayList<>();
            }
            buckets[frenquency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for(int i = buckets.length-1; i >=0 && topK.size() < k; i--){
            if(buckets[i] == null){
                continue;
            }
            if(buckets[i].size() <= (k-topK.size())){
                topK.addAll(buckets[i]);
            }else{
                topK.addAll(buckets[i].subList(0, k- topK.size()));
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = topK.get(i);
        }
        return res;
    }


    //桶算法
    public static int[] topKFrequent2(int[] nums, int k){
        int[] ans = new int[k];
        //统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        //使用数组链表将数字根据频率分类
        List<Integer>[] lists = new ArrayList[nums.length+1];
        for(int key:map.keySet()){
            int frequency =  map.get(key);
            if(lists[frequency]  == null){
                lists[frequency] = new ArrayList<>();
            }
            lists[frequency].add(key);

        }
        List<Integer> topK = new ArrayList<>();
        for (int i = nums.length; i >= 0 && topK.size() < k; i--){
            if(lists[i] == null){
                continue;
            }else if(lists[i].size() <= k-topK.size()){
                topK.addAll(lists[i]);
            }else{
                topK.addAll(lists[i].subList(0, k-topK.size()));
            }
        }
        int i =0;
        for (Integer integer : topK) {
            ans[i] = integer;
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3};
//        System.out.println(topKFrequent2(nums,1));

        int[] ans = topKFrequent1(nums, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
