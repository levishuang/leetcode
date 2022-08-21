package round1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 17:48
 */

public class Problem886_bfs {
    static boolean[] visited;
    static boolean[] colored;

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n];
        colored = new boolean[n];
        int[][] graph = buildGraph(dislikes, n);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                queue.add(i);
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();
                    //处理临界点
                    for (int j : graph[poll]) {
                        if(!visited[j]){
                            visited[j] = true;
                            colored[j] = !colored[poll];
                            queue.add(j);
                        }else {
                            if(colored[j] == colored[poll]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    //无向图, 并将数字大小减一
    public static int[][] buildGraph(int[][] dislikes, int n) {
        int[][] graph = new int[n][];
        List<Integer>[] tempGraph = new List[n];
        for (int i = 0; i < n; i++) {
            tempGraph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            int from = dislike[0]-1, to = dislike[1]-1;
            tempGraph[from].add(to);
            tempGraph[to].add(from);
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[tempGraph[i].size()];
            for (int j = 0; j < tempGraph[i].size(); j++) {
                int num = tempGraph[i].get(j);
                graph[i][j] = num;
            }
        }
        return graph;
    }
    public static void main(String[] args) {
//        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
//        int[][] dislikes = {{1,2}, {1,3}, {1,4}, {1,5}};
        int[][] dislikes = {{1,2}, {1,3}, {2,3}};
        System.out.println(possibleBipartition(5, dislikes));
    }

}
