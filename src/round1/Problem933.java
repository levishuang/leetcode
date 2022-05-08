package round1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 13:12
 */


class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(true){
            if(queue.peek() < t-3000){
                queue.poll();
            } else {
                break;
            }
        }

        return queue.size();
    }
}
public class Problem933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(642));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));
        System.out.println(recentCounter.ping(5936));
        System.out.println(recentCounter.ping(5957));

    }
}
