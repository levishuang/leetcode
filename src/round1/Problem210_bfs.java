package round1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 14:07
 */

public class Problem210_bfs {
    static List<Integer>[] graph;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化统计每个节点的入度
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            indegree[to]++;
        }
        //寻找入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        //进行bfs循环
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()){
            int var = queue.poll();
            res[count] = var;
            count++;
            for (Integer integer : graph[var]) {
                indegree[integer]--;
                if(indegree[integer] == 0){
                    queue.add(integer);
                }
            }
        }
        //存在环
        if(count != numCourses){
            return new int[]{};
        }
        return res;

    }

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
