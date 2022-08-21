package round1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 16:17
 */

public class Problem886_dfs {
    static boolean[] visited;
    static boolean[] colored;
    static boolean ok = true;

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] graph = buildGraph(dislikes, n);
        visited = new boolean[n];
        colored = new boolean[n];
        //对每个节点进行遍历
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                traverse(graph, i);
            }
        }
        return ok;
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

    //dfs遍历
    public static void traverse(int[][] graph, int s){
        //如果节点被访问或者二分图不成立
        if(!ok){
            return;
        }
        visited[s] = true;
        for (int i : graph[s]) {
            //如果没有访问过，染色
            if(!visited[i]){
                colored[i] = !colored[s];
                traverse(graph, i);
            }else {
                //比较是否符合二分图
                if(colored[s] == colored[i]){
                    ok = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        int[][] dislikes = {{1,2}, {1,3}, {1,4}, {1,5}};
        System.out.println(possibleBipartition(5, dislikes));
    }
}
