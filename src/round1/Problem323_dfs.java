package round1;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/25 17:56
 */

public class Problem323_dfs {
//    是否访问过
    static boolean[] visited;
//    是否在路径上
    static boolean[] onPath;
    public static int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        onPath = new boolean[n];
        int[][] graph = createGraph(n, edges);
        //记录联通分量的次数
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                traverse(graph, i);
            }
        }
        return count;
    }

    //dfs遍历
    public static void traverse(int[][] graph, int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        //遍历s的子节点
        for (int i : graph[s]) {
            traverse(graph, i);
        }
        onPath[s] = false;
    }

    public static int[][] createGraph(int n, int[][] edges) {
        int[][] graph = new int[n][];
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            list[from].add(to);
            list[to].add(from);
        }
        //链表转化为数组
        for (int i = 0; i < n; i++) {
            int len = list[i].size();
            graph[i] = new int[len];
            for (int j = 0; j < len; j++) {
                graph[i][j] = list[i].get(j);
            }
        }
        return graph;
    }


    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {0, 1},
                {3, 4}
        };
//        int[][] graph = createGraph(4, edges);
//        for (int[] ints : graph) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
        System.out.println(countComponents(5, edges));
    }
}
