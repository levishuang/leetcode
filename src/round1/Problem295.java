package round1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/9 20:25
 */

public class Problem295 {
    static class MedianFinder {
        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            //小顶堆
            large = new PriorityQueue<>();
            //大顶堆
            small = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if(small.size() >= large.size()){
                small.offer(num);
                large.offer(small.poll());
            }else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if(large.size() > small.size()){
                return large.peek();
            }else if(small.size() > large.size()){
                return small.peek();
            }
            return (large.peek() + small.peek())/2.0;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double a = medianFinder.findMedian();
        System.out.println(a);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());


    }
}
