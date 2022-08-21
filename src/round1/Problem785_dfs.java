package round1;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 15:42
 */

public class Problem785_dfs {
    static boolean[] visited;
    static boolean[] colored;
    static boolean res = true;

    public static boolean isBipartite(int[][] graph) {
        int num = graph.length;
        visited = new boolean[num];
        colored = new boolean[num];
        for (int i = 0; i < num; i++) {
            dfs(graph, i);
        }
        return res;
    }

    public static void dfs(int[][] graph, int s) {
        //如果被访问过了
        if (visited[s] || !res) {
            return;
        }
        visited[s] = true;
        for (int i : graph[s]) {
            //如果没有访问到就涂不一样的颜色
            if (!visited[i]) {
                colored[i] = !colored[s];
                dfs(graph, i);
            } else {
                if (colored[i] == colored[s]) {
                    res = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }
}
